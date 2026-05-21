<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản Lý Sinh Viên & Tốt Nghiệp</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; line-height: 1.6; }
        .section { margin-bottom: 40px; padding: 20px; border: 1px solid #ddd; border-radius: 5px; }
        .form-group { margin-bottom: 15px; }
        label { display: inline-block; width: 150px; font-weight: bold; }
        select, input[type="text"] { padding: 6px; width: 250px; }
        .error { color: red; font-size: 14px; margin-left: 10px; }
        .success { color: green; font-weight: bold; margin-bottom: 15px; }

        /* Style cho Button và Bảng danh sách */
        .btn { padding: 8px 15px; border: none; cursor: pointer; color: white; font-weight: bold; }
        .btn-success { background-color: #28a745; }
        .btn-primary { background-color: #007bff; }

        table { width: 100%; border-collapse: collapse; margin-top: 15px; }
        table, th, td { border: 1px solid #ddd; }
        th, td { padding: 10px; text-align: left; }
        th { background-color: #f2f2f2; }
        tr:hover { background-color: #f5f5f5; }
        .btn-edit {
            background-color: #ffc107; /* Màu vàng cam */
            color: #212529 !important;
            padding: 5px 10px;
            text-decoration: none;
            border-radius: 4px;
            font-size: 14px;
            font-weight: bold;
            display: inline-block;
        }
        .btn-edit:hover {
            background-color: #e0a800;
        }
        .btn-delete {
                    background-color: #00ffff; /* Màu vàng cam */
                    color: #212529 !important;
                    padding: 5px 10px;
                    text-decoration: none;
                    border-radius: 4px;
                    font-size: 14px;
                    font-weight: bold;
                    display: inline-block;
                }
    </style>
</head>
<body>

    <div class="section">
        <h2>Yêu cầu 3: Tìm kiếm sinh viên</h2>

        <form action="${pageContext.request.contextPath}/sinh-vien/tim-sinh-vien" method="get">
            <div class="form-group">
                <input type="text" name="keyword" value="${keyword}" placeholder="Nhập họ tên hoặc số CMND...">
                <button type="submit" class="btn btn-primary">Tìm kiếm</button>
            </div>
        </form>

        <table>
            <thead>
                <tr>
                    <th>Số CMND</th>
                    <th>Họ và Tên</th>
                    <th>Email</th>
                    <th>Địa Chỉ</th>
                    <th>Số DT</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${not empty listSinhVien}">
                        <c:forEach items="${listSinhVien}" var="sv">
                            <tr>
                                <td>${sv.soCMND}</td>
                                <td>${sv.hoTen}</td>
                                <td>${sv.email}</td>
                                <td>${sv.diaChi}</td>
                                <td>${sv.soDT}</td>
                                <td><a href="${pageContext.request.contextPath}/sinh-vien/sua-sinh-vien/${sv.soCMND}" class="btn-edit">
                                        Sửa thông tin
                                    </a>
                                </td>
                                <td><a href="${pageContext.request.contextPath}/sinh-vien/xoa-sinh-vien/${sv.soCMND}" class="btn-delete">
                                        Xoa thông tin
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="5" style="text-align: center; color: red;">Không tìm thấy sinh viên nào phù hợp!</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
    </div>

</body>
</html>