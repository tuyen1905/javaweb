<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Khai báo thông tin tốt nghiệp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-sm mx-auto" style="max-width: 600px;">
        <div class="card-header bg-primary text-white text-center py-3">
            <h4 class="mb-0">Khai Báo Thông Tin Tốt Nghiệp</h4>
        </div>
        <div class="card-body p-4">

            <c:if test="${param.success == 'true'}">
                <div class="alert alert-success text-center">
                    Lưu thông tin tốt nghiệp thành công!
                </div>
            </c:if>

            <form action="/sinh-vien/luu-tot-nghiep" method="POST">

                <div class="mb-3">
                    <label class="form-label fw-bold">Số CMND (*):</label>
                    <input type="text" name="sinhVien.soCMND" class="form-control" value="${totNghiepData.sinhVien.soCMND}">
                    <span class="text-danger small">${errorCMND}</span>
                </div>

                <div class="mb-3">
                    <label class="form-label fw-bold">Trường tốt nghiệp (*):</label>
                    <select name="truong.maTruong" class="form-select">
                        <option value="">-- Chọn trường học --</option>
                        <c:forEach items="${listTruong}" var="t">
                            <option value="${t.maTruong}">${t.tenTruong}</option>
                        </c:forEach>
                    </select>
                    <span class="text-danger small">${errorTruong}</span>
                </div>

                <div class="mb-3">
                    <label class="form-label fw-bold">Ngành học (*):</label>
                    <select name="nganh.maNganh" class="form-select">
                        <option value="">-- Chọn ngành học --</option>
                        <c:forEach items="${listNganh}" var="n">
                            <option value="${n.maNganh}">${n.tenNganh}</option>
                        </c:forEach>
                    </select>
                    <span class="text-danger small">${errorNganh}</span>
                </div>

                <div class="mb-3">
                    <label class="form-label fw-bold">Hệ tốt nghiệp:</label>
                    <input type="text" name="heTN" class="form-control" value="${totNghiepData.heTN}">
                </div>

                <div class="mb-3">
                    <label class="form-label fw-bold">Ngày tốt nghiệp (*):</label>
                    <input type="date" name="ngayTN" class="form-control" value="${totNghiepData.ngayTN}">
                    <span class="text-danger small">${errorNgay}</span>
                </div>

                <div class="mb-3">
                    <label class="form-label fw-bold">Loại tốt nghiệp:</label>
                    <input type="text" name="loaiTN" class="form-control" value="${totNghiepData.loaiTN}">
                </div>

                <div class="d-grid gap-2 d-md-flex justify-content-md-center mt-4">
                    <button type="submit" class="btn btn-success px-4 fw-bold">Lưu lại</button>
                    <button type="reset" class="btn alert-secondary px-4">Xóa form</button>
                </div>
            </form>

        </div>
    </div>
</div>

</body>
</html>