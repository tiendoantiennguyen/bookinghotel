<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Hotel</title>

</head>

<body>
	    <section class="site-hero overlay" data-stellar-background-ratio="0.5" style="background-image: url(template/web/images/big_image_1.jpg);">
      <div class="container">
        <div class="row align-items-center site-hero-inner justify-content-center">
          <div class="col-md-12 text-center">

            <div class="mb-5 element-animate">
              <h1>Welcome To Our Luxury Rooms</h1>
              <p>Discover our world's #1 Luxury Room For VIP.</p>
              <p><a href="rooms" class="btn btn-primary">Book Now</a></p>
            </div>

          </div>
        </div>
      </div>
    </section>
    <!-- END section -->

    <section class="site-section">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-md-4">
            <div class="heading-wrap text-center element-animate">
              <h4 class="sub-heading">Stay with our luxury rooms</h4>
              <h2 class="heading">Stay and Enjoy</h2>
              <p class="mb-5">Many properties have updated us with enhanced health and safety measures. So when looking for a place to stay for your next vacation, you can see things like</p>
              <p><a href="#" class="btn btn-primary btn-sm">More About Us</a></p>
            </div>
          </div>
          <div class="col-md-1"></div>
          <div class="col-md-7">
            <img src="template/web/images/f_img_1.png" alt="Image placeholder" class="img-md-fluid">
          </div>
        </div>
      </div>
    </section>
    <!-- END section -->

    <section class="site-section bg-light">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md-12 heading-wrap text-center">
            <h4 class="sub-heading">Our Luxury Rooms</h4>
              <h2 class="heading">Featured Rooms</h2>
          </div>
        </div>
        <div class="row ">
          <div class="col-md-7">
            <div class="media d-block room mb-0">
              <figure>
                <img src="template/web/images/img_1.jpg" alt="Generic placeholder image" class="img-fluid">
                <div class="overlap-text">
                  <span>
                    Featured Room 
                    <span class="ion-ios-star"></span>
                    <span class="ion-ios-star"></span>
                    <span class="ion-ios-star"></span>
                  </span>
                </div>
              </figure>
              <div class="media-body">
                <h3 class="mt-0"><a href="#">Presidential Room</a></h3>
                <ul class="room-specs">
                  <li><span class="ion-ios-people-outline"></span> 2 Guests</li>
                  <li><span class="ion-ios-crop"></span> 22 ft <sup>2</sup></li>
                </ul>
                <p>Sense Legend Hotel & Spa offers elegant and comfortable accommodations in a central location in Ho Chi Minh City, within 200 meters from Tao Dan Park. The property features a 24-hour front desk and free WiFi throughout the property.. </p>
                <p><a href="<c:url value='/bookNow'/>" class="btn btn-primary btn-sm">Book Now From $20</a></p>
              </div>
            </div>
          </div>
          <div class="col-md-5 room-thumbnail-absolute">
            <a href="#" class="media d-block room bg first-room" style="background-image: url(template/web/images/img_2.jpg); ">
              <!-- <figure> -->
                <div class="overlap-text">
                  <span>
                    Hotel Room 
                    <span class="ion-ios-star"></span>
                    <span class="ion-ios-star"></span>
                    <span class="ion-ios-star"></span>
                  </span>
                  <span class="pricing-from">
                    from $22
                  </span>
                </div>
                
              <!-- </figure> -->
            </a>

            <a href="#" class="media d-block room bg second-room" style="background-image: url(template/web/images/img_4.jpg); ">
              <!-- <figure> -->
                <div class="overlap-text">
                  <span>
                    Hotel Room 
                    <span class="ion-ios-star"></span>
                    <span class="ion-ios-star"></span>
                    <span class="ion-ios-star"></span>
                  </span>
                  <span class="pricing-from">
                    from $22
                  </span>
                </div>
              <!-- </figure> -->
            </a>
            
          </div>
        </div>
      </div>
    </section>

   
    
    <section class="section-cover" data-stellar-background-ratio="0.5" style="background-image: url(template/web/images/img_5.jpg);">
      <div class="container">
        <div class="row justify-content-center align-items-center intro">
          <div class="col-md-9 text-center element-animate">
            <h2>Relax and Enjoy your Holiday</h2>
            <p class="lead mb-5">Couples especially like the location — they rate it 8.8 for a 2-person stay.!</p>
            <div class="btn-play-wrap"><a href="https://vimeo.com/channels/staffpicks/93951774" class="btn-play popup-vimeo "><span class="ion-ios-play"></span></a></div>
          </div>
        </div>
      </div>
    </section>
    <!-- END section -->
    
    <section class="site-section bg-light">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md-12 heading-wrap text-center">
            <h4 class="sub-heading">Our Blog</h4>
              <h2 class="heading">Our Recent Blog</h2>
          </div>
        </div>
        <div class="row ">
          <div class="col-md-4">
            <div class="post-entry">
              <img src="template/web/images/img_3.jpg" alt="Image placeholder" class="img-fluid">
              <div class="body-text">
                <div class="category">Rooms</div>
                <h3 class="mb-3"><a href="#">New Rooms</a></h3>
                <p class="mb-4">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsum deserunt illo quis similique dolore voluptatem culpa voluptas rerum, dolor totam.</p>
                <p><a href="#" class="btn btn-primary btn-outline-primary btn-sm">Read More</a></p>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="post-entry">
              <img src="template/web/images/img_6.jpg" alt="Image placeholder" class="img-fluid">
              <div class="body-text">
                <div class="category">News</div>
                <h3 class="mb-3"><a href="#">New Staff Added</a></h3>
                <p class="mb-4">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsum deserunt illo quis similique dolore voluptatem culpa voluptas rerum, dolor totam.</p>
                <p><a href="#" class="btn btn-primary btn-outline-primary btn-sm">Read More</a></p>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="post-entry">
              <img src="template/web/images/img_5.jpg" alt="Image placeholder" class="img-fluid">
              <div class="body-text">
                <div class="category">New Rooms</div>
                <h3 class="mb-3"><a href="#">Big Rooms for All</a></h3>
                <p class="mb-4">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsum deserunt illo quis similique dolore voluptatem culpa voluptas rerum, dolor totam.</p>
                <p><a href="#" class="btn btn-primary btn-outline-primary btn-sm">Read More</a></p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- END section -->
    
    
 
    
    
    
</body>

</html>
