/* Here is the ListNode class that behaves
as a LinkedList. Each node stored contains
a firstname, last name, phone number, address,
and city. Next, represents the next node in
the LinkedList.
 */
public class ListNode {
    String firstName;
    String lastName;
    String phoneNumber;
    String address;
    String city;
    ListNode next;

    public ListNode(String firstName, String lastName, String phoneNumber, String address, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.next = null;
    } // end of ListNode method
} // end of ListNode class
