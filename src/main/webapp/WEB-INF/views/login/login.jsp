<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>

<body>

    <div class="container">
        <h1>Login Today!</h1>
        <!-- Form -->
      <c:if test="${param.incorrectAccount != null}">
			<div class="alert alert-danger">	
					Username or password incorrect
			</div>
		</c:if>
		<c:if test="${param.accessDenied != null}">
			<div class="alert alert-danger">	
					you Not authorize
			</div>
	</c:if>
        
        <form id="formLogin" action="j_spring_security_check" method="post">
            <!-- Full Name -->
            <div class="form-group">
                <label for="name">UserName</label>
                <input type="text" id="name" name="j_username" placeholder="UserName" required minlength="3">
            </div>

            <!-- Password -->
            <div class="form-group">
                <label for="password1">Password</label>
                <input type="password" name="j_password" id="password1" placeholder="Password" required >
            </div>
            <button type="submit">Login</button>
        </form>
        <!-- Error/Success Message -->
        <div class="message-container">
            <a href="<c:url value='/login/register'/>" style="color: black ; text-decoration: none;"><h3 >Register Now !</h3></a>
        </div>
        <div class="message-container">
            <a href="<c:url value='/trang-chu'/>" style="color: black ; text-decoration: none;"><h3 >Home!</h3></a>
        </div>
        
    </div>
    
    </body>

</html>
