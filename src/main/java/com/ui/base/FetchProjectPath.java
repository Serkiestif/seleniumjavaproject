package com.ui.base;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FetchProjectPath {

	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		System.out.println(path);
		System.out.println(dateName);
	}

}
