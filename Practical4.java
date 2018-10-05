import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <h1> Practical 4 : String Shortening and Run Length Encoding/Decoding </h1>
 *
 * This assignment focuses on String encoding and compression. Over the next couple weeks we will start talking
 * about the internet, and compression is critical in the use of internet files. Additionally,
 * the field of bioinfomatics uses strings that often repeat themselves, so this gives us
 * an opportunity to discuss biology and computer science applied to that field.
 *
 * @author YOUR NAME  <br>
 *         YOUR EMAIL <br>
 *         Computer Science Department <br>
 *         Colorado State University
 * @version 1.0
 */
public class Practical4 {
	// Class constants - DO NOT MODIFY.
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
	 * mainMenu() This method handles five possible situations of user input:
	 * the user enters 0, 1, 2, 3, or something else. 0, 1, 2, and 3 are considered
	 * valid input. The options are as follows:
	 * <ul>
	 *     <li>
	 *         usersChoice == 1 - call {@link #stringShortener(String)} if they
	 *         then hit an empty return asking for the default, or {@link #stringShortener(String, String)}
	 *         if they provide a remove sequence. Defaults are common
	 *         in console programs, and represented in the parens by inputs
	 *     </li>
	 *     <li>
	 *         usersChoice ==2 - ask for a file name by calling {@link #getFileNameFromUser()}. Then call
	 *         {@link #runLengthEncodingWithFileData(String)} with that file name. You will notice
	 *         getFileNameFromUser also has a default case already handled in the code.
	 *     </li>
	 *     <li>
	 *         usersChoice == 3 - Print the instruction and call {@link #getStringFromUser()}. Then
	 *         using that String call {@link #runLengthEncodingWithClientInput(String)}
	 *     </li>
	 *     <li>
	 *         usersChoice == 0 - return from this method thus exiting the program. You will notice
	 *         a client can also type exit, and 0 is returned - this handled for you in the {@link #getUsersMenuChoice()}
	 *         method.
	 *     </li>
	 *     <li>
	 *         Default:
	 *         Print the USER_ERROR_MESSAGE
	 *     </li>
	 *</ul>
	 * This method should also call itself, so the user may
	 * perform different operations in one program run if desired.
	 *
	 */
	public void mainMenu() {

		printMenuOptions();
		int usersChoice = getUsersMenuChoice();

		// Student TODO

		// end Student TODO
	}

	/**
	 * stringShortener() Helper method for two parameter {@link #stringShortener(String, String)}.
	 * It will use the default {@link #VOWELS} constant variable for the second parameter, as often
	 * VOWELS removed from words are easy for our mind to replace.
	 * @param stringToCheck A String representing the String to check for matching characters in.
	 * @return A new String with matching characters of source String removed.
	 */

	// Student TODO - Lab 14

	/**
	 * stringShortener(String String) Remove all characters listed in one String from another String.
	 * This method does not ignore case and does not remove a character if it is the
	 * 'start' of a word after a space.
	 * i.e.
	 * <pre>
	 * You can be a good programmer, if you can read this.
	 *
	 * Y cn b a gd prgrmmr, if y cn rd ths.
	 * </pre>
	 * @param stringToCheck A String representing the String to check for matching characters.
	 * @param charsToRemove A String representing the String of characters to remove.
	 * @return A String with characters removed.
	 * @see #hasCharacter(char, String)
	 */


	/**
	 * hasCharacter(char, String) Helper method for two-parameter {@link #stringShortener(String, String)}.
	 * This method determines if one character from the source String is included in the characters
	 * of the String representing all characters to remove. If so, return true.
	 *
	 * @param x A character representing one character from the source String.
	 * @param group A String representing all characters to remove.
	 * @return A boolean.
	 */

	// end Student TODO - Lab 14

	/**
	 * runLengthEncoding(String) This method takes sequences of the same character in a
	 * String and represents that sequence as the number of same characters in a row
	 * followed by that character. For example, "BBBWWWWWB", becomes "3B5W1B".
	 *
	 * A public nonstatic method with one String parameter.
	 *
	 * @param str A String representing the String to encode.
	 * @return A String representing the encoded version of the original String.
	 */
	// TODO

	/**
	 * expand(char, int) Helper method for {@link #runLengthDecoding(String)} This method generates a
	 * String using two parameters. One is a character and the other is an
	 * integer. For example, if the character is 'y' and the integer is 4, this
	 * method should return the String "yyyy".
	 *
	 * A public nonstatic method with two parameters, a character and an integer.
	 * @param x A character representing the character to repeat in the returned String.
	 * @param count integer representing the number of times to repeat the character.
	 * @return A String representing a sequence of characters.
	 */
	// TODO

	/**
	 * runLengthDecoding(String) This changes an encoded String back to the format of the
	 * source String. For example, "3B2W2B" would become "BBBWWBB".
	 *
	 * A public nonstatic method with one parameter, a String.
	 * @param s String representing the String to decode.
	 * @return A String representing the original format before encoding.
	 * @see #expand(char, int)
	 */
	//TODO



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
	 * Cleans up the scanner object and memory.
	 */
	public void clean() {
		userInput.close();
	}

	public static void main(String[] args) {
		Practical4 p4 = new Practical4();

		p4.mainMenu();
		p4.clean();

	}

} // end class Practical4