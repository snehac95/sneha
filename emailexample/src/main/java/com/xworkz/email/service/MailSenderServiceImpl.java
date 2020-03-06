package com.xworkz.email.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.email.controller.MailSenderController;
import com.xworkz.email.util.MailSenderUtil;
@Service
public class MailSenderServiceImpl  implements  MailSenderService {
	
	private static  final Logger logger = Logger.getLogger(MailSenderServiceImpl.class);
	
	public MailSenderServiceImpl() {
		logger.info(this.getClass().getSimpleName() +"object creaed");
	}
	@Autowired
	private MailSenderUtil  mailSenderUtil;
	
	public boolean sendMailToUser(String toEmailId) throws Exception {
		logger.info("------------inside sendMailToUser() of class"+this.getClass().getSimpleName());
		if(toEmailId!=null && toEmailId.length()>0) {
			String subject="information";
			String body="Welcome user";
			boolean status=false;
			try {
				 status= mailSenderUtil.sendMail(toEmailId, subject,body);
				 status=true;
				
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
					return status;
	}
		return false;
	}

}	
	

	

