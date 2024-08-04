window.onload = function() {
    // Lấy tên người dùng từ Local Storage
    const username = localStorage.getItem("username");

    // Hiển thị tên người dùng và các nút phù hợp
    if (username) {
        document.getElementById("welcome-message").textContent = "Chào mừng, " + username + "!";
        // Ẩn các nút Đăng nhập và Tạo tài khoản
        document.getElementById("sign-up-button").style.display = "none";
        document.getElementById("sign-in-button").style.display = "none";
        // Hiển thị nút Đăng xuất
        document.getElementById('logoutButton').style.display = 'block';
    } else {
        document.getElementById("welcome-message").textContent = "Bạn chưa đăng nhập.";
    }

    // Kiểm tra nếu Local Storage không rỗng để hiển thị nút đăng xuất
    if (localStorage.length > 0) {
        document.getElementById('logoutButton').style.display = 'block';
    }

    // Thêm sự kiện lắng nghe vào nút Đăng xuất
    document.getElementById('logoutButton').addEventListener('click', function() {
        localStorage.clear();
        alert('Bạn đã đăng xuất thành công!');
        // Chuyển hướng đến trang đăng nhập hoặc trang chủ
        window.location.href = "/homee";
    });
};
