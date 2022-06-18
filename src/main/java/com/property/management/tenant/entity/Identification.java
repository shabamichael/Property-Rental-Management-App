package com.property.management.tenant.entity;

import com.property.management.tenant.entity.enums.IdType;

public class Identification {
	private final static int saIdLength = 13;
	private final static String incorrectId = "please enter a valid 13 digits  SA-ID number";


	public    String IdentificationNumber(String idType, String idNo) {
		String message = null;
		if (idType.toString().equalsIgnoreCase("SOUTH_AFRICA_ID")) {
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

