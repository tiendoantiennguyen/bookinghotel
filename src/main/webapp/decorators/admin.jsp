<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="ie=edge">
   <title>Admin Home</title>
   	<link href="<c:url value='/template/admin/css/styles.css'/>" rel="stylesheet" >
   	<link href="<c:url value='/template/admin/custom/dataTables.bootstrap4.min.css'/>" rel="stylesheet" >
    <link href="<c:url value='/template/admin/custom/all.min.js'/>" rel="stylesheet" >	    <!--    co van de -->
</head>

<body class="sb-nav-fixed" >

	<!-- header -->
	<%@include file="/common/admin/header.jsp" %>
	<!-- /header -->
	
	<!-- menu -->
	<%@include file="/common/admin/menu.jsp" %>
	<!-- /menu -->
	
	<!-- body -->
	<dec:body />
	<!-- /body -->
	
	<!-- footer -->
	<%@include file="/common/admin/footer.jsp" %>
	<!-- /footer -->
	
	<!-- Javascripts -->
	<script src="<c:url value='/template/admin/custom/jquery-3.5.1.slim.min.js'/>"></script>
  	   	<script src="<c:url value='/template/admin/custom/bootstrap.bundle.min.js'/>"></script>
        <script src="<c:url value='/template/admin/custom/js/scripts.js'/>"></script>
        <script src="<c:url value='/template/admin/custom/Chart.min.js'/>"></script>
        <script src="<c:url value='/template/admin/assets/demo/chart-area-demo.js'/>"></script>
        <script src="<c:url value='/template/admin/assets/demo/chart-bar-demo.js'/>"></script>
        <script src="<c:url value='/template/admin/custom/jquery.dataTables.min.js'/>"></script>
        <script src="<c:url value='/template/admin/custom/dataTables.bootstrap4.min.js'/>"></script>
        <script src="<c:url value='/template/admin/assets/demo/datatables-demo.js'/>"></script>

</body>
</html>