package com.blog.nta.domain.Fegefeuer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/Laby")
public class LabyController {
	
	/**
     * 최초 시작부
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectLabyMainView", method = RequestMethod.GET)
    public String worldEntry(Model model) {
    	return "laby/main";
    }
}
