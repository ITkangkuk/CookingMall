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

	<!-- top ���� ���� -->
	<c:import url="${pageContext.request.contextPath }/inc/topbar.jsp" />
    <!-- top ���� �� -->

    
    
	<div class="container">
		<div class="find_pwd_container">
			<div class="find_pwd_area">
				<p> ��й�ȣ ã�� </p>
			</div>
			
			<div class="find_pwd_input_area">
				<input type="text" name="user_email" class="user_email" id="user_email" placeholder="�̸����� �Է����ּ���" />
			</div>
			
			<div class="find_pwd_btn_area">
				<input type="button" name="find_pwd_btn" class="find_pwd_btn" id="find_pwd_btn" value="�ӽú�й�ȣ �߱�" />
			</div>
		</div>
	</div>


	<!-- top ���� ���� -->
	<c:import url="${pageContext.request.contextPath }/inc/footer.jsp" />
    <!-- top ���� �� -->

</body>
</html>