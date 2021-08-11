<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<!-- Jquery -->    
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	    
	<!-- JS -->
	<script src="${pageContext.request.contextPath }/assets/js/admin/admin_category.js"></script>
</head>
<body>
	<div class = "admin_category_container">
		<div class = "admin_category_area">
			<p> ī�װ� �߰� - ���� - ���� </p>
			<hr />  <!-- hr�±״� �� ���� �� ���м� -->
		</div>
		
		<div class = "admin_all_category_area">
			<!-- category1 -->
			<div class = "admin_category1">
				<table id = "category1_print">
					<!-- caption�� ���̺��� ���� -->
					<caption class = "admin_category_caption">��з�</caption> 
						<tr>
							<td>
								<input type = "text" id = "category1_name" class = "category1" placeholder = "��з� �߰�" />
							</td>
						</tr>
						
						<tr>
							<td>
								<input type="button" id="add_category1_btn" value="�߰�" />
							</td>
						</tr>
				</table>
			</div>
			<input type="hidden" name="category_type" value="1">
			
			<!-- category2 -->
			<div class = "admin_category2">
				<table id = "category2_print">
					<caption class = "acmin_category_caption">�ߺз�</caption>
						<tr>
							<td>
								<input type="text" id="category2_name" name="category_name" class="category2" placeholder="�ߺз� �߰�"/>
							</td>
						</tr>
		
						<tr>
							<td>
								<input type="button" id="add_category2_btn" value="�߰�" />
							</td>
						</tr>
				</table>
			</div>
			<input type="hidden" id="category2_num" name="parent_category_num" value=""/>
			
			<!-- ���õ� ī�װ� ���� -->
			<div class = "admin_select_category_area">
				<table>
					<caption class = "admin_category_caption">������ ī�װ�</caption>
						<tr>
							<td>
								<input type = "text" name = "select_category" class = "select_category" id = "selected_category" value = "" />
							</td>
						</tr>
						
						<tr>
							<td>
								<input type = "button" name = "edit_btn" class = "edit_btn" vlaue = "�����ϱ�" />
								<input type = "button" name = "del_btn" class = "del_btn" id = "del_btn" value = "�����ϱ�" />
							</td>
						</tr>
				</table>
			</div>			
		</div>		
	</div>

</body>
</html>