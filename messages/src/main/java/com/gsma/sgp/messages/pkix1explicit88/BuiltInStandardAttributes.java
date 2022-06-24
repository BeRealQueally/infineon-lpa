/**
 * This class file was automatically generated by jASN1 v1.11.3 (http://www.beanit.com)
 */

package com.gsma.sgp.messages.pkix1explicit88;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.jasn1.ber.*;
import com.beanit.jasn1.ber.types.*;
import com.beanit.jasn1.ber.types.string.*;


public class BuiltInStandardAttributes implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	private CountryName countryName = null;
	private AdministrationDomainName administrationDomainName = null;
	private NetworkAddress networkAddress = null;
	private TerminalIdentifier terminalIdentifier = null;
	private PrivateDomainName privateDomainName = null;
	private OrganizationName organizationName = null;
	private NumericUserIdentifier numericUserIdentifier = null;
	private PersonalName personalName = null;
	private OrganizationalUnitNames organizationalUnitNames = null;
	
	public BuiltInStandardAttributes() {
	}

	public BuiltInStandardAttributes(byte[] code) {
		this.code = code;
	}

	public void setCountryName(CountryName countryName) {
		this.countryName = countryName;
	}

	public CountryName getCountryName() {
		return countryName;
	}

	public void setAdministrationDomainName(AdministrationDomainName administrationDomainName) {
		this.administrationDomainName = administrationDomainName;
	}

	public AdministrationDomainName getAdministrationDomainName() {
		return administrationDomainName;
	}

	public void setNetworkAddress(NetworkAddress networkAddress) {
		this.networkAddress = networkAddress;
	}

	public NetworkAddress getNetworkAddress() {
		return networkAddress;
	}

	public void setTerminalIdentifier(TerminalIdentifier terminalIdentifier) {
		this.terminalIdentifier = terminalIdentifier;
	}

	public TerminalIdentifier getTerminalIdentifier() {
		return terminalIdentifier;
	}

	public void setPrivateDomainName(PrivateDomainName privateDomainName) {
		this.privateDomainName = privateDomainName;
	}

	public PrivateDomainName getPrivateDomainName() {
		return privateDomainName;
	}

	public void setOrganizationName(OrganizationName organizationName) {
		this.organizationName = organizationName;
	}

	public OrganizationName getOrganizationName() {
		return organizationName;
	}

	public void setNumericUserIdentifier(NumericUserIdentifier numericUserIdentifier) {
		this.numericUserIdentifier = numericUserIdentifier;
	}

	public NumericUserIdentifier getNumericUserIdentifier() {
		return numericUserIdentifier;
	}

	public void setPersonalName(PersonalName personalName) {
		this.personalName = personalName;
	}

	public PersonalName getPersonalName() {
		return personalName;
	}

	public void setOrganizationalUnitNames(OrganizationalUnitNames organizationalUnitNames) {
		this.organizationalUnitNames = organizationalUnitNames;
	}

	public OrganizationalUnitNames getOrganizationalUnitNames() {
		return organizationalUnitNames;
	}

	public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		int sublength;

		if (organizationalUnitNames != null) {
			codeLength += organizationalUnitNames.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 6
			reverseOS.write(0xA6);
			codeLength += 1;
		}
		
		if (personalName != null) {
			codeLength += personalName.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 5
			reverseOS.write(0xA5);
			codeLength += 1;
		}
		
		if (numericUserIdentifier != null) {
			codeLength += numericUserIdentifier.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 4
			reverseOS.write(0x84);
			codeLength += 1;
		}
		
		if (organizationName != null) {
			codeLength += organizationName.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 3
			reverseOS.write(0x83);
			codeLength += 1;
		}
		
		if (privateDomainName != null) {
			sublength = privateDomainName.encode(reverseOS);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(reverseOS, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 2
			reverseOS.write(0xA2);
			codeLength += 1;
		}
		
		if (terminalIdentifier != null) {
			codeLength += terminalIdentifier.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 1
			reverseOS.write(0x81);
			codeLength += 1;
		}
		
		if (networkAddress != null) {
			codeLength += networkAddress.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 0
			reverseOS.write(0x80);
			codeLength += 1;
		}
		
		if (administrationDomainName != null) {
			codeLength += administrationDomainName.encode(reverseOS, true);
		}
		
		if (countryName != null) {
			codeLength += countryName.encode(reverseOS, true);
		}
		
		codeLength += BerLength.encodeLength(reverseOS, codeLength);

		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;

	}

	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		int totalLength = length.val;
		codeLength += totalLength;

		if (totalLength == 0) {
			return codeLength;
		}
		subCodeLength += berTag.decode(is);
		if (berTag.equals(CountryName.tag)) {
			countryName = new CountryName();
			subCodeLength += countryName.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(AdministrationDomainName.tag)) {
			administrationDomainName = new AdministrationDomainName();
			subCodeLength += administrationDomainName.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 0)) {
			networkAddress = new NetworkAddress();
			subCodeLength += networkAddress.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
			terminalIdentifier = new TerminalIdentifier();
			subCodeLength += terminalIdentifier.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2)) {
			subCodeLength += length.decode(is);
			privateDomainName = new PrivateDomainName();
			subCodeLength += privateDomainName.decode(is, null);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 3)) {
			organizationName = new OrganizationName();
			subCodeLength += organizationName.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 4)) {
			numericUserIdentifier = new NumericUserIdentifier();
			subCodeLength += numericUserIdentifier.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 5)) {
			personalName = new PersonalName();
			subCodeLength += personalName.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 6)) {
			organizationalUnitNames = new OrganizationalUnitNames();
			subCodeLength += organizationalUnitNames.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + totalLength + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		boolean firstSelectedElement = true;
		if (countryName != null) {
			sb.append("\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("countryName: ");
			countryName.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (administrationDomainName != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("administrationDomainName: ");
			administrationDomainName.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (networkAddress != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("networkAddress: ").append(networkAddress);
			firstSelectedElement = false;
		}
		
		if (terminalIdentifier != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("terminalIdentifier: ").append(terminalIdentifier);
			firstSelectedElement = false;
		}
		
		if (privateDomainName != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("privateDomainName: ");
			privateDomainName.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (organizationName != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("organizationName: ").append(organizationName);
			firstSelectedElement = false;
		}
		
		if (numericUserIdentifier != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("numericUserIdentifier: ").append(numericUserIdentifier);
			firstSelectedElement = false;
		}
		
		if (personalName != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("personalName: ");
			personalName.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (organizationalUnitNames != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("organizationalUnitNames: ");
			organizationalUnitNames.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

