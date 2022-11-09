package com.pcwk.ehr.ed05;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnonyMain {

	public static void main(String[] args) {
		Button button = new Button();

		// 무명 이너 클래스
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ActionEvent발생!");
			}
		});

	}

}
