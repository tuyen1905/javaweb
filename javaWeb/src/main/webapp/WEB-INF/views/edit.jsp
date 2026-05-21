<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh Sửa Thông Tin Sinh Viên</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; line-height: 1.6; }
        .section { max-width: 600px; margin: 0 auto; padding: 20px; border: 1px solid #ddd; border-radius: 5px; background-color: #f9f9f9; }
        .form-group { margin-bottom: 15px; }
        label { display: inline-block; width: 150px; font-weight: bold; vertical-align: top; }
        input[type="text"], input[type="email"] { padding: 8px; width: 350px; border: 1px solid #ccc; border-radius: 4px; }
        input[readonly] { background-color: #e9ecef; cursor: not-allowed; }
        .error { color: red; font-size: 14px; display: block; margin-left: 150px; margin-top: 5px; }

        .btn-group { margin-left: 150px; margin-top: 20px; }
        .btn { padding: 10px 20px; border: none; cursor: pointer; font-weight: bold; border-radius: 4px; text-decoration: none; display: inline-block; }
        .btn-success { background-color: #28a745; color: white; }
        .btn-secondary { background-color: #6c757d; color: white; margin-left: 10px; }
        .btn:hover { opacity: 0.9; }
    </style>
</head>
<body>

    <div class="section">
        <h2>Chỉnh sửa thông tin sinh viên</h2>
        <hr>

        <form action="${pageContext.request.contextPath}/sinh-vien/cap-nhat" method="post">

            <div class="form-group">
                <label for="soCMND">Số CMND:</label>
                <input type="text" id="soCMND" name="soCMND" value="${sinhVien.soCMND}" readonly>
                <c:if test="${not empty errors.soCMND}">
                    <span class="error">${errors.soCMND}</span>
                </c:if>
            </div>

            <div class="form-group">
                <label for="hoTen">Họ và Tên:</label>
                <input type="text" id="hoTen" name="hoTen" value="${sinhVien.hoTen}" placeholder="Nhập họ tên...">
                <c:if test="${not empty errors.hoTen}">
                    <span class="error">${errors.hoTen}</span>
                </c:if>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="${sinhVien.email}" placeholder="Nhập email...">
                <c:if test="${not empty errors.email}">
                    <span class="error">${errors.email}</span>
                </c:if>
            </div>

            <div class="form-group">
                <label for="diaChi">Địa Chỉ:</label>
                <input type="text" id="diaChi" name="diaChi" value="${sinhVien.diaChi}" placeholder="Nhập địa chỉ...">
                <c:if test="${not empty errors.diaChi}">
                    <span class="error">${errors.diaChi}</span>
                </c:if>
            </div>

            <div class="form-group">
                <label for="soDT">Số DT:</label>
                <input type="text" id="soDT" name="soDT" value="${sinhVien.soDT}" placeholder="Nhập số sổ túi...">
                <c:if test="${not empty errors.soDT}">
                    <span class="error">${errors.soDT}</span>
                </c:if>
            </div>

            <div class="btn-group">
                <button type="submit" class="btn btn-success">Cập nhật</button>
                <a href="${pageContext.request.contextPath}/sinh-vien/tim-sinh-vien" class="btn btn-secondary">Hủy bỏ</a>
            </div>

        </form>
    </div>

</body>
</html>