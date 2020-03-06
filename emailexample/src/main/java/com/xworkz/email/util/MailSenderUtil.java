package com.xworkz.email.util;

public interface MailSenderUtil {
	public boolean sendMail(String toEmailId, String subject, String body) throws Exception;

}
