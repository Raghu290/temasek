package com.hackathon.temasek.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class SMSGenerator {

	public String ACCESS_TOKEN;
	
	public String SMS_BODY="Your OTP for Temasek Login : ";
	public String FROM = "TXTSMS";

	public SMSGenerator(String ACCESS_TOKEN){
		this.ACCESS_TOKEN = ACCESS_TOKEN;
	}

	public String send(String userMobileNumber,String countryCode) throws Exception {
		String OTP = String.format("%04d", new Random().nextInt(10000));
	
		
		String apiEndPoint = "https://portal.mobtexting.com/api/v2/";
		String urlToRead = apiEndPoint + "sms/send?access_token=" + this.ACCESS_TOKEN + "&message="
				    + this.SMS_BODY+OTP  + "&sender="+ this.FROM + "&to=" + countryCode+userMobileNumber + "&service=T";
        System.out.println("aasss :"+urlToRead);
		StringBuilder result = new StringBuilder();

		URL url = null;

		
			url = new URL(urlToRead);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			rd.close();
		

		return OTP;
	}
	
	 /* String OTP() 
	    { 
	   return String.format("%04d", new Random().nextInt(10000));
	       // Using numeric values 
	        String numbers = "0123456789"; 
	  
	        // Using random method 
	        Random rndm_method = new Random(); 
	  
	        char[] otp = new char[len]; 
	  
	        for (int i = 0; i < len; i++) 
	        { 
	            // Use of charAt() method : to get character value 
	            // Use of nextInt() as it is scanning the value as int 
	            otp[i] = 
	             numbers.charAt(rndm_method.nextInt(numbers.length())); 
	        } 
	        return otp.toString(); */
	     
}
