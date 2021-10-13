package com.enlacetpe.ticketapi.util;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

public class CifraContrasenas {
	
	

	public static void main(String[] args) throws InterruptedException, IOException {
		AES128 aes = new AES128();
		String encpript = aes.encrypt("DeskService01"); 
		System.out.println(aes.decrypt("DzdXRZB8MrVPqfE5J4NFkA=="));
//		System.out.println(aes.decrypt("bdy8igWx5R1K4kPPTnlJ1A=="));
		
		
		
		System.out.println(encpript);
//		
//		
//		long start = System.nanoTime();
//
//        Thread.sleep(5000);
//
//        long end = System.nanoTime();
//
//        long elapsedTime = end - start;
//
////        System.out.println(elapsedTime);
////
////        // 1 second = 1_000_000_000 nano seconds
////        double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;
////
////        System.out.println(elapsedTimeInSecond + " seconds");
//
//        // TimeUnit
//        long convert = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
//
//        System.out.println(convert + " seconds");


		
		
		
	}

}
