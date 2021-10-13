package com.enlacetpe.ticketapi.util;

import java.io.InputStream;
import java.util.Base64;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class AES128{
	
	
	public  String encrypt(String plainText) {
        try {
        	Properties properties = properties();
        	Cipher cipher = Cipher.getInstance(properties.getProperty("instance"));
            SecretKeySpec secretKey = new SecretKeySpec(properties.getProperty("keyString").getBytes(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] cipherText = cipher.doFinal(plainText.getBytes("UTF8"));
            String encryptedString = new String(Base64.getEncoder().encode(cipherText),"UTF-8");
            return encryptedString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	 
	public  String decrypt(String encryptedText) {
        try {
        	Properties properties = properties();
            Cipher cipher = Cipher.getInstance(properties.getProperty("instance"));
            SecretKeySpec secretKey = new SecretKeySpec(properties.getProperty("keyString").getBytes(), "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] cipherText = Base64.getDecoder().decode(encryptedText.getBytes("UTF8"));
            String decryptedString = new String(cipher.doFinal(cipherText),"UTF-8");
            return decryptedString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	private Properties properties() {
		Properties properties = new Properties();
		try {
			InputStream input = getClass().getClassLoader().getResourceAsStream("AES128.properties");
			properties.load(input);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return properties;
	}


	
	
	
}
