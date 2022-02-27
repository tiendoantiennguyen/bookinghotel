package com.nhapmoncongnghephanmem.controller.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nhapmoncongnghephanmem.service.impl.CategoryRoomService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

	@Autowired
	private CategoryRoomService categoryRoomService;

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/home");
		return mav;
	}

	@RequestMapping(value = "/rooms", method = RequestMethod.GET)
	public ModelAndView springMVCPage() {
		ModelAndView mav = new ModelAndView("web/rooms");
		return mav;
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contactPage() {
		ModelAndView mav = new ModelAndView("web/contact");
		return mav;
	}

	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public ModelAndView blogPage() {
		ModelAndView mav = new ModelAndView("web/blog");
		return mav;
	}

	@RequestMapping(value = "/blog-detail", method = RequestMethod.GET)
	public ModelAndView servicesPage() {
		ModelAndView mav = new ModelAndView("web/blog-detail");
		return mav;
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView checkoutPage() {
		ModelAndView mav = new ModelAndView("web/checkout");
		return mav;
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView aboutPage() {
		ModelAndView mav = new ModelAndView("web/about");
		return mav;
	}

	@RequestMapping(value = "/bookNow", method = RequestMethod.GET)
	public ModelAndView bookingPage(HttpServletRequest request) {
		CategoryRoomService service = new CategoryRoomService();
		ModelAndView mav = new ModelAndView("web/bookNow");
		mav.addObject("CategoryList", categoryRoomService.findAll());

		return mav;
	}

	@RequestMapping(value = "/searchCancelRoom", method = RequestMethod.GET)
	public ModelAndView searchCancelRoomPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/searchCancelRoom");

		return mav;
	}

	@RequestMapping(value = "/cancelRoom", method = RequestMethod.GET)
	public ModelAndView cancelRoomPage() {
		ModelAndView mav = new ModelAndView("web/cancelRoom");
		return mav;
	}

	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/login?accessDenied");
	}

}