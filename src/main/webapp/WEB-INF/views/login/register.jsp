<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Validation</title>
</head>

<body>
    <div class="container">
        <h1>Register	 Today!</h1>
        <!-- Form -->
        <form id="formSubmit">
            <!-- Full Name -->
            <div class="form-group">
                <label for="name">UserName</label>
                <input type="text" id="userName" name="userName" placeholder="UserName" required minlength="3">
            </div>
            <!-- fullname -->
            <div class="form-group">
                <label for="name">FullName</label>
                <input type="text" id="fullName" name="fullName" placeholder="FullName" required minlength="3">
            </div>
            
            <!-- Phone Number -->
            <div class="form-group">
                <label for="phone">Phone Number</label>
                <input type="tel" id="phone" name="phone" placeholder="555-555-5555" required pattern="[0-9]{4}-[0-9]{3}-[0-9]{3}">
            </div>
            <!-- Email Address -->
            <div class="form-group">
                <label for="email">Email Address</label>
                <input type="email" id="email" name="email" placeholder="email@address.com" required>
            </div>
            <!-- Website URL -->
            <div class="form-group">
                <label for="country">City</label>
                <input type="text" id="country" name="country" placeholder="Ha noi" required>
            </div>
            <!-- Password -->
            <div class="form-group">
                <label for="password1">Password</label>
                <input type="password" id="password1" name="password1" placeholder="Create Password" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[#$^+=!*()@%&]).{8,}$" title="Please include at least 1 uppercase, 1 lowercase, 1 number and 1 special characters such as !@#$%*">
            </div>
            <!-- Confirm Password -->
            <div class="form-group">
                <label for="password2">Confirm Password</label>
                <input type="password" id="password2" name="password" placeholder="Confirm Password" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[#$^+=!*()@%&]).{8,}$">
            </div>
            <button type="submit" id="btnAddUser">Register</button>
        </form>
        <!-- Error/Success Message -->
        <div class="message-container">
            <a href="<c:url value='/login'/>" style="color: black ; text-decoration: none;"><h3 id="message">Login !</h3></a>
        </div>
    </div>
    <script type="text/javascript">
    
	$('#btnAddUser').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var formData = $('#formSubmit').serializeArray();
	    $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
	    var id = $('#addUser').val();
	    if (id == "") {
	    	addNew(data);
	    } else {
	    	updateNew(data);
	    }
	});
	
	function addUser(data) {
		$.ajax({
            url: '${newAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${editNewURL}?id="+result.id+"&message=insert_success";
            },
            error: function (error) {
            	window.location.href = "${newURL}?page=1&limit=2&message=error_system";
            }
        });
	}
      
    </script>
    
</body>

</html>