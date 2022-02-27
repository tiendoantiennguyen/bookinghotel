<%@ page import="com.nhapmoncongnghephanmem.util.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

    
    <header role="banner">
     
      <nav class="navbar navbar-expand-md navbar-dark bg-light">
        <div class="container">
          <a class="navbar-brand" href="<c:url value='/trang-chu'/>">LuxuryHotel</a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample05" aria-controls="navbarsExample05" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse navbar-light" id="navbarsExample05">
            <ul class="navbar-nav ml-auto pl-lg-5 pl-0">
              <li class="nav-item">
                <a class="nav-link active" href="<c:url value='/trang-chu'/>" >Home</a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="<c:url value='/rooms'/>" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Rooms</a>
                <div class="dropdown-menu" aria-labelledby="dropdown04">
                  <a class="dropdown-item" href="<c:url value='/rooms'/>">Room Videos</a>
                  <a class="dropdown-item" href="<c:url value='/rooms'/>">Presidential Room</a>
                  <a class="dropdown-item" href="<c:url value='/rooms'/>">Luxury Room</a>
                  <a class="dropdown-item" href="<c:url value='/rooms'/>">Deluxe Room</a>
                </div>

              </li>
              <li class="nav-item">
                <a class="nav-link" href="<c:url value='/blog'/>" >Blog</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="<c:url value='/about'/>" >About</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="<c:url value='/contact'/>" >Contact</a>
              </li>
                 <li class="nav-item">
                <a class="nav-link" href="<c:url value='/searchCancelRoom'/>" >Cancel Room</a>
              </li>
              
          		<sec:authorize access = "isAnonymous()">			
         			<li class="nav-item">
                		<a class="nav-link" href="<c:url value='/login'/>" >Login</a>
              		</li>	
				</sec:authorize>
				
				<sec:authorize access = "isAuthenticated()">			
					<li class="nav-item"><a class="nav-link" href="#">Wellcome: <%=SecurityUtils.getPrincipal().getFullName()%></a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value='/thoat'/>">Logout</a></li>
				</sec:authorize>
              
              
            </ul>
            
          </div>
        </div>
      </nav>
    </header>

