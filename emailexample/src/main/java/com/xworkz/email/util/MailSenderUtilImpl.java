package com.xworkz.email.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;

import com.xworkz.email.controller.MailSenderController;
@Controller
public class MailSenderUtilImpl implements MailSenderUtil {
	@Autowired
	private MailSender mailSender;
	private static final Logger logger = Logger.getLogger(MailSenderUtilImpl.class);

	public MailSenderUtilImpl() {
		logger.info(this.getClass().getSimpleName() + "object created");
	}

	public boolean sendMail(String toEmailId, String subject, String body) throws Exception {
		logger.info("---------inside sendMail" + this.getClass().getSimpleName() + "object created");
		boolean status = false;
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(toEmailId);
			message.setSubject(subject);
			message.setText(body);
			mailSender.send(message);
			status = true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return false;
	}

}
