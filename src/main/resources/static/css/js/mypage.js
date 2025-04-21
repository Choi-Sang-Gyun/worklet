
var swiper5 = new Swiper(".mySwiper5", {
    slidesPerView: 3,
    spaceBetween: 30,
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
    scrollbar: {
        el: ".swiper-scrollbar",
        hide: true,
      },
});

var swiper6 = new Swiper(".mySwiper6", {
    spaceBetween: 30,
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
    scrollbar: {
        el: ".swiper-scrollbar",
        hide: true,
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

