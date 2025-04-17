
const plusBtn = document.querySelectorAll('.plus figure');
const addEduForm = document.querySelectorAll('.add-edu-form');
const cancelBtn = document.querySelectorAll('.btn-del');


plusBtn.forEach((btn, index) => {
    btn.addEventListener('click', () => {
        addEduForm[index].classList.add('add');
    });
});

cancelBtn.forEach((btn, index) => {
    btn.addEventListener('click', () => {
        addEduForm[index].classList.remove('add');
    });
});


flatpickr(".custom-date", {
    dateFormat: "Y-m-d"
});


function updateCount() {
    const textarea = document.getElementById('myText');
    const count = textarea.value.length;
    document.getElementById('charCount').textContent = count - 1;
}



const plusBtn05 = document.querySelector('.sec05 .plus figure');
const licenseForm = document.querySelector('.add-license-form');
const licenseSaveBtn = document.querySelector('.btn-license-save');
const licenseCancelBtn = document.querySelector('.btn-license-cancel');
const licenseList = document.querySelector('.license-list');

// '추가' 버튼 누르면 폼 보여줌
plusBtn05.addEventListener('click', () => {
    licenseForm.style.display = 'flex';
    licenseForm.classList.add('show');
});

// '취소' 버튼 누르면 폼 숨김
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
        <strong class="name">${name}</strong>
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
