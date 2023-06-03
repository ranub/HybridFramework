package com.utils;

import java.util.Date;

public class utilities {
	public static String generateEmailwithTimeStamp() {
		Date date = new Date();
	  String timestamp= date.toString().replace(" ", "_").replace(":", "_");
		return "amotoori"+timestamp+"@gmail.com";
}
}