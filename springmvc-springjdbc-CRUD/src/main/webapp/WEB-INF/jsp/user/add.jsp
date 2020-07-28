<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="../header.txt"%>

<div class="container theme-showcase" role="main">
	<div class="page-header">
		<h1>新規作成</h1>
	</div>
	<form:form cssClass="form-horizontal"
		action="add" method="POST">
		<div class="form-group">
			<label for="userName" class="col-sm-2 control-label">USER NAME</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="userName" name="userDto.userName"
					placeholder="USER NAME" required="required">
			</div>
		</div>
		<div class="form-group">
			<label for="passWord" class="col-sm-2 control-label">PASSWORD</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="passWord" name="userDto.passWord"
					placeholder="PASSWORD" required="required">
			</div>
			
		</div>
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">E-MAIL</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="email" name="userDto.email"
					placeholder="E-MAIL" required="required" >
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">登録</button>
			</div>
		</div>
	</form:form>
</div>
<%@include file="../footer.txt"%>