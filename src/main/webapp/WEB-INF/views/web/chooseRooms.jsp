<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Hotel Page</title>
<link rel="stylesheet" type="text/css"
	href="template/web/slick/slick.css" />
<link rel="stylesheet" type="text/css"
	href="template/web/slick/slick-theme.css" />


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
						<h1>Our Rooms</h1>
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

				<div class="col-md-4 mb-4">
					<div class="media d-block room mb-0">
						<div class="imageSlide">
							<figure>
								<img src="template/web/images/img_1.jpg"
									alt="Generic placeholder image" class="img-fluid">
								<div class="overlap-text">
									<span> Featured Room <span class="ion-ios-star"></span>
										<span class="ion-ios-star"></span> <span class="ion-ios-star"></span>
									</span>
								</div>
							</figure>
							<figure>
								<img src="template/web/images/img_1.jpg"
									alt="Generic placeholder image" class="img-fluid">
								<div class="overlap-text">
									<span> Featured Room <span class="ion-ios-star"></span>
										<span class="ion-ios-star"></span> <span class="ion-ios-star"></span>
									</span>
								</div>
							</figure>
						</div>
						<div class="media-body">
							<h3 class="mt-0">
								<a href="#">Presidential Room</a>
							</h3>
							<ul class="room-specs">
								<li><span class="ion-ios-people-outline"></span> 2 Guests</li>
								<li><span class="ion-ios-home" md="md-home"></span> 22 ft <sup>2</sup></li>
							</ul>
							<p>Nulla vel metus scelerisque ante sollicitudin. Fusce
								condimentum nunc ac nisi vulputate fringilla.</p>
							<p>
								<a href="<c:url value='/bookNow'/>"
									class="btn btn-primary btn-sm">Book Now From $20</a>
							</p>
						</div>
					</div>
				</div>


			</div>
		</div>
	</section>




	<section class="section-cover" data-stellar-background-ratio="0.5"
		style="background-image: url(images/img_5.jpg);">
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
	<!-- END section -->
	<script src="<c:url value='/template/web/js/jquery-3.2.1.min.js'/>"></script>
	<script src="<c:url value='/template/web/js/jquery-migrate-3.0.0.js'/>"></script>

	<script type="text/javascript" src="template/web/slick/slick.min.js"></script>
	<script type="text/javascript" src="template/web/client-js/test.js">
		
	</script>
</body>

</html>
