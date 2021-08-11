<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<!-- CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/user/login(css).css">
	
	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-1.11.3.js"></script> 
	
	<script type="text/javascript">
		$(document).ready(function() {
			$(".login_btn").click(function() {
				var user_id = $(".user_id").val();
				var user_pwd = $(".user_pwd").val();

				if (user_id == "" && user_pw == "") {
					alert("아이디와 비밀번호를 입력해주세요");
					return false;
				} else if (user_pw == "") {
					alert("비밀번호를 입력해주세요");
					return false;
				} else if (user_id == "") {
					alert("아이디를 입력해주세요");
					return false;
				}

				$.post("/user/userLoginCheck", {
					user_id : user_id,
					user_pw : user_pw
				})
				.done(function(data) {
					var data = eval("(" + data + ")");
					
					if (data.result == "틀린 비밀번호입니다") {
						alert("틀린 비밀번호입니다");
						return false;
					} 
					else {
						 $(".login_form").attr('action', '/user/login');
						 $(".login_form").submit();
					}
				});
			});
		});
	</script>

</head>
<body>
//바디에 어떠한 변화를 주어 변경되나 실행
	
<div class="container">
        <div class="logo_container">
            <a href="${pageContext.request.contextPath }/index">
            <!-- 로고이미지경로 -->
                <img src="${pageContext.request.contextPath }/assets/img/logo.png">
            </a>
        </div>

        <div class="login_container" >
            <form method="post" name="f" class="login_form" action="${pageContext.request.contextPath }/user/login">
                
                <div class="id_area">
                    <input type="text" class="user_id" id="user_id" name="user_id" placeholder="아이디를 입력하세요" />
                </div>

                <div class="pw_area">
                    <input type="password" class="user_pw" id="user_pw" name="user_pw" placeholder="비밀번호를 입력하세요" />
                </div>

                <div class="login">
                    <input type="button" alt="로그인" value="로그인" class="login_btn" />
                </div>
			</form>
			
            <div class="register_area">
            	<span>
                	<a class="register" href="${pageContext.request.contextPath }/user/registerAgree">회원가입</a>
               	</span>
                <span>
                    <a class="find_pw" href="${pageContext.request.contextPath }/user/find_pw"> 비밀번호 찾기</a>
                </span>
            </div>
        </div>

        <!-- 카피라이트 -->
        <div id="copyright">
            <p class="copyright">&copy; 2021 Portfolio Web Site </p>
        </div>
    </div>

</body>
</html>
