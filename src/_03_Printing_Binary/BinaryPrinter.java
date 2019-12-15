package _03_Printing_Binary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class BinaryPrinter {
	//Complete the methods below so they print the passed in parameter in binary.
	//Use bit shifting and bit masking to print the binary numbers.
	//Do not use the Integer.toBinaryString method!
	//Don't be afraid to use the methods that are already complete to finish the others.
	//Create a main method to test your methods.
	
	public static void main(String[] args) {
		printShortBinary((short) 4);
		printByteBinary((byte) 4);
		printIntBinary(4);

		printLongBinary((long) 4);
	}
	
	public static void printByteBinary(byte b) {
		printIntBinary(Byte.toUnsignedInt(b));
	}
	
	public static void printShortBinary(short s) {
		printIntBinary(Short.toUnsignedInt(s));
	}
	
	public static void printIntBinary(int n) {
		printLongBinary(Integer.toUnsignedLong(n));
	}
	
	public static void printLongBinary(long l) {
		String s = "";
		while(l != 0) {
			if(l % 2 == 0) {
				s += "0";
			}
			else {
				s += "1";
			}
			l = l >> 1;
		}
		char[] s2 = s.toCharArray();
		ArrayList<Character> c1 = new ArrayList<>();
		for(char c: s2) {
			c1.add(c);
		}
		Collections.reverse(c1);
		ListIterator li = c1.listIterator(); 
        while (li.hasNext()) 
            System.out.print(li.next());
	}
}
