package edu.emory.clinical.trials.webapp.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

public class DOSSLSocketFactoryTest {
	
	@Test
	public void testDOSSLSocketFactory() throws UnknownHostException, IOException {
		DOSSLSocketFactory factory = new DOSSLSocketFactory();
		factory.getDefaultCipherSuites();
		factory.getSupportedCipherSuites();
		factory.createSocket("", 1);
		factory.createSocket("", 1, InetAddress.getLocalHost(), 1);
		factory.createSocket(InetAddress.getLocalHost(), 1, InetAddress.getLocalHost(), 1);
		factory.createSocket(InetAddress.getLocalHost(), 1);
	}

}
