package com.cafe.tart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/oauth")
public class OauthController {

	@ResponseBody
	@RequestMapping(value = "/reqAuthKey", method = { RequestMethod.GET})
	public String oauth(@RequestParam("code") String code) {
		
		System.out.println(":::: code : "+code);
		
		return "Authorization code: " + code;
	}

}
