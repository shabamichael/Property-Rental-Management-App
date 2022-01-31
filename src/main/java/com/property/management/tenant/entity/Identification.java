package com.property.management.tenant.entity;




public class Identification {
	private final static int saIdLength = 13;
	private final static String incorrectId = "please enter a valid 13 digits  SA-ID number";


	private  static final String IdentificationNumber(String identification, String idNo) {
		String message = null;
		if (identification.equals("SAID")) {
			idNo.trim();

			if ((idNo.length() > saIdLength) || (idNo.length() < saIdLength) || (idNo.isBlank()) || (idNo.isEmpty())
					|| (idNo == null) ) {
				message = incorrectId;
			} else {
				message = idNo;
			}
		}
		return message;
	}
}

