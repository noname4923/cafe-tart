package com.cafe.tart.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

//@Log4j2
@Controller
@RequiredArgsConstructor
public class MainController {
	
	/**
	 * 
	 * @param model
	 * @param session(로그인 세션을 확인하기 위함)
	 *       - 
	 * @return
	 * @author nta
	 */
	@RequestMapping(value = "/")
	public String index(Model model, HttpSession session) {
		
		System.out.println(":::: Java Main index Entry 한글 테스트 ::::");
		
		//model.addAttribute("test", "힘든 인생..");
		
		Object member = session.getAttribute("member");
	    if (member != null) {
	        // 로그인된 상태
	        System.out.println("사용자가 로그인된 상태입니다.");
	        System.out.println("사용자 객체 : "+member);
	        //model.addAttribute("loggedIn", true);
	        //model.addAttribute("member", member);
	    } else {
	        // 로그인되지 않은 상태
	        System.out.println("사용자가 로그인되지 않은 상태입니다.");
	        System.out.println("사용자 객체 : "+member);
	        //model.addAttribute("loggedIn", false);
	    }
		
		return "main";
	}
}
