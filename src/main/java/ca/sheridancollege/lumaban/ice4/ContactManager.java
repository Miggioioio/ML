/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.lumaban.ice4;

/**
 *
 * @author miglu
 */
public class ContactManager {
    private Contact[] contactList;

    public ContactManager() {
        contactList = new Contact[2];  // Adjust the size as needed
    }    /*
	Locate a Contact record that matches the email address provided.
	Returns the Contact record if found, null if not found.
    */
    public Contact findContact(String emailAddress) {
        for (Contact contact : contactList) {
                if (contact.getEmailAddress().equals(emailAddress)) {
                return contact; 
            }
        }
        return null;
    }
    /*
	 Removes all contacts
    */
    public void clearContacts() {
        // Reset the contactList to an empty array
        contactList = new Contact[0];
    }

    public Contact[] getContactList() {
        return contactList;
    }
/*This is a test change */
}
