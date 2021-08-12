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

				if (user_id == "" && user_pwd == "") {
					alert("���̵�� ��й�ȣ�� �Է����ּ���");
					return false;
				} else if (user_pwd == "") {
					alert("��й�ȣ�� �Է����ּ���");
					return false;
				} else if (user_id == "") {
					alert("���̵� �Է����ּ���");
					return false;
				}

				$.post("/user/userLoginCheck", {
					user_id : user_id,
					user_pwd : user_pwd
				})
				.done(function(data) {
					var data = eval("(" + data + ")");
					
					if (data.result == "Ʋ�� ��й�ȣ�Դϴ�") {
						alert("Ʋ�� ��й�ȣ�Դϴ�");
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

<div class="container">
        <div class="logo_container">
            <a href="${pageContext.request.contextPath }/index">
            <!-- �ΰ��̹������ -->
                <img src="${pageContext.request.contextPath }/assets/img/logo.png">
            </a>
        </div>

        <div class="login_container" >
            <form method="post" name="f" class="login_form" action="${pageContext.request.contextPath }/user/login">
                
                <div class="id_area">
                    <input type="text" class="user_id" id="user_id" name="user_id" placeholder="���̵� �Է��ϼ���" />
                </div>

                <div class="pw_area">
                    <input type="password" class="user_pwd" id="user_pwd" name="user_pwd" placeholder="��й�ȣ�� �Է��ϼ���" />
                </div>

                <div class="login">
                    <input type="button" alt="�α���" value="�α���" class="login_btn"/>
                </div>
			</form>
			
            <div class="register_area">
            	<span>
                	<a class="register" href="${pageContext.request.contextPath }/user/signup_agree">ȸ������</a>
               	</span>
                <span>
                    <a class="find_pw" href="${pageContext.request.contextPath }/user/find_pwd"> ��й�ȣ ã��</a>
                </span>
            </div>
        </div>

        <!-- ī�Ƕ���Ʈ -->
        <div id="copyright">
            <p class="copyright">&copy; 2021 Portfolio Web Site </p>
        </div>
    </div>

</body>
</html>