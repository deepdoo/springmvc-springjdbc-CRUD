
<%@page import="sample.spring.mvc.dto.UserDto"%>
<%@page import="sample.spring.mvc.form.UserForm"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../header.txt"%>

<div class="container theme-showcase" role="main">
	<div class="page-header">
		<h1>ユーザー一覧</h1>
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>USER NAME</th>
				<th>PASSWORD</th>
				<th>E-MAIL</th>
				<th>ACTION</th>
			</tr>
		</thead>
		<tbody>
			<%
			    UserForm userForm = (UserForm) request.getAttribute("userForm");
			    for (UserDto dto : userForm.getList()) {
			%>
			<tr>
				<td><%=dto.getUserName()%></td>
				<td><%=dto.getPassWord()%></td>
				<td><%=dto.getEmail() %></td>
				<td><a
					href="<%=request.getContextPath()%>/user/update/<%=dto.getId()%>"
					class="btn btn-sm btn-info">更新</a>
					<a
					href="javascript:del('<%=dto.getId()%>');void(0)"
					class="btn btn-sm btn-danger">削除</a></td>
			</tr>
			<%
			    }
			%>
		</tbody>
	</table>
	<a href="<%=request.getContextPath()%>/user/add"
		class="btn btn-sm btn-primary">新規作成</a>
</div>

<script>
function del(key){
if (confirm("削除しますか?")) {
	location.href ="<%=request.getContextPath()%>/user/delete/" + key;
}
}
</script>

<%@include file="../footer.txt"%>