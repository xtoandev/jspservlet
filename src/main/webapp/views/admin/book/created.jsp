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


    <div class="container">
        <div class="card">
            <div class="card-header">BOOK</div>
            <div class="card-body">
                <c:if test="${not empty book}">
                    <form method="post" action="./admin-book?action=update&id=${book.id}">
                </c:if>
                <c:if test="${! not empty book}">
                    <form method="post" action="./admin-book?action=save">
                </c:if>

                    <div class="form-group">
                        <div class="form-label-group">
                            <input type="text" name="title" id="inputtitle" class="form-control" placeholder="Enter Title" value="${book.title}" required="required" autofocus="autofocus">
                            <label for = "inputtitle">Title: </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-label-group">
                            <input hidden id="category" type="text" name="categoryID" id="inputcate" class="form-control" placeholder="Enter cate" value="${book.categoryID}" required="required">

                        </div>
                    </div>

                    <div class="form-group">
                        <div class="form-label-group">
                            <select  required name="maChuDe" id="select" class="form-control" onchange="myFunction(event)">
                                <c:if test="${empty book.categoryID}">
                                    <option value="">Select category</option>
                                    <c:forEach var="item" items="${categories}">
                                        <option value="${item.id}">${item.categoryName}</option>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${not empty book.categoryID}">
                                    <option value="">Select category</option>
                                    <c:forEach var="item" items="${categories}">
                                        <option value="${item.id}"
                                                <c:if test="${item.id == book.categoryID}">selected="selected"</c:if>>
                                                ${item.categoryName}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="form-label-group">
                            <input type="text" name="description" id="inputdes" class="form-control" placeholder="Enter decriptions" value="${book.description}" required="required">
                            <label for="inputdes">Description: </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-label-group">
                            <input type="text" name="content" id="inputcontent" class="form-control" placeholder="Enter content" value="${book.content}" required="required">
                            <label for="inputcontent">Content: </label>
                        </div>
                    </div>




                    <button type="submit" class="btn btn-info " style="float: right;background: #3782f5">
                        <c:if test="${not empty book}">Cập nhật</c:if>
                        <c:if test="${! not empty book}">Tạo mới</c:if>
                    </button>

                </form>

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

<script>
    function myFunction(e) {
        document.getElementById("category").value = e.target.value
    }
</script>

</body>

</html>


