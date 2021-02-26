package com.arisoft.addressbook.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class AddressBookTest {
    AddressBook addressBook;

    BuddyInfo buddyInfo1;
    static final String BUDDY_INFO_1_NAME = "Bob";
    static final String BUDDY_INFO_1_NUMBER = "123-4567";
    static final String BUDDY_INFO_1_ADDRESS = "Test Address 1";

    BuddyInfo buddyInfo2;
    static final String BUDDY_INFO_2_NAME = "Joe";
    static final String BUDDY_INFO_2_NUMBER = "111-2222";
    static final String BUDDY_INFO_2_ADDRESS = "Test Address 2";

    @Before
    public void setUp() {
        addressBook = new AddressBook();
        buddyInfo1 = new BuddyInfo(BUDDY_INFO_1_NAME, BUDDY_INFO_1_NUMBER, BUDDY_INFO_1_ADDRESS);
        buddyInfo2 = new BuddyInfo(BUDDY_INFO_2_NAME, BUDDY_INFO_2_NUMBER, BUDDY_INFO_2_ADDRESS);

        //Enforce address book being empty as a precondition for all tests for this class
        assertTrue(addressBook.getBuddyInfos().isEmpty());
    }

    @Test
    public void addBuddy() {
        //Add one element to the address book
        addressBook.addBuddy(buddyInfo1);
        assertEquals(1, addressBook.getBuddyInfos().size());
        assertTrue(addressBook.getBuddyInfos().contains(buddyInfo1));

        //Add one more element to the address book
        addressBook.addBuddy(buddyInfo2);
        assertEquals(2, addressBook.getBuddyInfos().size());
        assertTrue(addressBook.getBuddyInfos().contains(buddyInfo1));
        assertTrue(addressBook.getBuddyInfos().contains(buddyInfo2));
    }

    @Test
    public void removeBuddy() {
        //Populate Address Book with two elements
        addressBook.addBuddy(buddyInfo1);
        addressBook.addBuddy(buddyInfo2);

        //Remove one element from Address Book
        addressBook.removeBuddy(buddyInfo1);
        assertEquals(1, addressBook.getBuddyInfos().size());
        assertFalse(addressBook.getBuddyInfos().contains(buddyInfo1));
        assertTrue(addressBook.getBuddyInfos().contains(buddyInfo2));

        //Remove another element from Address Book
        addressBook.removeBuddy(buddyInfo2);
        assertTrue(addressBook.getBuddyInfos().isEmpty());
        assertFalse(addressBook.getBuddyInfos().contains(buddyInfo1));
        assertFalse(addressBook.getBuddyInfos().contains(buddyInfo2));
    }

    @Test
    public void getBuddyList() {
        //Populate Address Book with two elements
        addressBook.addBuddy(buddyInfo1);
        addressBook.addBuddy(buddyInfo2);

        //Check that the two elements can be retrieved with getter
        assertEquals(2, addressBook.getBuddyInfos().size());
        assertTrue(addressBook.getBuddyInfos().contains(buddyInfo1));
        assertTrue(addressBook.getBuddyInfos().contains(buddyInfo2));
    }

    @Test
    public void testToString() {
        //Print Empty Address Book
        String expected = "Address Book is empty.";
        assertEquals(expected, addressBook.toString());

        //Populate Address Book with two elements
        addressBook.addBuddy(buddyInfo1);
        addressBook.addBuddy(buddyInfo2);
        expected = "Address Book:\n" +
                "Index: 0, Name: " + BUDDY_INFO_1_NAME + ", Phone Number: " +
                BUDDY_INFO_1_NUMBER + ", Address: " + BUDDY_INFO_1_ADDRESS + "\n" +
                "Index: 1, Name: " + BUDDY_INFO_2_NAME + ", Phone Number: " +
                BUDDY_INFO_2_NUMBER + ", Address: " + BUDDY_INFO_2_ADDRESS + "\n";

        //Print Address Book
        assertEquals(expected, addressBook.toString());
    }

}