<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index Page</title>
</head>
<body>
	<form action="user/add" method="POST">
		<fieldset>
			<legend>添加用户</legend>
			<input type="hidden" name="_method" value="POST" />
			<table>
				<tr>
					<td><input type="text" name="username" placeholder="用户名" /></td>
				</tr>
				<tr>
					<td><input type="password" name="password" placeholder="密码" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="添加" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>