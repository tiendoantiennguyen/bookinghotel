package com.nhapmoncongnghephanmem.controller.web;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nhapmoncongnghephanmem.converter.CategoryRoomConverter;
import com.nhapmoncongnghephanmem.dto.CategoryRoomDTO;
import com.nhapmoncongnghephanmem.dto.CodeDTO;
import com.nhapmoncongnghephanmem.dto.RoomDTO;
import com.nhapmoncongnghephanmem.entity.CategoryRoom;
import com.nhapmoncongnghephanmem.repository.CategoryRoomRepository;
import com.nhapmoncongnghephanmem.service.impl.CategoryRoomService;
import com.nhapmoncongnghephanmem.service.impl.RoomService;

@Controller
@RequestMapping(value = "/searchCancelRoom")
public class SearchCancelRoomCotroller {
	@Autowired
	private RoomService rooomService;

	@Autowired
	private CategoryRoomService categoryRoomService;

	@Autowired
	private CategoryRoomConverter categoryRoomConverter;
	
	@Autowired
	private CategoryRoomRepository categoryRoomRepository;

	@PostMapping
	public ModelAndView receiveSearchCancelRoomRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ParseException {
		//lay thong tin ma dat phong
		ModelAndView mav = new ModelAndView("web/cancelRoom");
		ArrayList<String> errors = new ArrayList<String>();
		String code = request.getParameter("code");
		
		response.getWriter().println("1");
		//kiem tra so hop le ko
		if (isVaildIntegerNumber(code) ) {
			response.getWriter().print("2");
			//chuyen doi string sang int
			int bill_ID = Integer.parseInt(code);
			response.getWriter().print("3");

			if (true) {
				// Tim phong can huy
				ArrayList<RoomDTO> rooms = rooomService.findRoom(bill_ID);
				//tim roomCategoryID
				String roomCategory = null;
				CategoryRoom categoryRoom = null;
				int roomCategoryID = 0;
				for (RoomDTO room : rooms) {
					roomCategory = room.getCategoryRoom();
					 categoryRoom = categoryRoomRepository.findOneByName(roomCategory);
					
//					roomCategoryID = Integer.parseInt(roomCategory);
					//lay database categoryRoom
//					ArrayList<CategoryRoomDTO> categoryList = (ArrayList<CategoryRoomDTO>) request.getAttribute("CategoryList");
//					for (int i = 0; i < categoryList.size(); i++) {
//						CategoryRoomDTO categoryRoomDTO = categoryList.get(i);
//						if (categoryRoomDTO.getName().equals(roomCategory)) {
//							roomCategoryID = categoryRoomDTO.getCategoryRoomID();
//						}
//					}
				}
				// Gui du lieu sang trang checkout
				if (rooms.size() != 0) {
					// Du lieu gui qua
					response.getWriter().print("6");
				
					CategoryRoomDTO categoryRoomDTO = categoryRoomConverter
							.toDto(categoryRoom);
					CodeDTO data = new CodeDTO();

					data.setRooms(rooms);
					data.setCategoryRoom(categoryRoomDTO);
					request.getSession(true).setAttribute("data", data);
					response.getWriter().print("7");
//					mav.addObject("data", data);
				} else {
					errors.add("There are no room available.");
				}
			} else {
				errors.add("Depature Date are sooner than Arrival Date");
			}

		} else {
			errors.add("Data are not valid");
		}
		response.getWriter().print("4");
		if (errors.size() != 0) {
			mav.setViewName("redirect:/searchCancelRoom");
		}
		response.getWriter().print("5");
		return mav;


	}

	// Dung de kiem tra so hop le hay khong
	public boolean isVaildIntegerNumber(String number) {
		try {
			Integer.parseInt(number);
		} catch (NumberFormatException e) {
			return false;

		}
		return true;

	}

}
