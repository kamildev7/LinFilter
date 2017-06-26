$(document).ready(function() {
    initPosts();
});

function login() {
    $("#login-form").submit();
}

function initPosts() {
    if ($('.posts')) {
        $('.posts').imagesLoaded(function() {
            $('.posts').masonry({
                itemSelector: '.col-facebook-post',
                columnWidth: '.col-sizer',
                percentPosition: true
            });
        });
    }
}