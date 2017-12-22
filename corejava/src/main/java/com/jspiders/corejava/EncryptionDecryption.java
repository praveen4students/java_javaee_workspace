package com.jspiders.corejava;

public class EncryptionDecryption {
	
	public static void main(String[] args) {

		String txt = "Praveen Dyamappa";
		String encTxt = CipherUtils.getEncryptedString(txt);
		String decryTxt = CipherUtils.getDecriyptedString(encTxt);
		
		System.out.println("Encrypted Value ===> "+encTxt );
		System.out.println("Decrypted Value ===> "+decryTxt );

	}
}
