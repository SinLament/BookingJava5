const getHotel = async () => {
// Lấy query string từ URL
    const queryString = window.location.search;

// Tạo một URLSearchParams object từ query string
    const params = new URLSearchParams(queryString);

// Lấy giá trị của các tham số từ URL
    const thanhPho = params.get('thanhPho');
    const soNguoiLon = parseInt(params.get('soNguoiLon'));
    const soTreEm = parseInt(params.get('soTreEm'));
    const soPhong = parseInt(params.get('soPhong'));
    const tongSoNguoi = soNguoiLon + soTreEm;
// Kiểm tra và log các giá trị để xác nhận
    console.log('Thành phố:', thanhPho);
    console.log('Số người lớn:', soNguoiLon);
    console.log('Số trẻ em:', soTreEm);
    console.log('Số phòng:', soPhong);
    console.log("Tổng số người: ", tongSoNguoi)
    let container = $('#getHotel');
    await axios.get(`/api/khachsan-api/find-by-thanh-pho-and-suc-chua?thanhPho=${thanhPho}&sucChua=${tongSoNguoi}`)
        .then(response => {
            container.html('');
            console.log(response.data.data);
            if (response.data.data==null){
                container.html('<p>Không tìm thấy khách sạn phù hợp.</p>');
                return;
            }
            response.data.data.forEach(hotel => {
                let totalPrice = 0;
                let roomCount = 0;
                hotel.listPhong.forEach(room => {
                    totalPrice += room.gia;
                    roomCount++;
                });
                let avgPrice = totalPrice / roomCount;
                let html = `
                <div class="d-flex mt-2">
        <div class="card-img" style="width: 270px;">
          <a href="#" class="d-block">
            <img class="rounded" src="/img/${hotel.hinh}" alt="blog-img" width="250"/>
          </a>
        </div>
        <div class="card-body">
          <h3 class="card-title">
            <a href="#">${hotel.tenKhachSan}</a>
          </h3>
          <p class="card-meta">${hotel.diaChi + ", "+hotel.thanhPho}</p>
          <div class="card-rating">
            <span class="bg-warning p-1 rounded text-dark">${hotel.xepHang}/5 <i class="fa-solid fa-star" style="color: #FFD43B;"></i></span>
            <span class="rating__text">(30 đánh giá)</span>
          </div>
          <div class="card-price d-flex align-items-center justify-content-between">
            <p>
              <span class="price__from">Khoảng</span>
              <span class="price__num">${avgPrice.toLocaleString()}.000  VND</span>
              <span class="price__text">/Ngày</span>
            </p>
            <a href="/hotel/detail/${hotel.maKhachSan}" class="btn-text">Xem Chi Tiết<i
                class="la la-angle-right"></i></a>
          </div>
        </div>
      </div>
                `;
                container.append(html);
            });
        })
        .catch(error => {
            alert(error);
        });
    $('#thanhPho').val(thanhPho);
    $('#phong').val(soPhong);
    $('#soNguoiLon').val(soNguoiLon);
    $('#soTreEm').val(soTreEm)
}

// Gọi hàm getAllProduct khi trang được tải
document.addEventListener('DOMContentLoaded', getHotel);



