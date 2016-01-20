package edu.emory.clinical.trials.webapp.server;

import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class Delegator {

	public static void sendMessage(MimeMessage message) throws Exception {
		// Only actually send the email out if we're in Live App Mode
		if (!Util.isTestMode) {
			Transport.send(message);
		}
	}
	
	public static void persistToDatabase(EntityManager em, Object o) throws Exception {
		if (!Util.isTestMode) {
			em.persist(o);
		}
	}
	
	public static EntityManagerFactory createEntityManagerFactory(String persistenceUnitName) {
		if (!Util.isTestMode) {
			return Persistence.createEntityManagerFactory(persistenceUnitName);
		}
		else {
			return Persistence.createEntityManagerFactory(persistenceUnitName + "Local");
		}
	}
}