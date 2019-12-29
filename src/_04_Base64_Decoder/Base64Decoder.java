package _04_Base64_Decoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text.
	 * Each number 0-63 is mapped to a character. 
	 * NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE ENCODING!
	 * Since the numbers 0 through 63 can be represented using 6 bits, 
	 * every four (4) characters will represent twenty four (24) bits of data.
	 * 4 * 6 = 24
	 * 
	 * For this exercise, we won't worry about what happens if the total bits being converted
	 * do not divide evenly by 24.
	 * 
	 * If one char is 8 bits, is this an efficient way of storing binary data?
	 * (hint: no)
	 * 
	 * It is, however, useful for things such as storing media data inside an HTML file (for web development),
	 * so that way a web site does not have to look for an image, sound, library, or whatever in a separate location.
	 * 
	 * View this link for a full description of Base64 encoding
	 * https://en.wikipedia.org/wiki/Base64
	 */
	
	
	final static char[] base64Chars = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
		'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
		'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
	};
	
	//1. Complete this method so that it returns the the element in
	//   the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c){
		for(int i = 0; i < base64Chars.length; i++) {
			if(base64Chars[i] == c) {
				return (byte) i;
			}
		}
		return 0;
	}
	
	//2. Complete this method so that it will take in a string that is 4 
	//   characters long and return an array of 3 bytes (24 bits). The byte 
	//   array should be the binary value of the encoded characters.
	public static byte[] convert4CharsTo24Bits(String s){
		byte[] b = new byte[3];
		/*System.out.println(s.charAt(0));
		System.out.println(toBinary(new byte[] {(byte) (convertBase64Char(s.charAt(0)) << 2)}));
		System.out.println(s.charAt(1));
		System.out.println(toBinary(new byte[] {(byte) ((convertBase64Char(s.charAt(1)) << 30) >>> 30)}));
		*/
		b[0] = (byte) ((convertBase64Char(s.charAt(0)) << 2) + (convertBase64Char(s.charAt(1)) >> 4));
		
		b[1] = (byte) ((convertBase64Char(s.charAt(1)) << 4) + (convertBase64Char(s.charAt(2)) >> 2));
		
		b[2] = (byte) ((convertBase64Char(s.charAt(2)) << 6) + (convertBase64Char(s.charAt(3))));
		for(byte b2: b) {
			System.out.println(toBinary(new byte[] {b2}));
		}
		
		return b;
	}
	
	
	//3. Complete this method so that it takes in a string of any length
	//   and returns the full byte array of the decoded base64 characters.
	public static byte[] base64StringToByteArray(String file) {
		ArrayList<String> strings = new ArrayList<>();
		String using = "";
		for(int i = 0; i < file.length(); i++) {
			using += file.charAt(i);
			if(i % 4 == 3) {
				strings.add(using);
				using = "";
			}
		}
		byte[][] bytess = new byte[strings.size()][3];
		for(int i = 0; i < strings.size(); i++) {
			bytess[i][0] = convert4CharsTo24Bits(strings.get(i))[0];
			bytess[i][1] = convert4CharsTo24Bits(strings.get(i))[1];
			bytess[i][2] = convert4CharsTo24Bits(strings.get(i))[2];
			
		}
		byte[] done = new byte[bytess.length * 3];
		for(int i = 0; i < bytess.length; i++) {
			done[i*3] = bytess[i][0];
			done[i*3 + 1] = bytess[i][1];
			done[i*3 + 2] = bytess[i][2];
			
		}
		return done;
	}
	
	public static String toBinary( byte[] bytes )
	{
	    StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
	    for( int i = 0; i < Byte.SIZE * bytes.length; i++ )
	        sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
	    return sb.toString();
	}
}
