package com.xworkz.email.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.email.service.MailSenderService;

@Controller

public class MailSenderController {
	private static final Logger logger = Logger.getLogger(MailSenderController.class);

	public MailSenderController() {
		logger.info(this.getClass().getSimpleName() + "object created");

	}

	@Autowired
	private MailSenderService mailSenderService;

	@PostMapping("/sendMsg.do")
	public ModelAndView sendMail(String emailId) {
		 ModelAndView mv=new  ModelAndView("/home");
		logger.info("------inside sendMail() of class:" +this.getClass().getSimpleName()+"--------");
		logger.info("Email Id :" +emailId);
		try {
			 mailSenderService.sendMailToUser(emailId);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			//throw new
		}
		return mv;
			
		}
	}
