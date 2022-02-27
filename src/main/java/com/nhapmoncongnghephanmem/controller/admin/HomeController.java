package com.nhapmoncongnghephanmem.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
  
   @RequestMapping(value = "/quan-tri/trang-chu", method = RequestMethod.GET)
   public ModelAndView homePage() {
      ModelAndView mav = new ModelAndView("admin/home");
      return mav;
   }
   
   @RequestMapping(value = "/quan-tri/401Page", method = RequestMethod.GET)
   public ModelAndView error401Page() {
      ModelAndView mav = new ModelAndView("admin/401");
      return mav;
   }
   
   @RequestMapping(value = "/quan-tri/quan-li-phong", method = RequestMethod.GET)
   public ModelAndView quanLiPhongPage() {
      ModelAndView mav = new ModelAndView("admin/quanliphong");
      return mav;
   }
  
}