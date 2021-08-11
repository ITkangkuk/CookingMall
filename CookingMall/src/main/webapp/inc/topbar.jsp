<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<!-- CSS ����? -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/topbar(css).css">
</head>
<body>
	<div class = "topbar_container">
		<div class = "topbar_area">
			<c:if test = "${empty sessionScope.user_id }">
				<ul>
					<li><a class="list" href="${pageContext.request.contextPath }/user/login"> �α��� </a></li>
	                <li><a class="list" href="${pageContext.request.contextPath }/user/registerAgree"> ȸ������ </a></li>
				</ul>
			</c:if>
			
			<c:if test="${not empty sessionScope.user_id }">
        		<ul>
	        		<c:if test="${sessionScope.user_type == 1 }">
		                <li><a class="list" href="/user/userProfile?user_id=${sessionScope.user_id}"> ${sessionScope.user_nickname}�� </a></li>
		                <li><a class="list"  href="${pageContext.request.contextPath }/user/logout" onClick="alert('�α׾ƿ� �Ǿ����ϴ�')"> �α׾ƿ� </a></li>
		                <li><a class="list" href="${pageContext.request.contextPath }/cart/cart_board?user_id=${sessionScope.user_id}"> ��ٱ���</a></li>
		                <li><a class="list" href="${pageContext.request.contextPath }/product/product_list"> ��ǰ����Ʈ </a></li>
	        		</c:if>
	        		<c:if test="${sessionScope.user_type == 2 }">
		                <li><a class="list" href="/admin/adminMain?user_id=${sessionScope.user_id}"> ${sessionScope.user_nickname}�� </a></li>
		                <li><a class="list"  href="${pageContext.request.contextPath }/user/logout" onClick="alert('�α׾ƿ� �Ǿ����ϴ�')"> �α׾ƿ� </a></li>
		                <li><a class="list" href="${pageContext.request.contextPath }/product/product_add"> ��ǰ���� </a></li>
	        		</c:if>
                </ul>
        	</c:if>
		</div>
	</div>
	
	<div class="top_menu_total_container">
    
	 <!-- �ΰ� ���� -->
        <div class="top_menu_logo_area">
            <a href="${pageContext.request.contextPath }/index" class="top_menu_logo_a">
                <img src="${pageContext.request.contextPath }/assets/img/logo.png" alt="logo" class="top_menu_logo_img">
            </a>
        </div>

            <!-- �˻�â -->
        <form action="${pageContext.request.contextPath }/product/searchKeyword">
           <div class="top_menu_search_area">
           
               <input type="text" class="top_menu_search_input" id="top_search_input" name="searchKeyword" placeholder="�˻�� �Է��ϼ���">
               <input type="submit" class="top_menu_search_input" id="top_search_icon" value="" />
           </div>
           <input type="hidden" id="searchKeyword_id" name="user_id" value="${sessionScope.user_id}"/>
      	</form>
     </div>
	



</body>
</html>