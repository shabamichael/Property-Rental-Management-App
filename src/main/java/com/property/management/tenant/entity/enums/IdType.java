/**
 * 
 */
package com.property.management.tenant.entity.enums;

/**
 * @author Michael Shaba
 * Fixed set of constants that represents
 *Predefined Identification types
 */
public enum IdType {
	
SOUTH_AFRICA_ID("SAID"),
PERMANENT_RESIDENCE_PERMIT("PRP"),
TEMPORAY_RESIDENCE_PERMIT("TRP"),
PASSPORT("Passport"),
ASSYLUM("assylum");

	final String identification_type;
	private IdType(String identification_type) {
	this.identification_type = identification_type;
}
}
