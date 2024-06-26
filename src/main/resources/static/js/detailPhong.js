const getRoom = async () => {
    let urlPath = window.location.pathname;
    let maKhachSan = urlPath.split('/').pop();
    let container = $('#getRoom');
    await axios.get(`/api-phong/find-phong-by-ma-khach-san?maKhachSan=${maKhachSan}&trangThai=false`)
        .then(response => {
            container.html('');
            console.log(response.data.data);
            if (response.data.data==null){
                container.html('<p>Không tìm thấy khách sạn phù hợp.</p>');
                return;
            }
            response.data.data.forEach(phong => {
                let html = `
                <div class="card" style="margin-top: 10px;">  
                    <div class="d-flex mt-2">
                        <div class="card-img" style="width: 270px;">
                            <a href="#" class="d-block">
                                <img class="rounded" src="/img/${phong.hinh}" alt="blog-img" width="250"/>
                             </a>
                        </div>
                    <div class="card-body">
                        <h3 class="card-title">
                            <a href="#">${phong.kieuPhong}</a>
                        </h3>
          
                <div class="card-price d-flex align-items-center justify-content-between">
                     <p>
                        <span class="price__from">Giá</span>
                        <span class="price__num">${phong.gia.toLocaleString()}.000  VND</span>
                        <span class="price__text">/Ngày</span>
                    </p>
            <p class="card-meta">${phong.moTa}</p>
            <a href="/payment" class="btn-text">Đặt ngay<i
                class="la la-angle-right"></i></a>
          </div>
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
}
// Gọi hàm getAllProduct khi trang được tải
document.addEventListener('DOMContentLoaded', getRoom);
const getHotel = async () => {
    let urlPath = window.location.pathname;
    let maKhachSan = urlPath.split('/').pop();
    let container = $('#getHotel');
    await axios.get(`/api/khachsan-api/find-khach-san-by-ma-khach-san?maKhachSan=${maKhachSan}`)
        .then(response => {
            container.html('');
            console.log(response.data.data);
            if (response.data.data==null){
                container.html('<p>Không tìm thấy khách sạn phù hợp.</p>');
                return;
            }

            let hotel = response.data.data;
            let dichVuHtml = '';

            // Duyệt qua danh sách dịch vụ và tạo HTML cho mỗi dịch vụ
            hotel.listDichVu.forEach(dichVu => {
                dichVuHtml += `<p class="card-text">${dichVu.tenDichVu}: ${dichVu.moTa}</p>`;
            });
                let html = `
                <div class="d-flex flex-row">
                    <img class="rounded" src="/img/${hotel.hinh}" alt="blog-img" width="450"/>
                    <div style="margin-left: 50px;">
                        <h1 class="h3 mt-2 mb-1">${hotel.tenKhachSan}</h1>
                        <p class="card-text"> ${hotel.diaChi+", "+hotel.thanhPho}</p>
                        <p class="card-text">${hotel.xepHang}/5 <i class="fa-solid fa-star" style="color: #FFD43B;"></i></p>
                        <p class="card-text"> Đánh giá: (5 Đánh giá)</p>
                        <h3>Dịch vụ</h3>
                        ${dichVuHtml}
                    </div>
                </div>
                `;
                container.append(html);
        })
        .catch(error => {
            alert(error);
        });
}
// Gọi hàm getAllProduct khi trang được tải
document.addEventListener('DOMContentLoaded', getHotel);