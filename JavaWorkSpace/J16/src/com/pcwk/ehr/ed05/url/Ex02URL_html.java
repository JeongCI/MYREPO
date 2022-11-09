package com.pcwk.ehr.ed05.url;

import java.net.*;
import java.io.*;

public class Ex02URL_html {

	public static void main(String[] args) {
		String address = "https://sinchon.koreaisacademy.com/";

		URL url = null;
		BufferedReader input = null;

		try {
			url = new URL(address);
			input = new BufferedReader(new InputStreamReader(url.openStream(), "euc-kr"));

			String line = "";
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
