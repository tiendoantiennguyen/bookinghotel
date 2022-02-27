<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancel Room</title>
</head>
<body>
<section class="site-hero site-hero-innerpage overlay" data-stellar-background-ratio="0.5" style="background-image: url(template/web/images/big_image_1.jpg);">
      <div class="container">
        <div class="row align-items-center site-hero-inner justify-content-center">
          <div class="col-md-12 text-center">

            <div class="mb-5 element-animate">
              <h1>Cancel Room</h1>
              <p>Discover our world's #1 Luxury Room For VIP.</p>
            </div>

          </div>
        </div>
      </div>
    </section>
<!--     END section -->

    <section class="site-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2 class="mb-5">Cancel Room Form</h2>
					<form action="/searchCancelRoom"
						onsubmit="return validateForm()" method="post">

						<div class="row">
							<div class="col-md-4 form-group">
								<label for="room">Code</label> 
								<input name="code" class="form-control " required="required">
							</div>

						</div>
						<div class="row">
							<div class="col-md-6 form-group">
								<input type="submit" value="Cancel Room" class="btn btn-primary">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- END section -->



   
   

    <section class="section-cover" data-stellar-background-ratio="0.5" style="background-image: url(template/web/images/img_5.jpg);">
      <div class="container">
        <div class="row justify-content-center align-items-center intro">
          <div class="col-md-9 text-center element-animate">
            <h2>Relax and Enjoy your Holiday</h2>
            <p class="lead mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Architecto quidem tempore expedita facere facilis, dolores!</p>
            <div class="btn-play-wrap"><a href="https://vimeo.com/channels/staffpicks/93951774" class="btn-play popup-vimeo "><span class="ion-ios-play"></span></a></div>
          </div>
        </div>
      </div>
    </section>
<!--     END section -->


	

</body>
</html>