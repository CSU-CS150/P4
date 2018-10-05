import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * more comments here
 * @author jess
 *
 */
public class Practical4 {
	// Class constants.
	Scanner userInput = new Scanner(System.in);
	public static final String MENU_OPTION_ONE = "(1) Perform String shortening.";
	public static final String MENU_OPTION_TWO = "(2) Perform run length encoding with data from a file.";
	public static final String MENU_OPTION_THREE = "(3) Perform run length encoding by entering a String in the console.";
	public static final String MENU_INSTRUCTION = "Choose 1, 2, 3 or exit: ";
	public static final String USER_ERROR_MESSAGE = "The value 1, 2, or 3 was not entered.";
	public static final String STRING_INSTRUCTION = "Enter a String: ";
	public static final String CHAR_INSTRUCTION = "Enter characters to remove (default: aeiou): ";

	public static final String VOWELS = "aeiou";
	/**
	 * mainMenu() more comments here
	 *
	 *
	 */
	public void mainMenu() {

		printMenuOptions();
		int usersChoice = getUsersMenuChoice();
		
		// Student TODO
		if (usersChoice == 1) {
			System.out.print(STRING_INSTRUCTION);
			String s1 = getStringFromUser();
			System.out.print(CHAR_INSTRUCTION);
			String s2 = getStringFromUser();
			String shortString;

			if(s2.isEmpty()) {
				shortString = stringShortener(s1);
			} else {
			  shortString = stringShortener(s1, s2);
			}
			System.out.println(shortString);
		}
		else if (usersChoice == 2) {
			String fileName = getFileNameFromUser();
			runLengthEncodingWithFileData(fileName);
		}
		else if (usersChoice == 3) {
			System.out.print(STRING_INSTRUCTION);
			String s = getStringFromUser();
			runLengthEncodingWithClientInput(s);
		}
		else if (usersChoice == 0) {
			return; // exit the menu
		}
		else {
			System.out.println(USER_ERROR_MESSAGE);
		}
		System.out.println();
		mainMenu();
		// end Student TODO
	}


	// Student TODO - Lab 14
	/*public String stringShortener(String stringToCheck, String charsToRemove) {
		String shortenedString = "";
		boolean removeThis = false;

		for (int i = 0; i < stringToCheck.length(); i++) {
			removeThis = false;
			for (int j = 0; j < charsToRemove.length(); j++) {
				removeThis |= stringToCheck.charAt(i) == charsToRemove.charAt(j); // expend for student version
			}
			if(!removeThis) shortenedString += stringToCheck.charAt(i);
		}

		return shortenedString;
	}*/
	// end Student TODO - Lab 14

	/**
	 * stringShortener() Remove all characters listed in charsToRemove from stringToCheck. 
	 * Should we remove ignoring case?
	 * *ignores case
	 * * does not remove if it is the 'start' of a word after a space. ie
	 * Y cn b a gd prgrmmr, if y cn rd ths.
	 * 
	 * @param stringToCheck
	 * @return
	 */


	public String stringShortener(String stringToCheck) {
		return stringShortener(stringToCheck, VOWELS);
	}

	// Student TODO - Lab 14 (or above this?)
	public String stringShortener(String stringToCheck, String charsToRemove) {
		if(stringToCheck.isEmpty()) { return ""; }

		String shortenedString = "" + stringToCheck.charAt(0);
		char previous = stringToCheck.charAt(0);

		for (int i = 1; i < stringToCheck.length(); i++) {
			char tmp =  stringToCheck.charAt(i);

			if(Character.isWhitespace(previous)  || !hasCharacter(tmp, charsToRemove)) {
				shortenedString += tmp;
			}
			previous = tmp;
		}

		return shortenedString;
	}

	public boolean hasCharacter(char x, String group) {
		return group.toLowerCase().contains(String.valueOf(Character.toLowerCase(x)));
	}
	// end Student TODO - Lab 14




