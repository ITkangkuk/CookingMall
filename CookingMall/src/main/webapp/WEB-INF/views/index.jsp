<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<!-- CSS -->
   <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/index(css).css">
   <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/bxslider.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/topbar(css).css">
	<!-- Jquery -->
	<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
	<!-- BX Slider -->
	<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
	<!-- JS -->   
	<script src="${pageContext.request.contextPath }/assets/js/product_priceReplace.js"></script>



</head>

<body>

	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/inc/topbar.jsp" />
	<!-- top 영역 끝 -->
	
	
	<div>
	<a href="${pageContext.request.contextPath }/admin/adminCategory" >admincategory</a>
	<a href="${pageContext.request.contextPath }/admin/adminHomePage" >adminHomepage</a>
	<a href="${pageContext.request.contextPath }/admin/adminMain" >adminmain</a>
	<a href="${pageContext.request.contextPath }/admin/adminProduct" >adminProduct</a>
	
	</div>
hi


	<!-- footer 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/inc/footer.jsp" />
	<!-- footer 끝 -->

</body>
</html>