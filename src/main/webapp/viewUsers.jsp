<%@page import="java.util.ArrayList"%>
<%@page import="in.ps.studentapp.dao.StudentDAOImpl"%>
<%@page import="in.ps.studentapp.dao.StudentDAO"%>
<%@page import="in.ps.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>View Users</title>
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
  <link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
    rel="stylesheet">
</head>
<body>
<%Student user=(Student)session.getAttribute("student");
if(user!=null){%>

  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand text" href="#">Welcome Admin: <%=user.getName() %></a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto">
          <li class="nav-item">
            <a class="btn btn-primary" href="dashboard.jsp">Back</a>
          </li>
          <li class="nav-item">
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <div class="container mt-4">
    <h1 class="text-center mb-4">Student Data</h1>
</div>
		<%String success=(String)request.getAttribute("success");
		if(success!=null){%>
		<h3 align="center" class="success"><%=success%></h3> 
		<%}%>
		<%String error=(String)request.getAttribute("error");
		if(error!=null){%>
		<h3 align="center" class="failure"><%=error%></h3> 
		<%}%>
<!-- User Section -->
    <div class="row">
      <div class="col-md-12">
       
        <table class="table table-hover">
          <thead>
            <tr>
              <th>Id</th>
              <th>Name</th>
              <th>Phone</th>
              <th>Mail ID</th>
              <th>Branch</th>
	      	  <th>Location</th>
	      	  <th>Remove</th>
            </tr> 
          </thead>
  			<%StudentDAO sdao=new StudentDAOImpl();
  			ArrayList<Student> studentList= sdao.getStudent();
  			for(Student s:studentList){%>
  			<tbody>
  				<tr>
  					<td><%=s.getId()%></td>
  					<td><%=s.getName()%></td>
  					<td><%=s.getPhone()%></td>
  					<td><%=s.getMail()%></td>
  					<td><%=s.getBranch()%></td>
  					<td><%=s.getLoc()%></td>
  					<td>
  						<form action="deleteUsers " method="post">
  							<input type="hidden" name="id" value="<%=s.getId()%>">
  							<input type="submit" class="btn btn-danger" value="Delete">
  						</form>
  					</td>
  				</tr>
  			</tbody>
  			<%}
  			}%>
        </table>
      </div>
    </div>
</body>
</html>