	// currently encoding an "image" of an unfinished apple
	/**
	 * runLengthEncoding()
	 * 
	 * @param s
	 * @return
	 */
	public String runLengthEncoding(String str) {
		String rtn = "";
		int counter = 0;
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i-1) == str.charAt(i)) {
				counter++;
			}else {
				rtn += String.valueOf(counter+1)+ str.charAt(i-1);
				counter = 0;
			}
		}
		rtn +=  String.valueOf(counter+1) + str.charAt(str.length()-1);
		return rtn;
	}

	public String expand(char x, int count) {
		String rtn = "";
		for(int i = 0; i < count; i++) {
			rtn += x;
		}
		return rtn;
	}

	public String runLengthDecoding(String s) {
		// decode Strings such as 3B2W2B --> BBBWWBB
		String rtn = "";
		String count = "";
		for(int i = 0; i< s.length(); i++) {
			char tmp = s.charAt(i);
			if ( count.isEmpty() || Character.isDigit(tmp)) {  // have to do this for nubmers > 9
				if(Character.isDigit(tmp)) count += tmp;
				else rtn += tmp;  // to catch the single letter cases - not sure if this is needed
			} else {  // found a letter
				int amount = Integer.parseInt(count);
				rtn += expand(tmp, amount);
				count = ""; // reset it
			}
		}
		return rtn;
	}




	
	// DO NOT MODIFY METHODS BELOW THIS LINE ----------------------------------
	/**
	 * printMenuOptions() Printing the menu is separate from the logic of menu().
	 *
	 */
	public void printMenuOptions() {
		
		System.out.println();
		System.out.println(MENU_OPTION_ONE);
		System.out.println(MENU_OPTION_TWO);
		System.out.println(MENU_OPTION_THREE);
		System.out.print(MENU_INSTRUCTION);
		
	}
	
	/**
	 * getUserInput() Uses a class Scanner to get input from the console.
	 * 
	 * @return An integer; to menu().
	 */
	public int getUsersMenuChoice() {
		String line = userInput.nextLine();
		if(line.toLowerCase().contains("x")) { return 0 ; }
		// check to see if the string is a digit - this is called a regular expression - or 'string magic'
		if(line.matches( "\\d+")) { return Integer.parseInt(line); }
		else { return -1; } // unknown sequence
	}
	
	/**
	 * getFilNameFromUser() Uses a class Scanner to get 1 line of user input 
	 * from the console.
	 * 
	 * @return A String; to menu().
	 */
	public String getFileNameFromUser() {
		System.out.print("Enter file name (black_white_pseudo_image.txt): ");
		String input =  userInput.nextLine();
		if(input.isEmpty()) return "black_white_pseudo_image.txt";
		return input;
	}
	
	/**
	 * getStringFromUser() Uses a class Scanner to get 1 line user input 
	 * from the console.
	 * @return
	 */
	public String getStringFromUser() {
		return userInput.nextLine();
	}

	/**
	 * Prints out the test cases for runLengthEncoding with the client entering input
	 * @param line a line to encode and decode
	 */
	public void runLengthEncodingWithClientInput(String line) {

		String encoded = runLengthEncoding(line);
		String decoded = runLengthDecoding(encoded);

		System.out.println("Encoding line...");
		System.out.println(encoded);
		System.out.println();
		System.out.println("Decoding line...");
		System.out.println(decoded);

	}
	/**
	 * runLengthEncodingWithFileData() Reads a file line by line, and calls
	 * runLengthEncoding() with each line until the end of the file is reached. 
	 * 
	 * @param fileName A String; from menu().
	 */
	public void runLengthEncodingWithFileData(String fileName) {
		try {
			Scanner fileReader = new Scanner(new File(fileName));
			ArrayList<String> encoded = new ArrayList<>();
			while (fileReader.hasNextLine()) {
				encoded.add(runLengthEncoding(fileReader.nextLine()));
			}
			fileReader.close();

			System.out.println();
			System.out.println("Encoding file... ");
			for(String line : encoded) {
				System.out.println(line);
			}
			System.out.println();
			System.out.println("Decoded file... ");
			for(String line : encoded) {
				System.out.println(runLengthDecoding(line));
			}
		} catch (Exception e) {
			System.out.println("Program error when reading file. Check name and location");
			//e.printStackTrace();
		}
	}

	/**
	 * Cleans up the scanner object and memory
	 */
	public void clean() {
		userInput.close();
	}
	
	public static void main(String[] args) {
		Practical4 p4 = new Practical4();

		
		//String s = "You can be a good programmer, if you can read this.";

	//	System.out.println(p4.stringShortener(s));
//		System.out.println();
//		System.out.println(p4.runLengthDecoding("10A1T1G1C3G"));

		p4.mainMenu();
		p4.clean();

	} // end main()

} // end class Practical4