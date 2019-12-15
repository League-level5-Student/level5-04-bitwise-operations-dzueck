package _01_Bit_Shifting;

public class BitShifter {
	public static void main(String[] args) {
		// 1. Jot down the value of num in binary.
		int num = 4; // 100
		int numShifted = num << 1;
		numShifted = numShifted << 1;
		numShifted = numShifted << 1;
		
		// 2. Print the value of numShifted, and convert that value to binary.
		System.out.println(numShifted + ": " + binaryConverter(numShifted));
		
		// 3. Compare the two binary values. Can you figure out what the << operator is for?
		
		// 4. Try shifting num 3 places.
		
		// FYI: Binary values can be shifted to the right as well using the >> operator.	
	}
	private static String binaryConverter(int n) {
		int tempN = 1;
		int number = 0;
		String binary = "";
		if(n == 0) {
			return "0";
		}
		while(n >= tempN) {
			tempN *= 2;
			number ++;
		}
		tempN /= 2;
		for(int i = 0; i < number; i++) {
			if(n-tempN >= 0) {
				binary += "1";
				n -= tempN;
			}
			else {
				binary += "0";
			}
			tempN  /= 2;
		}
		return binary;
		
	}
}
