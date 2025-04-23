package com.project2.worklet.jobPostingService;



import com.project2.worklet.command.JobPostingDetailVO;
import com.project2.worklet.command.JobPostingVO2;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


@Service("JobPosting")
public class JobPostingServiceImpl implements JobPostingService {

    @Autowired
    private JobPostingMapper mapper;

    private final static Logger logger = LoggerFactory.getLogger(JobPostingServiceImpl.class);

    private final String basicUrlL = "https://www.work24.go.kr/cm/openApi/call/wk/callOpenApiSvcInfo210L21.do?authKey=";
    private final String basicUrlD = "https://www.work24.go.kr/cm/openApi/call/wk/callOpenApiSvcInfo210D21.do?authKey=";
    private final String key = "a9f4eb74-7618-4fd6-a80b-4a6a7fff0190";


    @Override
    public int selectSeqMax() {
        return mapper.selectSeqMax();
    }

    @Override
    public String postList() {

        StringBuilder sb = new StringBuilder(basicUrlL);
        String url = sb.append(key).append("&callTp=L&returnType=XML&startPage=1&display=100").toString();
        List<JobPostingVO2> list = new ArrayList<>();
        List<String> seqList = new ArrayList<>();
        int result = 1230;
        int detailResult = 1230;
        String finalResult = "";

        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            String xml = response.body();
            JSONObject jsonObject = XML.toJSONObject(xml);
            JSONObject jsonList = jsonObject.getJSONObject("dhsOpenEmpInfoList");

            int maxSeq = mapper.selectSeqMax();

            Object empInfo = jsonList.get("dhsOpenEmpInfo");
            JSONArray infos = empInfo instanceof JSONArray ? (JSONArray) empInfo : new JSONArray().put(empInfo);

            for (int i = 0; i < infos.length(); i++) {
                JSONObject obj = infos.getJSONObject(i);
                if (Integer.parseInt(obj.optString("empSeqno")) > maxSeq) {
                    seqList.add(obj.optString("empSeqno"));

                    JobPostingVO2 vo2 = new JobPostingVO2();
                    vo2.setEmpSeqno(Integer.parseInt(obj.optString("empSeqno")));
                    vo2.setEmpWantedTitle(obj.optString("empWantedTitle"));
                    vo2.setEmpBusiNm(obj.optString("empBusiNm"));
                    vo2.setEmpWantedStdt(obj.optString("empWantedStdt"));
                    vo2.setEmpWantedEndt(obj.optString("empWantedEndt"));
                    vo2.setEmpWantedTypeNm(obj.optString("empWantedTypeNm"));
                    vo2.setRegLogImgNm(obj.optString("regLogImgNm"));
                    vo2.setEmpWantedHomepgDetail(obj.optString("empWantedHomepgDetail"));

                    list.add(vo2);
                }
            }

            result = mapper.postList(list);
            detailResult = postDetail(seqList);
            finalResult = "리스트 저장 결과 : "+result+" 디테일 저장 결과 : "+detailResult;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return finalResult;
    }

    @Override
    public int postDetail(List<String> list) {

        StringBuilder sb = new StringBuilder(basicUrlL);
        String url = sb.append(key).append("&callTp=L&returnType=XML&empSeqno=").toString();
        List<JobPostingDetailVO> dlist = new ArrayList<>();
        int result = 4;

        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            for(int j = 0; j<list.size(); j++) {
                String seqNo = list.get(j);
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                JSONObject jsonObject = XML.toJSONObject(response.body());
                JSONObject jsonDetailList = jsonObject.getJSONObject("dhsOpenEmpInfoDetailRoot");

                int empSeqno = Integer.parseInt(jsonDetailList.getString("empSeqno"));

                JSONObject empRecr = jsonDetailList.getJSONObject("empRecrList").getJSONObject("empRecrListInfo");
                String empRecrNm = empRecr.getString("empRecrNm");
                String empWantedCareerNm = empRecr.getString("empWantedCareerNm");
                String workRegionNm = empRecr.getString("workRegionNm");

                JSONObject empJobs = jsonDetailList.getJSONObject("empJobsList").getJSONObject("empJobsListInfo");
                int jobsCd = Integer.parseInt(empJobs.getString("jobsCd"));
                String jobsCdKorNm = empJobs.getString("jobsCdKorNm");

                JobPostingDetailVO detail = new JobPostingDetailVO(null, empSeqno, empRecrNm, empWantedCareerNm, workRegionNm,
                                                                    jobsCd, jobsCdKorNm);
                dlist.add(detail);
            }
            result = mapper.postDetail(dlist);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}




//    @Override
//    public String getApi() {
//
//        StringBuilder sb = new StringBuilder(basicUrl);
//        String url = sb.append(key).append("&callTp=L&returnType=XML&startPage=1&display=10").toString();
//
//        try {
//            // HttpClient 생성
//            HttpClient httpClient = HttpClient.newHttpClient();
//
//            // HttpRequest 생성
//            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
//
//            // 요청 보내고 응답 받기 (동기 방식)
//            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//
//            // 2. XML을 JSON으로 변환
//            String xml = response.body();
//            JSONObject jsonObject = XML.toJSONObject(xml);
//
//            // 들여쓰기 2칸
//            System.out.println(jsonObject.toString(2));
//
//            // 응답 출력
//            System.out.println("Status Code: " + response.statusCode());
//            System.out.println("Response Body:");
//            System.out.println(response.body());
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return "됨?";
//    }