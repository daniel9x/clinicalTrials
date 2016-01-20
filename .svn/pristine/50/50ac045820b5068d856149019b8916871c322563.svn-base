package edu.emory.clinical.trials.webapp.server;

import java.io.FileInputStream;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class EmailManager {

	private Properties externalProperties = new Properties();

	private String environment;
	
	private Logger logger = Logger.getLogger(EmailManager.class.getName());

	public EmailManager() throws Exception {

		try {
			FileInputStream fileInputStream = new FileInputStream("./external.properties.xml");
			externalProperties.loadFromXML(fileInputStream);
			environment = externalProperties.getProperty("environment");
		}
		catch (Exception e) {
			logger.error("ERROR:", e);
			environment = "PROD";
		}
	}

	static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");

	public void sendExtractSuccessEmail(Integer trialNumber) throws Exception {
		
		Session mailSession = Session.getDefaultInstance(new Properties(), null);
		MimeMessage message = new MimeMessage(mailSession);
		message.addFrom(new InternetAddress[] {new InternetAddress("clinicaltrials@emory.edu")});
		message.addRecipient(RecipientType.TO, new InternetAddress("dsgrant@emory.edu"));
		message.addRecipient(RecipientType.TO, new InternetAddress("margaret.may@emory.edu"));

		message.setSubject("ClinicalTrials.gov Data Extraction Success.");
		message.setContent("Hello,<br><br>" + "The ClinicalTrials.gov Data Extraction was a success. "
				+ "Number of extracted trials: " + trialNumber + 
				"<br><br>Time Completed: " + dateFormat.format(new Date()) + 
				"<br><br>Environment: " + environment + " -- " + InetAddress.getLocalHost().getHostName(), "text/html");
		Delegator.sendMessage(message);
		logger.info("Success Mail Sent.");
	}

	public void sendExtractFailureEmail(Exception e) throws Exception {
		Session mailSession = Session.getDefaultInstance(new Properties(), null);
		MimeMessage message = new MimeMessage(mailSession);
		message.addFrom(new InternetAddress[] {new InternetAddress("clinicaltrials@emory.edu")});
		message.addRecipient(RecipientType.TO, new InternetAddress("dsgrant@emory.edu"));
		message.addRecipient(RecipientType.TO, new InternetAddress("margaret.may@emory.edu"));

		message.setSubject("ClinicalTrials.gov Data Extraction Status - Failure Reported.");
		message.setContent("Hello,<br><br>" + "The ClinicalTrials.gov Data Extraction encountered an error: " 
		+ e.getMessage() + "<br>Please see the log for more details on the error.<br><br>Time Captured: " + dateFormat.format(new Date()) 
		+ "<br><br>Environment: " + environment + " -- " + InetAddress.getLocalHost().getHostName(), "text/html");
		Delegator.sendMessage(message);
		logger.info("Failure Mail Sent.");
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

}