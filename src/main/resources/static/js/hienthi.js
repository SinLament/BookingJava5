function login2() {
    const usernameInput = document.getElementById("username").value;

    // Kiểm tra nếu người dùng đã nhập tên
    if (usernameInput) {
        // Lưu tên người dùng vào Local Storage
        localStorage.setItem("username", usernameInput);

        // Chuyển đến trang khác
        window.location.href = "/homee";
    } else {
        alert("Vui lòng nhập tên đăng nhập.");
    }
}
