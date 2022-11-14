package com.java.application;

import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ImageOperation {

	public static void operate(int key) {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(null);
		File file = fileChooser.getSelectedFile();

		// file input stream

		try {
			FileInputStream fis = new FileInputStream(file);
			byte[] data = new byte[fis.available()]; // byte array passing
			fis.read(data);

			// encrypting byte(xor fn)
			int i = 0; // encrypt all value

			for (byte b : data) {
				System.out.println(b);
				data[i] = (byte) (b ^ key);
				i++;
			}
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(data);
			fos.close();
			fis.close();
			JOptionPane.showMessageDialog(null, "Done");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void main(String[] args) {

		System.out.println("testing operation");

		JFrame f = new JFrame();
		f.setTitle("Image Operation");
		f.setSize(400, 400);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font font = new Font("Roboto", Font.BOLD, 25);

		// creating button

		JButton button = new JButton();
		button.setText("Open Image");
		button.setFont(font);

		// creating textfields
		JTextField textField = new JTextField(10);
		textField.setFont(font);
		// which clicks action listener(interface)--MAKE CHILD CLASS OBJECT
		// using lamda function..(replace anaonymous class,,,implement functional
		// interface )

		button.addActionListener(e -> {
			System.out.println("button clicked");

			String text = textField.getText();
			int temp = Integer.parseInt(text);
			operate(temp);

		});

		f.setLayout(new FlowLayout());

		f.add(button);
		f.add(textField);

		f.setVisible(true);
	}
}
