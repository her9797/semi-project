function loadHeaderAndFooter() {
    // 헤더 파일을 가져오는 XMLHttpRequest 객체 생성
    var xhttpHeader = new XMLHttpRequest();
    xhttpHeader.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            // 헤더 파일의 내용을 가져와서 특정 요소의 내용으로 대체
            document.getElementById("header").innerHTML = this.responseText;
        }
    };
    xhttpHeader.open("GET", "header.html", true);
    xhttpHeader.send();

    // 푸터 파일을 가져오는 XMLHttpRequest 객체 생성
    var xhttpFooter = new XMLHttpRequest();
    xhttpFooter.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            // 푸터 파일의 내용을 가져와서 특정 요소의 내용으로 대체
            document.getElementById("footer").innerHTML = this.responseText;
        }
    };
    xhttpFooter.open("GET", "footer.html", true);
    xhttpFooter.send();
}

// 페이지 로드 시 헤더와 푸터를 가져오도록 호출
window.onload = loadHeaderAndFooter;

// 찜하기 버튼 클릭시 색상 변경 스크립트
function toggleHeart(button) {
    button.classList.toggle('red-heart');
    button.classList.toggle('gray-heart');

    console.log('toggleHeart called');
    if (button.classList.contains('red-heart')) {
        console.log('Removing red-heart class');
        button.classList.remove('red-heart');
        console.log('Adding gray-heart class');
        button.classList.add('gray-heart');
    } else {
        console.log('Removing gray-heart class');
        button.classList.remove('gray-heart');
        console.log('Adding red-heart class');
        button.classList.add('red-heart');
    }
}