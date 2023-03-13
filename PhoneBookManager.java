import java.util.*;
/* Zachery Loreen
1/30/2023 CS 145
 The PhoneBookManager class is called upon by the main class and
 will run one of the methods below based on the users input.
This class can construct, manipulate, and access a LinkedList
depending on what the user wants to do. It will allow the user
to store contacts and their info in a LinkedList as nodes. View all
the contacts in the LinkedList, search for individual contacts
using their first / last name, address or phone number by looking
at examining each node. The user can also edit the contacts info after
they have been added.
 */

public class PhoneBookManager {
     ListNode head;

    public PhoneBookManager() { // constructor method
        head = null;
    } // end of PhoneBookManger constructor

    /* The addContact manipulator method receives inputs
    by the users regarding the contacts desired first name,
    last name, phone number, address and city. It then creates
    a new node that is stored in the LinkedList.
    Then, it asks the user to input where this new node should be stored
    in the LinkedList, either the back middle or front. */
    public void addContact() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        System.out.print("Enter phone number (xxx-xxx-xxxx): ");
        String phoneNumber = input.nextLine();
        System.out.print("Enter address: ");
        String address = input.nextLine();
        System.out.print("Enter city: ");
        String city = input.nextLine();
        System.out.print("Where do you want to add the contact? (front/middle/back): ");
        String addLocation = input.nextLine();
        ListNode newNode = new ListNode(firstName, lastName, phoneNumber, address, city);
        if (head == null) {
            head = newNode;
        } else if (addLocation.equals("front")) {
            newNode.next = head;
            head = newNode;
        } else if (addLocation.equals("back")) {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            } // end of while loop
            current.next = newNode;

        } else if (addLocation.equals("middle")) {
            int size = 0;
            ListNode current = head;
            while (current != null) { // counts up the size of list
                size++;
                current = current.next;
            } // end of while loop

            int middleIndex = size / 2;
            size = 0;
            current = head;
            while (size < middleIndex - 1) {
                current = current.next;
                size++;
            } // end of while loop
            newNode.next = current.next;
            current.next = newNode;
        } else {
            System.out.println("Invalid input. Contact not added.");
        } // end of if else statement

        System.out.println("Contact added successfully");
    } // end of addContact manipulator

    /* The deleteContact manipulator method receives an input of first name
and last name from the user. It also creates two variables,
current and prev in order to traverse the LinkedList.
If current is not equal to null, and if the first and last
name are not equal to the one input by the user, then a while loop
will run setting prev to current and current to the next node in the list.
If null is reached before the first and last name, no contact was found.
If the names are found and prev is equal to null, then the first contact is deleted.
If prev isn't equal to null then the current node is deleted.
 */
    public void deleteContact() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        ListNode current = head;
        ListNode prev = null;
        while (current != null && !(current.firstName.equalsIgnoreCase(firstName)
                && current.lastName.equalsIgnoreCase(lastName))) {
            prev = current;
            current = current.next;
        } // end of while loop

        if (current == null) {
            System.out.println("Contact not found");
        } else {
            if (prev == null) {
                head = head.next;
            } else {
                prev.next = current.next;
            }
            System.out.println("Contact deleted successfully");
        } // end of if else statement
    } // end of deleteContact manipulator method

    /* The viewContact accessor method checks if the current
    node is equal to null, if this is the case phonebook is empty
    If this isn't the case a while loop will run until current
    is equal to null, printing out each node that isn't null
    along the way. */
    public void viewContact() {
        ListNode current = head;

        if (current == null) {
            System.out.println("Phonebook is empty");
        } // end of if statement

        while (current != null) {
            System.out.println("Name: " + current.firstName + " " + current.lastName + " "
                    + " Phone number: " + current.phoneNumber + "  Address: " + ""
                    + current.address + "  City: " + current.city);
            current = current.next;
        } // end of while loop
    } // end of viewContact accessor method

    /* The searchByName accessor method asks the user to input
    a first and last name. Then it enters a while loop,
    and stays in the while loop until the contact
    is found or if current node is equal to null.
    The contact will be displayed if found, current is null
    then there is no contact.  */
    public void searchByName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        ListNode current = head;
        while (current != null && !(current.firstName.equalsIgnoreCase(firstName) &&
                current.lastName.equalsIgnoreCase(lastName))) {
            current = current.next;
        } // end of while loop

        if (current == null) {
            System.out.println("Contact not found");
        } else {
            System.out.println("Contact found");
            System.out.println("First name: " + current.firstName);
            System.out.println("Last name: " + current.lastName);
            System.out.println("Phone number: " + current.phoneNumber);
            System.out.println("Address: " + current.address);
            System.out.println("City: " + current.city);
        } // end of else statement
    } // end of searchByName accessor method

    /* The searchByAddress accessor method will traverse the LinkedList
        until current is either null, or the address has been found in the node.
        If current is equal to null then no contact with that address exists.
        If the address is found, then it will print out the contacts info */
    public void searchByAddress() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter address: ");
        String address = input.nextLine();
        ListNode current = head;
        while (current != null && !(current.address.equalsIgnoreCase(address))) {
            current = current.next;
        } // end of while loop

        if (current == null) {
            System.out.println("Contact not found");
        } else {
            System.out.println("Contact found");
            System.out.println("First name: " + current.firstName);
            System.out.println("Last name: " + current.lastName);
            System.out.println("Phone number: " + current.phoneNumber);
            System.out.println("Address: " + current.address);
            System.out.println("City: " + current.city);
        } // end of else statement
    } // end of searchByAddress accessor method

    /* The searchByPhoneNumber accessor method
    will traverse the LinkedList until current is either null, or
    the phone number has been found. If current is equal to null
    then no contact with that phone number exists.
    If the phone number is found, then it will print out
    the contacts info */
    public void searchByPhoneNumber() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter phone number: ");
        String phoneNumber = input.nextLine();
        ListNode current = head;
        while (current != null && !current.phoneNumber.equalsIgnoreCase(phoneNumber)) {
            current = current.next;
        } // end of while loop

        if (current == null) {
            System.out.println("Contact not found");
        } else {
            System.out.println("Contact found");
            System.out.println("First name: " + current.firstName);
            System.out.println("Last name: " + current.lastName);
            System.out.println("Phone number: " + current.phoneNumber);
            System.out.println("Address: " + current.address);
            System.out.println("City: " + current.city);
        } // end of if else statement
    } // end of searchByPhoneNumber accessor

    /* the editName method is a manipulator which
      receives first and last name input from the user.
      The while loop runs until the current node is equal to null,
      or until current is equal to first and last name.
      If current is equal to null, then there is no contact.
      If current is equal to first and last, then the current
      first and last name are updated based on the users input. */
    public void editName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        ListNode current = head;
        while (current != null && !(current.firstName.equalsIgnoreCase(firstName)
                && current.lastName.equalsIgnoreCase(lastName))) {
            current = current.next;
        } // end of while loop

        if (current == null) {
            System.out.println("Contact not found");
        } else {
            System.out.println("Current first and last name: " +
                    current.firstName + " " + current.lastName);
            System.out.print("Enter new first name: ");
            current.firstName = input.nextLine();
            System.out.print("Enter new last name: ");
            current.lastName = input.nextLine();
            System.out.println("Name edited successfully");
        } // end of if else statement
    } // end of editName manipulator

    /* the editAddress method is a manipulator which
      receives address name input from the user.
      The while loop runs until current is equal to null,
      or until current is equal to the address.
      If current is equal to null, then there is no contact.
      If current is equal to the first and last name, then the current
      address is updated based on the users input. */
    public void editAddress() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter old address: ");
        String address = input.nextLine();
        ListNode current = head;
        while (current != null && !(current.address.equalsIgnoreCase(address))) {
            current = current.next;
        } // end of while loop

        if (current == null) {
            System.out.println("Contact not found");
        } else {
            System.out.println("Old address: " + current.address);
            System.out.print("Enter new address: ");
            current.address = input.nextLine();
            System.out.println("Address edited successfully");
        } // end of if else statement
    } // end of editAddress manipulator

    /* the editPhoneNumber method is a manipulator which
     receives a phone number input from the user.
     The while loop runs until current is equal to null,
     or until current is equal to the phone number.
     If current is equal to null, then there is no contact.
     If current is equal to the phone number, then the current nodes
     phone number is updated based on the users input. */
    public void editPhoneNumber() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter old phone number (xxx-xxx-xxxx): ");
        String phoneNumber = input.nextLine();
        ListNode current = head;
        while (current != null && !(current.phoneNumber.equalsIgnoreCase(phoneNumber))) {
            current = current.next;
        } // end of while loop

        if (current == null) {
            System.out.println("Contact not found");
        } else {
            System.out.println("Old phone number: " + current.phoneNumber);
            System.out.print("Enter new phone number (xxx-xxx-xxxx): ");
            current.phoneNumber = input.nextLine();
            System.out.println("Phone number edited successfully");
        } // end of if else statement
    } // end of editPhoneNumber manipulator method
} // end of PhoneBookManager class
