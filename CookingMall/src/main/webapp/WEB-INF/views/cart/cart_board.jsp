<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<!-- top ���� ���� -->
	<c:if test="${sessionScope.user_type == 1 || empty sessionScope.user_id }">
		<c:import url="${pageContext.request.contextPath }/inc/topbar.jsp" />
    </c:if>
    <c:if test="${sessionScope.user_type == 2 }">
		<c:import url="${pageContext.request.contextPath }/inc/adminTopbar.jsp" />
    </c:if>
    <!-- top ���� �� -->



<div class="cart_all">
		<table>    <!-- ��� â ���� -->
			<tr>
				<th class="crt_num"><input type="checkbox" class="checkbox_num" value=""/>��ȣ</th>
				<th class="crt_info">����</th>
				<th class="crt_price">�ۼ���</th>
				<th class="crt_price">����</th>
				<th class="crt_totalprice">�հ� �ݾ�</th>
			</tr>
			
			<c:if test="${empty list}">
				<tr>
					<td colspan="5">����� ��ǰ�� �����ϴ�.</td>
				</tr>
			</c:if>
				
			<c:if test="${not empty list}">
				<c:forEach var="p" items="${list }" varStatus="status">
					<tr>
						<td> <input type="checkbox" class="checkbox_p_num" value=""/> ${status.count} </td>
						<td>
							<img src="product_img">
							<a class="link" href="${pageContext.request.contextPath }/notice/product_detail?product_num=${p.product_num}">${p.product_name}</a>
						</td>
						<td> ${p.product_price} </td>
						<td> ${p.product_quantity} </td>  <!-- product ������ ����ϴ��� Ȯ�� �ʿ� + ���⿡ ���� ������ �� �ֵ��� ����-->
					</tr>
				</c:forEach>
			</c:if>



			<c:if test="${sessionScope.user_type == 1 }">
				<tr>
					<td class="check_del_btn"><input type="button" value="�����׸� ����" class="btn_del_cart" onclick="deleteCart();">  <!-- deleteCart()�� �غ�-->
					<td class="td_btn" colspan="3"> <!--���� ���� ��ư ���� �������� ����� (����:https://freehoon.tistory.com/112)-->
						<!--<input type="button" class="before_btn" onclick=##page -1 value="����">-->
						<!--<now page> -->
						<!--<input type="button" class="before_btn" onclick=##page +1 value="����">-->
					</td>
					<td> ��ǰ �� �ݾ�: �ش� ���̵��� result�� 1�� ��ǰ���� ���� ��ġ��
				</tr>
				</c:if>
		</table>
	</div>
	
<!-- footer ���� ���� -->
	<c:import url="${pageContext.request.contextPath }/inc/footer.jsp" />
	<!-- footer �� -->
</body>
</html>