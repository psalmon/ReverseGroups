import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * ReverseGroups	Calls to kReverse with string array s and int K will reverse "groups" of size k from the string S, from left to right. See ReadMe for usage and additional information. 
 * @author          Paul Salmon
 */

public class ReverseGroups {


	public static void main(String[] args) {

		runTests(args[0]);

	}//end main

	/**
	 * Runs tests by calling kReverse on each line. Test file should 
	 * adhere to the specifications provided in the ReadMe.
	 * Formatted to fit CodeEval.com standards.
	 * @param testFile is a String takes the directory of a test file.
	 * @exception FileNotFoundException if the FileReader cannot locate the file.
	 * @exception IOException when parsing the individual lines of the file.
	 * @return No return value.
	 */ 
	public static void runTests(String testFile){
		BufferedReader inputFile = null;

		try {
			inputFile = new BufferedReader(new FileReader(testFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		/**run tests from input file, line by line.
		 * get string through comma separation, and K assumed last element per line.
		 */
		try {
			String currLine = inputFile.readLine();
			while(currLine != null){
				String[] parsedLine = currLine.split(",");
				
				//Trim the last element of ';' and 'k' value.
				String lastLine = parsedLine[parsedLine.length-1];
				lastLine = lastLine.substring(0, lastLine.indexOf(";"));
				parsedLine[parsedLine.length-1] = lastLine;

				int k = Character.getNumericValue((currLine.charAt(currLine.length()-1))); //set k

				//test the line and print it
				String[] reversedString = (kReverse(parsedLine, k));

				for(int i = 0; i < reversedString.length; i++){
					System.out.print(reversedString[i]);
					if(i != reversedString.length-1) System.out.print(',');
					else System.out.println();
				}

				currLine = inputFile.readLine();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}//end runTests

	/**
	 * Builds a new String array by reversing groups of k size one at a time through
	 * calls to reverseString. After each group makes the call, it is 
	 * then appended to a new string. Leftover characters are appended and unchanged
	 * (i.e. the length is not divisible by k).
	 * @param s is a String array to reverse by groups.
	 * @param k is an int which defines the size of these groups.
	 * @return The completed String array, reversed by groups.
	 */ 
	public static String[] kReverse(String[] s, int k){
		int stop = (s.length - s.length % k) - 1; //final element. leave the remainder untouched.
		String[] reversedGroup = new String[s.length];

		for(int i = 0; i <= stop; i+=k){
			String[] group = Arrays.copyOfRange(s, i, i+k);//i+k b/c substring is not inclusive.
			group = reverseString(group);
			for(int j = 0; j < group.length; j++){
				reversedGroup[i+j] = group[j];
			}
		}

		//append untouched remainder,
		for(int i = stop+1; i < s.length; i++){
			reversedGroup[i] = s[i];
		}

		return reversedGroup;
	}//end kReverse


	/**
	 * Reverses the argument string and returns it.
	 * @param s is a String array to reverse.
	 * @return The complete reversed string array.
	 */ 
	public static String[] reverseString(String[] s){
		int j = s.length-1;

		for(int i = 0; i < j; i++){
			String temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			j--;
		}

		return s;
	}//end reverseString

}//end ReverseGroups class

