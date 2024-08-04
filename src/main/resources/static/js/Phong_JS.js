// Function to get all rooms or search rooms based on the room number
const getPhong = async (soPhong = '') => {
    let phongContainer = $('#phong');
    let url = '/api-phong/get-all';

    if (soPhong) {
        url = `/api-phong/search-by-so-phong?soPhong=${soPhong}`;
    }

    try {
        const response = await axios.get(url);
        phongContainer.html('');
        response.data.data.forEach(phong => {
            let html = `
            <tr>
                <td>${phong.id}</td>
                <td>${phong.soPhong}</td>
                <td>${phong.kieuPhong}</td>
                <td>${phong.gia}</td>
                <td>${phong.moTa}</td>
                <td>${phong.trangThai}</td
            </tr>
            `;
            phongContainer.append(html);
        });
    } catch (error) {
        alert('Lỗi khi lấy dữ liệu phòng: ' + error);
    }
};

// Call getPhong when the page is loaded
document.addEventListener('DOMContentLoaded', () => getPhong());

// Event handler for searching rooms
$(document).on('click', '#searchButton', function () {
    const soPhong = $('#searchSoPhong').val().trim();
    getPhong(soPhong);
});

