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
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.nhapmoncongnghephanmem.converter.CategoryRoomConverter;
import com.nhapmoncongnghephanmem.dto.CategoryRoomDTO;
import com.nhapmoncongnghephanmem.dto.CodeDTO;
import com.nhapmoncongnghephanmem.dto.RoomDTO;
import com.nhapmoncongnghephanmem.entity.Room;
import com.nhapmoncongnghephanmem.service.impl.CategoryRoomService;
import com.nhapmoncongnghephanmem.service.impl.RoomService;

@Controller
@RequestMapping(value = "/bookingProcessing")
public class BookingProcessingController {
	@Autowired
	private RoomService rooomService;

	@Autowired
	private CategoryRoomService categoryRoomService;

	@Autowired
	private CategoryRoomConverter categoryRoomConverter;

	@PostMapping
	public ModelAndView receiveBookingRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ParseException {
		ModelAndView mav = new ModelAndView("web/checkout");
		ArrayList<String> errors = new ArrayList<String>();
		String numberOfPeople = request.getParameter("numberOfPeople");
		String numberOfPeopleInARoom = request.getParameter("numberOfPeopleInARoom");
		String departureDate = request.getParameter("departure_date");
		String arrivalDate = request.getParameter("arrival_date");
		String roomCategory = request.getParameter("roomCategory");
		String seRequest = request.getParameter("specialRequest");

		response.getWriter().println(arrivalDate);

		if (isVaildIntegerNumber(numberOfPeople) && isVaildIntegerNumber(numberOfPeopleInARoom)
				&& isVaildIntegerNumber(roomCategory) && isVaildDate(arrivalDate) && isVaildDate(departureDate)) {
			response.getWriter().print("2");

			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
			Date checkInDate = sdformat.parse(arrivalDate);
			Date checkOutDate = sdformat.parse(departureDate);
			int roomCategoryID = Integer.parseInt(roomCategory);
			int numberOfPeople1 = Integer.parseInt(numberOfPeople);
			int numberOfPeopleInARoom1 = Integer.parseInt(numberOfPeopleInARoom);
			response.getWriter().print("3");

			if (checkInDate.compareTo(checkOutDate) < 0) {
				// Tim ra phong co the thue
				ArrayList<RoomDTO> rooms = rooomService.findRoom(numberOfPeople1, numberOfPeopleInARoom1,
						roomCategoryID, arrivalDate, departureDate, seRequest);
				// Gui du lieu sang trang checkout
				if (rooms.size() != 0) {
					// Du lieu gui qua
//					ArrayList<Object> data = new ArrayList<Object>();
					CategoryRoomDTO categoryRoomDTO = categoryRoomConverter
							.toDto(categoryRoomService.findByCategoryRoomID(roomCategoryID));
					CodeDTO data = new CodeDTO();

					data.setCheckInDate(arrivalDate);
					data.setCheckOutDate(departureDate);
					data.setRooms(rooms);
					data.setSpecialRequest(seRequest);
					data.setCategoryRoom(categoryRoomDTO);

					request.getSession(true).setAttribute("data", data);
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

		if (errors.size() != 0) {
			mav.setViewName("redirect:/bookNow");
			request.getSession(true).setAttribute("errors", errors);

		}
		return mav;

	}

	// Dung de kiem tra so hop le hay khong
	private boolean isVaildIntegerNumber(String number) {
		try {
			Integer.parseInt(number);
		} catch (NumberFormatException e) {
			return false;

		}
		return true;

	}

	// Dung de kiem tra ngay co hop le khong
	private boolean isVaildDate(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(date.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;

	}

}
