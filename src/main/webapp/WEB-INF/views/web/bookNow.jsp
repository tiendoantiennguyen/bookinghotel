<%@page import="org.springframework.http.HttpRequest"%>
<%@page import="com.nhapmoncongnghephanmem.dto.CategoryRoomDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nhapmoncongnghephanmem.entity.CategoryRoom"%>
<%@page import="com.nhapmoncongnghephanmem.repository.CategoryRoomRepository"%>
<%@page import="com.nhapmoncongnghephanmem.repository.BillRepository"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Now</title>
</head>
<body>


	<section class="site-hero site-hero-innerpage overlay"
		data-stellar-background-ratio="0.5"
		style="background-image: url(template/web/images/big_image_1.jpg);">
		<div class="container">
			<div
				class="row align-items-center site-hero-inner justify-content-center">
				<div class="col-md-12 text-center">

					<div class="mb-5 element-animate">
						<h1>Reservation</h1>
						<p>Discover our world's #1 Luxury Room For VIP.</p>
					</div>

				</div>
			</div>
		</div>
	</section>
	<!-- END section -->

	<section class="site-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2 class="mb-5">Reservation Form</h2>
					<form action="bookingProcessing"
						onsubmit="return validateForm()" method="post">
						<div class="row">
							<div class="col-sm-6 form-group">

								<label for="">Arrival Date</label>
								<div style="position: relative;">
									<input type='date' value="<%=LocalDate.now().toString()%>"
										class="form-control" name='arrival_date' id='arrival_date'
										required="required" />
								</div>
							</div>

							<div class="col-sm-6 form-group">

								<label for="">Departure Date</label>
								<div style="position: relative;">
									<input type='date'
										value="<%=LocalDate.now().plusDays(1).toString()%>" onblur=""
										class="form-control" name='departure_date' id='departure_date'
										required="required" />
								</div>
							</div>

						</div>


						<div class="row">
							<div class="col-md-4 form-group">
								<label for="room">Number of people</label> <input type="number"
									name="numberOfPeople" min="1" value="1" max="10"
									class="form-control " required="required">
							</div>

							<div class="col-md-4 form-group">
								<label for="room">Number of people in a room</label> <select
									name="numberOfPeopleInARoom" class="form-control"
									required="required">
									<option value=1>1</option>
									<option value=2>2</option>
									<option value=3>3</option>
								</select>
							</div>
							<div class="col-md-4 form-group">
								<label for="room">Preferred room type</label> <select
									name="roomCategory" class="form-control" required="required">
									<%
									ArrayList<CategoryRoomDTO> categoryList = (ArrayList<CategoryRoomDTO>) request.getAttribute("CategoryList");
									%>
									<%
									for (int i = 0; i < categoryList.size(); i++) {
										CategoryRoomDTO categoryRoomDTO = categoryList.get(i);
									%>
									<option value="<%=categoryRoomDTO.getCategoryRoomID()%>"><%=categoryRoomDTO.getName()%></option>

									<%
									}
									%>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 form-group">
								<label for="specialRequest">Special Request</label>
								<textarea name="specialRequest" id="specialRequest"
									class="form-control " cols="30" rows="8"></textarea>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 form-group">
								<input type="submit" value="Confirm" class="btn btn-primary">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- END section -->





	<section class="section-cover" data-stellar-background-ratio="0.5"
		style="background-image: url(template/web/images/img_5.jpg);">
		<div class="container">
			<div class="row justify-content-center align-items-center intro">
				<div class="col-md-9 text-center element-animate">
					<h2>Relax and Enjoy your Holiday</h2>
					<p class="lead mb-5">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Architecto quidem tempore expedita facere
						facilis, dolores!</p>
					<div class="btn-play-wrap">
						<a href="https://vimeo.com/channels/staffpicks/93951774"
							class="btn-play popup-vimeo "><span class="ion-ios-play"></span></a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="template/web/client-js/book now.js"></script>
	<%ArrayList<String> errors = (ArrayList<String>)request.getSession().getAttribute("errors");
	if(errors!= null){
		String message = "";
	%>
	<%for (String error:errors) {
		message= message.concat(error + "\n");
	}%>

	<script type="text/javascript">
		alert('<%= message %>')
	</script>


	<%
	request.getSession().removeAttribute("errors");
	}
	%>
</body>



</html>
