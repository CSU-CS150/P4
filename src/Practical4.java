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
 *         YOUR EMAIL  <br>
 *         Computer Science Department <br>
 *         Colorado State University
 * @version 2019010
 */
public class Practical4 {
	/** constant variable used to determine the default letters to remove **/
	public static final String VOWELS = "aeiou";


	/**
	 * This method is called from the Main before anything else is called. You should feel free to
	 */
	public void testMethod() {




	}

	/**
	 * stringShortener() Helper method for two parameter {@link #stringShortener(String, String)}.
	 * It will use the default {@link #VOWELS} constant variable for the second parameter, as often
	 * VOWELS removed from words are easy for our mind to replace.
	 * @param stringToCheck A String representing the String to check for matching characters in.
	 * @return A new String with matching characters of source String removed.
	 */
	//TODO - part of mock-up


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
	//TODO - part of mock-up

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
	//TODO - part of mock-up


	/**
	 * runLengthDecoding(String) This changes an encoded String back to the format of the
	 * source String. For example, "3B2W2B" would become "BBBWWBB".
	 *
	 * A public nonstatic method with one parameter, a String.
	 * @param s String representing the String to decode.
	 * @return A String representing the original format before encoding.
	 * @see #expand(char, int)
	 */
	//TODO - part of mock-up

	// helper methods
	/**
	 * hasCharacter(char, String) Helper method for two-parameter {@link #stringShortener(String, String)}.
	 * This method determines if one character from the source String is included in the characters
	 * of the String representing all characters to remove. If so, return true.
	 *
	 * @param x A character representing one character from the source String.
	 * @param group A String representing all characters to remove.
	 * @return A boolean.
	 */
	//TODO


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



} // end class Practical4