window.onload = function() {
    // Lấy tên người dùng từ Local Storage
    const username = localStorage.getItem("username");

    // Hiển thị tên người dùng
    if (username) {
        document.getElementById("welcome-message").textContent ="user : "+  username ;
        // Ẩn các nút Đăng nhập và Tạo tài khoản
        document.getElementById("sign-up-button").style.display = "none";
        document.getElementById("sign-in-button").style.display = "none";
    } else {
        document.getElementById("welcome-message").textContent = "Bạn chưa đăng nhập.";
    }
}
