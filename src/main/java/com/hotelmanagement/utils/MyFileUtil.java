package com.hotelmanagement.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyFileUtil {

	public static MyFileUtil getInstance() {
		return new MyFileUtil();
	}

	public String removeDoubleSlash(String str) {
		while (str.contains("//"))
			str = str.replace("//", "/");
		return str;
	}

	@SuppressWarnings("resource")
	public byte[] getByteBySource(String source) {
		try {
			InputStream stream = new FileInputStream(source);
			if (stream != InputStream.nullInputStream()) {
				byte[] res = stream.readAllBytes();
				stream.close();
				return res;
			}
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
