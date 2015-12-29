<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<script type="text/javascript">
	$(function() {
		confirm(123);
	});
</script>
</head>
<body>
	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<th>用户编号</th>
			<th>用户名</th>
			<th>密码</th>
		</tr>
		<c:forEach var="user" items="${users }">
			<tr>
				<td>${user.id }</td>
				<td>${user.username }</td>
				<td>${user.password }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>