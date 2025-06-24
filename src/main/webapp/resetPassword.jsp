<%@page import="in.ps.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.heading {     
	color: #000080;
}

.sub {
	color: #1e90ff;
}
.success
{
color:green;
}
.failure
{
color:red;
}
.buttons
{
text-decoration: none;
}

</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"> 
</head>
<body bgcolor='#add8e6'>
<%Student s=(Student)session.getAttribute("student");%>
	<div align="center">
		<h1 class="heading">Pentagon Space</h1>
		<h3 class="sub">Reset your password here</h3>
		
		<%String successMessage=(String)request.getAttribute("success");
		if(successMessage!=null){%>
		<h3 class="success"><%=successMessage%></h3>
		<%}%>
		
		<%String error=(String)request.getAttribute("error");
		if(error!=null){%>
		<h3 class="failure"><%=error%></h3>
		<%}%>
		<form action="resetPassword" method="post">
			<table>
			<tr>
					<td><b>Enter the Phone number:</b></td>
					<td><input type="tel" name="phone" <%if(s!=null){%> value="<%=s.getPhone()%>"<%}%>></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the Mail ID:</b></td>
					<td><input type="email" name="mail" <%if(s!=null){%> value="<%=s.getMail()%>"<%}%>></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the password:</b></td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Confirm the password:</b></td>
					<td><input type="password" name="confirm"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><input class="btn btn-success" type="submit" value="Reset Password"></td>
					<td align="right"><a class="btn btn-primary buttons" href="login.html" >Back</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>