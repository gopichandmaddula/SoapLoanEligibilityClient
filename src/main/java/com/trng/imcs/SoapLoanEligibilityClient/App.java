package com.trng.imcs.SoapLoanEligibilityClient;

import trng.imcs.soap.client.LoanRequest;
import trng.imcs.soap.client.LoanResponse;
import trng.imcs.soap.client.ServiceImplService;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws DatatypeConfigurationException {
    ServiceImplService loanService = new ServiceImplService();

	LoanRequest loanRequest = createLoanRequest();
	
	LoanResponse loanResponse = loanService.getServiceImplPort().testEligibility(loanRequest);

	display(loanResponse);
	}


private static void display(LoanResponse loanResponse) {
	System.out.println(loanResponse.getEligibilityCode()+" , "+loanResponse.getEligibilityResponse());
}

private static LoanRequest createLoanRequest() throws DatatypeConfigurationException {
	XMLGregorianCalendar dob = DatatypeFactory.newInstance().newXMLGregorianCalendar("1994-12-25");
	XMLGregorianCalendar tenure = DatatypeFactory.newInstance().newXMLGregorianCalendar("2018-06-14");
	
	LoanRequest loanRequest = new LoanRequest();

	loanRequest.setAmount(19000.0f);
	loanRequest.setAnnualsalary(80000.0f);
	loanRequest.setDob(dob);
	loanRequest.setTenure(tenure);
	loanRequest.setGender("M");
	
	return loanRequest;
}
}
