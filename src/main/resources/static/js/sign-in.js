const login = async () => {
  const username = $('#username').val();
  const password = $('#password').val();

  const dataApi = {
    username: username,
    password: password,
  };

  try {
    const response = await axios.post('/account/login', dataApi);
    const responseData = response.data;
    if (responseData.status === true) {
      Swal.fire({
        title: 'Thành công!',
        text: responseData.message,
        icon: 'success'
      }).then(() => {
        window.location.href = '/index';
      });
      console.log(responseData.data);
    } else {
      Swal.fire({
        title: 'Đăng nhập thất bại',
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
  console.log(dataApi);
};

$('#signinForm').on('click', login);
