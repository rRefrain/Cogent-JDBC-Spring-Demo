package com.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class intended to have a BufferedReader open until main exits
 * 
 * @author michaelmiranda
 * @date Feb 1 2023
 */
public class CustomReader {
	
	/** CustomReader to use */
	private static BufferedReader reader = null;
	
	/** 
	 * Class to check if reader is null, 
	 * If it is, create a new reader
	 */
	public static void activate() {
		if (reader == null) {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	
	/**
	 * Class to read a user-inputed String
	 * 
	 * @param prompt the Prompt to read before asking user-input
	 * @return user input in a String format
	 */
	public static String read(String prompt) {
		activate();
		try {
			System.out.println(prompt);
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	/**
	 * Class to read a user-inputed float
	 * Will keep looping until the user inputs a valid float 
	 * 
	 * @see read(String)
	 * @param prompt the Prompt to read before asking user-input
	 * @return user input in a float
	 */
	public static float readFloat(String prompt) {
		activate();
		while (true) {
			try {
				return Float.parseFloat(read(prompt));
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("Enter a valid Float!");
			}
		}
	}
	
	/**
	 * Class to read a user-inputed int
	 * Will keep looping until the user inputs a valid int 
	 * 
	 * @see read(String)
	 * @param prompt the Prompt to read before asking user-input
	 * @return user input in a int
	 */
	public static int readInt(String prompt) {
		activate();
		while (true) {
			try {
				return Integer.parseInt(read(prompt));
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("Enter a valid Int!");
			}
		}
	}
	
	public static int[][] readIntArray(String prompt1, String prompt2,
			String arrayPrompt, int size) {
		int[][] newIntArray = new int[size][2];
		System.out.println(arrayPrompt);

		for(int i = 0; i < size; i++) {
			newIntArray[i][0] = readInt(prompt1);
			newIntArray[i][1] = readInt(prompt2);
		}

		return newIntArray;
	}

	/**
	 * Class to attempt to close reader
	 * then set it to null
	 */
	public static void close() {
		try {
			if(reader != null) {
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			reader = null;
		}
	}

	
}
