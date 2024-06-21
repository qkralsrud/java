package com.spring.ex001.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionAdvice {

	// Exception이 발생한경우, 해당 메서드를 실행
	@ExceptionHandler(Exception.class)
	public String except(Exception e, Model model) {
		
		e.printStackTrace();
		model.addAttribute("msg", "예외사항이 발생 했습니다. 관리자에게 문의해주세요." + e.getMessage());
		return "/common/msgBox";
	}
}
