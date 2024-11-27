/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import ca.sheridancollege.lumaban.ice4.Contact;
import ca.sheridancollege.lumaban.ice4.ContactManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author miglu
 */
public class ContactManagerTest {
    private ContactManager contactManager;

    public ContactManagerTest() {   
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        // Initialize ContactManager before each test
    contactManager = new ContactManager();
        // Manually add two contacts to the contact list.
        Contact contact1 = new Contact();
        contact1.setFirstName("John");
        contact1.setLastName("Doe");
        contact1.setEmailAddress("john.doe@example.com");
        contactManager.getContactList()[0] = contact1;

        Contact contact2 = new Contact();
        contact2.setFirstName("Miguel");
        contact2.setLastName("Lumaban");
        contact2.setEmailAddress("lumaban@sheridancollege.com");
        contactManager.getContactList()[1] = contact2;
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    //testing to see if the method works as intended expected true
    @Test
    public void testFindContact() {
        Contact result = contactManager.findContact("lumaban@sheridancollege.com");
        assertNotNull(result, "Contact should be found");
        assertEquals("Miguel", result.getFirstName(), "First name should be Miguel");
        assertEquals("Lumaban", result.getLastName(), "Last name should be Lumaban");
        assertEquals("lumaban@sheridancollege.com", result.getEmailAddress(), "Email should match");
    }
    //testing to see if the method returns null when there is an entry that doesn't exist
    @Test
    public void testFindContactNotFound() {
        Contact result = contactManager.findContact("notfound@example.com");
        assertNull(result, "Contact should not be found");
    }
    //testing to see if it can still find a contact in an empty list
    @Test
    public void testFindContactWithEmptyList() {
        contactManager.clearContacts(); 
        Contact result = contactManager.findContact("lumaban@sheridancollege.com");
        assertNull(result, "Contact list is empty, so no contact should be found");
    }
    //testing to see if it finds a contact with a partial match
    @Test
    public void testFindContactPartialMatch() {
        Contact result = contactManager.findContact("lumaban");
        assertNull(result, "no contact should be found");
    }
    //testing to see if the method works with a null parameter
    @Test
    public void testFindContactWithNullEmail() {
        Contact result = contactManager.findContact(null);
        assertNull(result, "Contact should not be found when email is null");
    }
    //testing to see if it works with a small typo
    @Test
    public void testFindContactWithTypoInEmail() {
        Contact result = contactManager.findContact("lumaban@sheridancllege.com"); // typo in domain name
        assertNull(result, "Contact should not be found when email has a typo");
    }
    //testing to see if it works with case sensitivity
    @Test
    public void testFindContactCaseSensitivity() {
        Contact result = contactManager.findContact("LUMABAN@sheridancollege.com"); // uppercase domain
        assertNull(result, "Contact should not be found when email isn't case sensitive");
    }
    //testing to see if it works with an invalid emailformat
    @Test
    public void testFindContactInvalidEmailFormat() {
        Contact result = contactManager.findContact("lumaban@.com"); // invalid email format
        assertNull(result, "Contact should not be found when email format is invalid");
    }
    private int myProperty;
}
