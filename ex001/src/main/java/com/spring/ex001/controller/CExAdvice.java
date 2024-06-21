package com.spring.ex001.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j2;


@ControllerAdvice
@Log4j2
public class CExAdvice {
	
	@ExceptionHandler
	public String except(Exception e, Model model) {
		
		log.info("e");
		log.debug("e");
		model.addAttribute("e", e);
		return "/common/error";
	}
}
