
const plusBtn = document.querySelectorAll('.plus figure');
const addEduForm = document.querySelectorAll('.add-edu-form');
const cancelBtn = document.querySelectorAll('.btn-del');
const sec03BtnSave = document.querySelector('.sec03 .btn-save');
const sec04BtnSave = document.querySelector('.sec04 .btn-save');
const education = document.querySelectorAll('.education');
const schoolList = document.querySelector(".school-list");
const comList = document.querySelector(".com-list");

// 추가 버튼 클릭 시 해당 섹션의 폼만 열기
plusBtn.forEach((btn) => {
    btn.addEventListener('click', () => {
        const section = btn.closest('section'); // 해당 버튼이 속한 섹션
        const form = section.querySelector('.add-edu-form');
        form.classList.add('add');
        form.style.display = 'block'; // 또는 'flex', 상황에 따라
    });
});

// 취소 버튼 클릭 시 해당 섹션의 폼만 닫기
cancelBtn.forEach((btn) => {
    btn.addEventListener('click', () => {
        const form = btn.closest('.add-edu-form');
        form.classList.remove('add');
        form.style.display = 'none';
    });
});


sec03BtnSave.addEventListener('click', function () {
    let schoolName = document.querySelector("input[name='school-name']").value;
    let major = document.querySelector("input[name='major']").value;
    let part = document.querySelector(".part").value;
    let draduation = document.querySelector(".draduation").value;

    console.log(schoolName);
    console.log(major);
    console.log(part);
    console.log(draduation);

    if (!schoolName || !major || !part || !draduation) {
        alert('학교명, 이수형태, 학력구분, 졸업여부를 모두 입력해주세요.');
        return;
    }
})


sec04BtnSave.addEventListener('click', function () {
    let companyName = document.querySelector(".company-name").value;
    let department = document.querySelector(".department").value;
    let joinDate = document.querySelector("input[name='join-date']").value;
    let quitDate = document.querySelector("input[name='quit-date']").value;
    let position = document.querySelector("input[name='position']").value;

    console.log(companyName);
    console.log(department);
    console.log(joinDate);
    console.log(quitDate);
    console.log(position);


    if (!department || !joinDate || !quitDate || !position) {
        alert('부서, 입사일, 퇴사일, 직급 모두 입력해주세요.');
        return;
    }

    const div = document.createElement('div');
    div.classList.add('education', 'flex');
    div.innerHTML = `
     <div class="school">
                        <h4>${companyName}</h4>
                        <p>${department}</p>
                    </div>
                    <div class="edu-info">
                        <span>${joinDate} ~ ${quitDate}</span>
                        <span>${position}</span>
                    </div>
                    <img src="./image/pencil.png" alt="">
`;

    comList.appendChild(div);

    document.querySelector('.company-name').value = '';
    document.querySelector('.department').value = '';
    document.querySelector('input[name="join-date"]').value = '';
    document.querySelector('input[name="position"]').value = '';
    document.querySelector('.sec04 textarea').value = '';
    document.querySelector('#charCount').textContent = '0';

    // 폼 숨기기
    addEduForm.forEach(form => {
        form.classList.remove('add');
        form.style.display = 'none';
    });

})



flatpickr(".custom-date", {
    dateFormat: "Y-m-d"
});


function updateCount() {
    const textarea = document.getElementById('myText');
    const count = textarea.value.length;
    document.getElementById('charCount').textContent = count;

    const growth=document.getElementById("growth");
    const count2 = growth.value.length;
    document.getElementById("charCount2").textContent = count2;

    const studentDay=document.getElementById("student-day");
    const count3 = studentDay.value.length;
    document.getElementById("charCount3").textContent = count3;

    const prosAndCons=document.getElementById("pros-and-cons");
    const count4 = prosAndCons.value.length;
    document.getElementById("charCount4").textContent = count4;

    const aspiration=document.getElementById("aspiration");
    const count5 = aspiration.value.length;
    document.getElementById("charCount5").textContent = count5;

}



const plusBtn05 = document.querySelector('.sec05 .plus figure');
const licenseForm = document.querySelector('.add-license-form');
const licenseSaveBtn = document.querySelector('.btn-license-save');
const licenseCancelBtn = document.querySelector('.btn-license-cancel');
const licenseList = document.querySelector('.license-list');

// 추가
plusBtn05.addEventListener('click', () => {
    licenseForm.style.display = 'flex';
    licenseForm.classList.add('show');
});

// 취소
licenseCancelBtn.addEventListener('click', () => {
    licenseForm.style.display = 'none';
    licenseForm.classList.remove('show');
});

// '저장' 버튼 누르면 리스트에 카드형태로 추가
licenseSaveBtn.addEventListener('click', () => {
    const name = document.querySelector('.license-name').value.trim();
    const org = document.querySelector('.license-org').value.trim();
    const start = document.querySelector('input[name="acquisition"]').value.trim();
    const end = document.querySelector('input[name="expiration"]').value.trim();

    console.log(name);
    console.log(org);
    console.log(start);
    console.log(end);

    if (!name || !org || !start) {
        alert('자격증명, 발급기관, 취득일을 모두 입력해주세요.');
        return;
    }

    // 카드형식 li 만들기
    const li = document.createElement('li');
    li.classList.add('license-card');
    li.innerHTML = `
        <h3 class="name">${name}</h3>
        <span class="org">${org}</span>
        <p class="date">${start} ${end ? `~ ${end}` : ''}</p>
    `;

    licenseList.appendChild(li);

    // 입력값 초기화
    document.querySelector('.license-name').value = '';
    document.querySelector('.license-org').value = '';
    document.querySelector('input[name="acquisition"]').value = '';
    document.querySelector('input[name="expiration"]').value = '';

    // 폼 숨기기
    licenseForm.style.display = 'none';
    licenseForm.classList.remove('show');
});
