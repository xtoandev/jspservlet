<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/19/2022
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>

<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/18/2022
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin</title>

    <!-- Custom fonts for this template-->


    <!-- Page level plugin CSS-->
    <link href="<c:url value = '/template/admin/vendor/datatables/dataTables.bootstrap4.css'/>" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value = '/template/admin/css/sb-admin.css'/>" rel="stylesheet">

</head>

<body id="page-top">

<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="<c:url value='/admin-home'/>">Admin</a>

    <!-- Navbar -->
    <ul class="navbar-nav ml-auto ml-md-0">

        <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-user-circle fa-fw"></i>
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
            </div>
        </li>
    </ul>

</nav>

<div id="wrapper">

    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="<c:url value='/admin-home'/>">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="<c:url value='/admin-book?action=list'/>">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>Manager Book</span></a>
        </li>
    </ul>

    <div id="content-wrapper">

        <div class="card mb-4" style="width: 95%;margin-left: 10px">
            <div class="card-header">
                <i class="fas fa-table"></i>
                Danh sách Book
                <a style="float: right" class="btn btn-primary col-md-1" href="<c:url value='/admin-book?action=create' />"> Tạo mới</a>
            </div>

            <div class="card-body">
                <div class="table">
                    <table class="table table-bordered" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th>STT</th>
                            <th>Tiêu đề</th>
                            <th>Thể loại</th>
                            <th>Mô tả</th>
                            <th>Nội dung</th>
                            <th>Ảnh nền</th>
                            <th>Ngày tạo</th>
                            <th>Trạng thái</th>
                            <th>Thao tác</th>
                        </tr>
                        </thead>

                        <tbody>

                            <c:forEach items="${data}" var="i" varStatus="loop">
                                <tr>
                                    <th>${loop.index + 1}</th>
                                    <th>${i.title}</th>
                                    <th>${i.categoryName}</th>
                                    <th>${i.description}</th>
                                    <th>${i.content}</th>
                                    <th>
                                        <img style="max-height: 100px; max-weight: 100px;"
                                             src="<c:url  value='${i.background}'/>">
                                    </th>
                                    <th>${i.createDate}</th>
                                    <th>
                                        <c:if test="${i.status == 1}">
                                            <span class="status--process">Hoạt động</span>
                                        </c:if>
                                        <c:if test="${i.status == 0}">
                                            <span class="status--denied">Khóa</span>
                                        </c:if>
                                    </th>
                                    <th>
                                        <a href="<c:url value='/admin-book?action=edit&id=${i.id}'/>">Sửa &nbsp;</a>

                                        <a href="<c:url value='/admin-book?action=delete&id=${i.id}'/>">Xóa &nbsp;</a>
                                    </th>
                                </tr>
                            </c:forEach>



                        </tbody>
                    </table>
                </div>
            </div>

        </div>



    </div>
    <!-- /.container-fluid -->

    <!-- Sticky Footer -->
    <footer class="sticky-footer">
        <div class="container my-auto">
            <div class="copyright text-center my-auto">
                <span>Copyright © Your Website 2022</span>
            </div>
        </div>
    </footer>

</div>
<!-- /.content-wrapper -->

</div>
<!-- /#wrapper -->



<!-- Bootstrap core JavaScript-->
<script src="<c:url value = '/template/admin/vendor/jquery/jquery.min.js'/>"></script>
<script src="<c:url value = '/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url value = '/template/admin/vendor/jquery-easing/jquery.easing.min.js'/>"></script>

<!-- Page level plugin JavaScript-->
<script src="<c:url value = '/template/admin/vendor/chart.js/Chart.min.js'/>"></script>
<script src="<c:url value = '/template/admin/vendor/datatables/jquery.dataTables.js'/>"></script>
<script src="<c:url value = '/template/admin/vendor/datatables/dataTables.bootstrap4.js'/>"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url value = '/template/admin/js/sb-admin.min.js'/>"></script>

<!-- Demo scripts for this page-->
<script src="<c:url value = '/template/admin/js/demo/datatables-demo.js'/>"></script>
<script src="<c:url value = '/template/admin/js/demo/chart-area-demo.js'/>"></script>

</body>

</html>


