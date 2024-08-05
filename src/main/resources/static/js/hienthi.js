function login2() {
    const usernameInput = document.getElementById("username").value;


    if (usernameInput) {
        localStorage.setItem("username", usernameInput);
    } else {
        alert("Vui lòng nhập tên đăng nhập.");
    }
}
