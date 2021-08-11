<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<!-- CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/user/find_pwd(css).css" />

</head>
<body>

	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/inc/topbar.jsp" />
    <!-- top 영역 끝 -->

    
    
	<div class="container">
		<div class="find_pwd_container">
			<div class="find_pwd_area">
				<p> 비밀번호 찾기 </p>
			</div>
			
			<div class="find_pwd_input_area">
				<input type="text" name="user_email" class="user_email" id="user_email" placeholder="이메일을 입력해주세요" />
			</div>
			
			<div class="find_pwd_btn_area">
				<input type="button" name="find_pwd_btn" class="find_pwd_btn" id="find_pwd_btn" value="임시비밀번호 발급" />
			</div>
		</div>
	</div>


	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/inc/footer.jsp" />
    <!-- top 영역 끝 -->

</body>
</html>