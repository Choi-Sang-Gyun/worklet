let hamburger = document.querySelector(".hamburger");
let hamburgerSpans = document.querySelectorAll(".hamburger span");
let hamMenu = document.querySelector(".ham-menu");

hamburger.addEventListener('click', function() {
    hamMenu.classList.toggle('on');
    
    hamburgerSpans.forEach(function(span) {
        span.classList.toggle('on');
    });
});