import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * This is the main driver class for Practical 4. All input and output is handle in this file,
 * while the students works in Practical4. Students do not need to modify this file, but
 * can look through it to get an idea.
 *
 * @author Albert Lionelle <br>
 *         lionelle@colostate.edu <br>
 *         Computer Science Department <br>
 *         Colorado State University
 * @version 2019010
 */
public class Main {
    private Practical4 p4 = new Practical4();
    private Scanner userInput = new Scanner(System.in);
    private static final String MENU_OPTION_ONE = "(1) Perform String shortening.";
    private static final String MENU_OPTION_TWO = "(2) Perform run length encoding with data from a file.";
    private static final String MENU_OPTION_THREE = "(3) Perform run length encoding by entering a String in the console.";
    private static final String MENU_INSTRUCTION = "Choose 1, 2, 3 or exit: ";
    private static final String USER_ERROR_MESSAGE = "The value 1, 2, or 3 was not entered.";
    private static final String STRING_INSTRUCTION = "Enter a String: ";
    private static final String CHAR_INSTRUCTION = "Enter characters to remove (default: " + Practical4.VOWELS + "): ";


    /**
     * printMenuOptions() Printing the menu is separate from the logic of menu().
     *
     */
    private void printMenuOptions() {
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
    private int getUsersMenuChoice() {
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
    private String getFileNameFromUser() {
        System.out.print("Enter file name (black_white_pseudo_image.txt): ");
        String input =  userInput.nextLine().trim();
        if(input.isEmpty()) return "black_white_pseudo_image.txt";
        return input;
    }

    /**
     * getStringFromUser() Uses a class Scanner to get 1 line user input
     * from the console.
     */
    private String getStringFromUser() {
        return userInput.nextLine();
    }

    /**
     * Prints out the test cases for runLengthEncoding with the client entering input
     * @param line a line to encode and decode
     */
    private void runLengthEncodingWithClientInput(String line) {

        String encoded = p4.runLengthEncoding(line);
        String decoded = p4.runLengthDecoding(encoded);

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
    private void runLengthEncodingWithFileData(String fileName) {
        try {
            Scanner fileReader = new Scanner(new File(fileName));
            ArrayList<String> encoded = new ArrayList<>();
            while (fileReader.hasNextLine()) {
                encoded.add(p4.runLengthEncoding(fileReader.nextLine()));
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
                System.out.println(p4.runLengthDecoding(line));
            }
        } catch (Exception e) {
            System.out.println("Program error when reading file. Check name and location");
            //e.printStackTrace();
        }
    }

    /**
     * Cleans up the scanner object and memory.
     */
    private void clean() {
        userInput.close();
    }



    /**
     * mainMenu() This method handles five possible situations of user input:
     * the user enters 0, 1, 2, 3, or something else. 0, 1, 2, and 3 are considered
     * valid input. The options are as follows:
     * <ul>
     *     <li>
     *         usersChoice == 1 - call Practical 4 stringShortener if they
     *         then hit an empty return asking for the default, or stringShortener(String, String)
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


        if (usersChoice == 1) {
            System.out.print(STRING_INSTRUCTION);
            String s1 = getStringFromUser();
            System.out.print(CHAR_INSTRUCTION);
            String s2 = getStringFromUser().trim();
            String shortString;

            if(s2.isEmpty()) {
                shortString = p4.stringShortener(s1);
            }
            else {
                shortString = p4.stringShortener(s1, s2);
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

    }

    public static void main(String[] args) {
        Main main = new Main();
        main.p4.testMethod();
        main.mainMenu();
        main.clean();
    }


}
