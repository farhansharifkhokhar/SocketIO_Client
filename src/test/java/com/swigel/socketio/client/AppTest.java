package com.swigel.socketio.client;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */

public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {

		// Creating Connection using socket.io-client

		// sockt io call to fetch Tops data
		SwigelClientImp swigelClientImp = new SwigelClientImp();
		swigelClientImp.getTopsSocketResponse();
		assertTrue(true);
	}
}
