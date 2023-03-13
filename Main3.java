import java.util.Scanner;
/* Zachery Loreen
1/30/2023 CS 145
Here is the main program which runs the PhoneBookManger methods
based on the input of the user. I don't have much to say
about this method, as it's pretty straight forward.
 */
public class Main3 { // Main class
    public static void main(String[] args) { // start of main method
        Scanner input = new Scanner(System.in);
        PhoneBookManager phoneBook = new PhoneBookManager();
        int choice = -1;

        while (!(choice == 0)) { // start of while loop
            System.out.println("Phonebook");
            System.out.println("1 - Add contact");
            System.out.println("2 - Delete contact");
            System.out.println("3 - View phonebook contacts");
            System.out.println("4 - Search by name");
            System.out.println("5 - Search by address");
            System.out.println("6 - Search by phone number");
            System.out.println("7 - Edit name");
            System.out.println("8 - Edit address");
            System.out.println("9 - Edit phone number");
            System.out.println("0 - Quit");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please" +
                        " enter a number between 0-9");
                continue;
            } // end of try catch statement
            if (choice == 1) { // start of else if statement
                phoneBook.addContact();
            } else if (choice == 2) {
                phoneBook.deleteContact();
            } else if (choice == 3) {
                phoneBook.viewContact();
            } else if (choice == 4) {
                phoneBook.searchByName();
            } else if (choice == 5) {
                phoneBook.searchByAddress();
            } else if (choice == 6) {
                phoneBook.searchByPhoneNumber();
            } else if (choice == 7) {
                phoneBook.editName();
            } else if (choice == 8) {
                phoneBook.editAddress();
            } else if (choice == 9) {
                phoneBook.editPhoneNumber();
            } else if (choice == 0) {
                System.out.println("Exiting the program.");
            } // end of if else statement

        } // end of while loop
    } // end of main method
} // end of main class
