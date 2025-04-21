
var swiper = new Swiper(".mySwiper", {
    speed: 1500,
    loop: true,
    autoplay: {
        delay: 3500,
        disableOnInteraction: false,
    },
});

var swiper2 = new Swiper(".mySwiper2", {
    speed: 2000,
    loop: true,
    pagination: {
        el: ".swiper-pagination",
    },
    autoplay: {
        delay: 4500,
        disableOnInteraction: false,
    },
});

var swiper3 = new Swiper(".mySwiper3", {
    slidesPerView: 4,
    spaceBetween: 30,
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
});

var swiper4 = new Swiper(".mySwiper4", {
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
});


let hamburger = document.querySelector(".hamburger");
let hamburgerSpans = document.querySelectorAll(".hamburger span");
let hamMenu = document.querySelector(".ham-menu");

hamburger.addEventListener('click', function() {
    hamMenu.classList.toggle('on');
    
    hamburgerSpans.forEach(function(span) {
        span.classList.toggle('on');
    });
});

