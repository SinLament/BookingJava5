const btnRegister = async () => {
  const username = $('#username').val();
  const password = $('#password').val();
  const sdt = $('#sdt').val();
  const email = $('#email').val();


  const dataApiRegister = {
    username: username,
    password: password,
    sdt: sdt,
    email: email
  };

  try {
    const response = await axios.post('/account/sign-up', dataApiRegister);
    const responseData = response.data;
    if (responseData.status === true) {
      Swal.fire({
        title: 'Thành công!',
        text: responseData.message,
        icon: 'success'
      });
      console.log(responseData.data);
    } else {
      Swal.fire({
        title: 'Đăng ký thất bại',
        text: responseData.message,
        icon: 'error'
      });
    }
  } catch (error) {
    Swal.fire({
      title: 'Đã xảy ra lỗi',
      text: 'Vui lòng thử lại sau',
      icon: 'error'
    });
  }
  console.log(dataApiRegister)
};
$('#signupForm').on('click', btnRegister);