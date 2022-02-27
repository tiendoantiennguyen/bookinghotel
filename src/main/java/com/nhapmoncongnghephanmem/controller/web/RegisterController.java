package com.nhapmoncongnghephanmem.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nhapmoncongnghephanmem.dto.UserDTO;
import com.nhapmoncongnghephanmem.entity.Role;
import com.nhapmoncongnghephanmem.entity.User;
import com.nhapmoncongnghephanmem.service.IRoleService;
import com.nhapmoncongnghephanmem.service.IUserService;


@Controller
public class RegisterController {
	@Autowired IUserService userservice;
	@Autowired IRoleService roleservice;
	
	
	// Ajax kiem tra ten dang nhap
	@RequestMapping(value = "/login/kiemtra/tendangnhap", method = RequestMethod.POST)
	public @ResponseBody String check(HttpServletRequest req , Model model) {
		String userName = req.getParameter("userName");
		return userservice.checkTendangnhap(userName);
	}

	 @RequestMapping(value = "/login/register", method = RequestMethod.GET)
	 public ModelAndView registerPage() {
	    ModelAndView mav = new ModelAndView("login/register");
	    	UserDTO model = new UserDTO();
	    	mav.addObject("model", model);
	    return mav;
	 }
	 
		// Xu ly dang ky tai khoan
		@RequestMapping(value ="/login/enterRegister", method = RequestMethod.POST)
		public String xulydangky(@ModelAttribute("taikhoan") UserDTO tkdk, Model model, HttpServletRequest request, HttpSession session) {
			try {
				// Ma hoa mat khau bang Bcrypt
				String matkhauBCrypt = BCrypt.hashpw(tkdk.getPassword(), BCrypt.gensalt(10));
				// Lay danh sach quyen tham chieu
				List<Role> quyens = (List<Role>) roleservice.roles(2);
				User tk = new User(tkdk.getUserName(), tkdk.getFullName(), tkdk.getPhoneNumber(), tkdk.getEmail(), matkhauBCrypt, tkdk.getCMND(), 1, quyens);

				session.setAttribute("tk", tk);

			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("message", "upload thất bại");
			}
			return "redirect:/login";
		}
	 

}
