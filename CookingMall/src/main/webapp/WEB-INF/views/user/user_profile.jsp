<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<!-- CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/user/userProfile(css).css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/topbar(css).css">
	
	<!-- Jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	
	<!-- JavaScript -->
	<script src="${pageContext.request.contextPath }/assets/js/user/userProfile.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/product_priceReplace.js"></script>
</head>
<body>
	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/inc/topbar.jsp" />
	<!-- top 영역 끝 -->

	<!-- 유저 정보 컨테이너 -->
	<div class="user_info_container">
		<div class="user_info_area">

			<!-- 유저 닉네임 & ID 영역 -->
			<div class="user_id_nick_area">
				<div>${u.user_nickname }</div>
				<div>&nbsp;(${u.user_id })</div>
			</div>
			
			<c:if test="${sessionScope.user_id == u.user_id }">
						<a href="${pageContext.request.contextPath }/user/userEdit"> 
							<input type="button" class="editbtn" value="정보수정" />
						</a>
					</c:if>
				</div>
	<hr />
	</div>
<!-- <div class="my_refrigerator"></div> (나의 냉장고)-->

	<!-- footer 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/inc/footer.jsp" />
	<!-- footer 끝 -->
</body>
</html>