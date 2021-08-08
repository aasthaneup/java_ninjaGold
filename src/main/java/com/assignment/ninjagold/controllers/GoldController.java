package com.assignment.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {

	@RequestMapping("/gold")
	public String index(HttpSession session) {
		if(session.getAttribute("totalgold") == null) {
			session.setAttribute("comment", "Let's go!");
			session.setAttribute("totalgold", 0);
		}
		else {
			String comment = (String) session.getAttribute("comment");
			Integer gold = (Integer) session.getAttribute("totalgold");
			session.setAttribute("comment", comment);
			session.setAttribute("totalgold", gold);
		}
		return "index.jsp";
	}

	@RequestMapping(value="/process", method = RequestMethod.POST)
	public String gold(@RequestParam(value ="clicked") String clicked, HttpSession session) {
		System.out.println("Reached process");
		Integer gold = (Integer) session.getAttribute("totalgold");

		String comment = (String) session.getAttribute("comment");
		if(clicked.equals("farm")) {

			System.out.println("clicked farm");
			Random rd = new Random();
			Integer earned = rd.nextInt(11)+10;
			Date dNow = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("MMMMM', ' dd', 'yyyy hh:mm aa");
			String date = ft.format(dNow);
			String cmt = comment+"%*nYou entered a farm and earned "+earned+" gold. ("+date+")\n";
			session.setAttribute("comment", cmt);
			session.setAttribute("totalgold", gold+earned);
			session.setAttribute("color", "green");

		}
		else if(clicked.equals("cave")) {
			System.out.println("clicked cave");
			Random rd = new Random();
			Date dNow = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("MMMMM', ' dd', 'yyyy hh:mm aa");
			String date = ft.format(dNow);	
			Integer earned = rd.nextInt(6)+5;
			session.setAttribute("totalgold", gold+earned);
			session.setAttribute("comment", comment+"%*nYou entered a cave and earned "+earned+" gold. ("+date+")");
			session.setAttribute("color", "green");
		}
		else if(clicked.equals("house")) {
			System.out.println("clicked house");
			Random rd = new Random();
			Date dNow = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("MMMMM', ' dd', 'yyyy hh:mm aa");
			String date = ft.format(dNow);
			Integer earned = rd.nextInt(4)+2;
			session.setAttribute("totalgold", gold+earned);
			session.setAttribute("comment", comment+"%*nYou entered a house and earned "+earned+" gold. ("+date+")");
			session.setAttribute("color", "green");
		}
		else if(clicked.equals("casino")) {
			System.out.println("clicked casino");
			Random rd = new Random();
			Date dNow = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("MMMMM', ' dd', 'yyyy hh:mm aa");
			String date = ft.format(dNow);
			Integer earned = rd.nextInt(101)-50;
			session.setAttribute("totalgold", gold+earned);
			if(earned<0) {
				session.setAttribute("comment", comment+"%*nYou entered a casino and lost "+earned+" gold. ("+date+")");
				session.setAttribute("color", "red");
			}
			else {
				session.setAttribute("comment", comment+"%*nYou entered a casino and earned "+earned+" gold. ("+date+")");
				session.setAttribute("color", "green");
			}
		}

		return "redirect:/gold";

	}

	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/gold";
	}

}
