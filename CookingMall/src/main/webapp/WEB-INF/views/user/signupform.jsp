<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<!-- CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/user/signupForm(css).css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/footer.css">
	
	<!-- Bootstrap -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css" />
	
	<!-- Jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- ���� �����ȣ �˻� ��ũ��Ʈ -->
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/daumPostCode.js"></script>
	
	<!-- JavaScript -->
	<script src="${pageContext.request.contextPath }/assets/js/user/signupForm.js"></script>
	
	<script type="text/javascript">
	    $(document).ready(function() {
		    $("#btn3").click(function() {
			    location.href="${pageContext.request.contextPath}/index";
	    	});
	    });
    </script>

</head>
<body>

<!-- ȸ������ ��� ���� -->

<div class="container">
        <div class="signup_form">
            <h1> ȸ������ </h1>
        </div>
        
        <br /><br />
        
        <!--ȸ�������� ����-->
        <form method="post" class="form-horizontal" action="${pageContext.request.contextPath }/user/signup">
            <!-- ���̵� -->
            <div class="form-group">
                <label for='userid' class="id_form col-md-6"> * ���̵� </label>
                <div class="col-md-15">
            		<input type="text" name="user_id" id="user_id" class="form-control" required/>
					<div id="idResult"></div>
            		<div class="id regex"></div>
                </div>
            </div>

			<!-- ��й�ȣ -->
            <div class="form-group">
                <label for='"password"' class="col-md-6">  * ��й�ȣ</label>
                <div class="col-md-15">
                    <input type="password" name="user_pwd" id="user_pwd" class="form-control" required/>
              	  	<div id="pwdResult"></div> <br />
                </div>
            </div>
            
            <!-- ��й�ȣ Ȯ�� -->
            <div class="form-group">
                <label for='password_re' class="col-md-6">  * ��й�ȣ Ȯ��</label>
                <div class="col-md-15">
                    <input type="password" name="user_pwd_re" id="user_pwd_re" class="form-control" required/>
               		<div id="pwdResult_re"></div> <br />
                </div>
            </div>
    
    		<!-- �̸� -->
            <div class="form-group">
                <label for='name' class="col-md-6"> * �̸� </label>
                <div class="col-md-15">
                    <input type="text" name="user_name" class="form-control" required/>
                </div>
            </div>
            
            <!-- �г��� -->
            <div class="form-group">
				<label for='nickname' class="id_form col-md-6"> * �г��� </label>
				<div class="col-md-15">
					<input type="text" name="user_nickname" id="user_nickname" class="form-control" required />
					<div id="nickResult"></div> <br />
				</div>
			</div>
			
    		<!-- �̸��� -->
            <div class="form-group">
                <label for='email' class="col-md-6"> * �̸���</label>
                <div class="col-md-15">
                    <input type="email" name="user_email" id="user_email" class="form-control" placeholder="ex) honggildong@naver.com" required/>
                    <div id="emailResult"></div> <br />
                </div>
            </div>
    
    		<!-- ����ó -->
            <div class="form-group">
                <label for='tel' class="col-md-6"> * ����ó </label>
                <div class="col-md-15">
                    <input type="tel" name="user_tel" class="form-control" placeholder="'-'���� �Է�" required/>
                </div>
            </div>

			<!-- ������� -->
            <div class="form-group">
                <label for="birthday" class="col-md-6"> * ������� </label>
                <div class="col-md-15">
                    <input type="date" name="user_birthday" id="user_birthday" min="1900-01-01"  class="form-control" required/>
                </div>
            </div>
    
    		<!-- �����ȣ (postcode) -->
            <div class="form-group">
                <label for='postcode'> &nbsp;&nbsp; * �����ȣ</label>
                <div class="col-md-15 clearfix" id="post_container">
                    <input type="text" name="user_postcode" id="postcode" class="form-control pull-left" style='width: 30rem; margin-right: 5px'/>
                    <!-- Ŭ�� ��, Javascript �Լ� ȣ�� : openDaumPostcode() -->
                    <input type='button' value='�����ȣ ã��' class='btn btn-warning' id="btn1" onclick='execDaumPostcode("postcode", "addr1", "addr2")' required/>
                </div>
            </div>
    
    		<!-- �ּ� (user_addr1) -->
            <div class="form-group">
                <label for='addr1' class="col-md-6"> * �ּ�</label>
                <div class="col-md-15">
                    <input type="text" name="user_addr1" id="addr1" class="form-control" required/>
                </div>
            </div>
    
    		<!-- ���ּ� (user_addr2) -->
            <div class="form-group">
                <label for='addr2' class="col-md-6"> * ���ּ�</label>
                <div class="col-md-15">
                    <input type="text" name="user_addr2" id="addr2" class="form-control" required/>
                </div>
            </div>
            
    		<!-- ���� & ���ۼ� ��ư -->
            <div class="form-group" >
                <div class="col-md-20" id="btn_group">
                    <button type="submit" class="btn btn-info" id="btn2">�����ϱ�</button> 
                    <button type="reset" class="btn btn-info" id="btn3">�ٽ��ۼ�</button>
                </div>
            </div>
            
            <input type="hidden" name="user_type" value="1">
        </form>
        <!-- ȸ������ ��� �� -->
    </div>
</body>
</html>