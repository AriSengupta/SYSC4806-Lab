package com.arisoft.addressbook.model;

import com.arisoft.addressbook.model.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuddyInfoTest {

    static final String BUDDY_INFO_NAME = "Bob";
    static final String BUDDY_INFO_NUMBER = "123-4567";
    static final String BUDDY_INFO_ADDRESS = "Test Address 1";
    static final String BUDDY_INFO_NEW_NAME = "Joe";
    static final String BUDDY_INFO_NEW_NUMBER = "111-2222";
    static final String BUDDY_INFO_NEW_ADDRESS = "Test Address 1";
    BuddyInfo buddyInfo;

    @Before
    public void setUp() {
        buddyInfo = new BuddyInfo(BUDDY_INFO_NAME, BUDDY_INFO_NUMBER, BUDDY_INFO_ADDRESS);
    }

    @Test
    public void getName() {
        assertEquals(BUDDY_INFO_NAME, buddyInfo.getName());
    }

    @Test
    public void setName() {
        buddyInfo.setName(BUDDY_INFO_NEW_NAME);
        assertEquals(BUDDY_INFO_NEW_NAME, buddyInfo.getName());
    }

    @Test
    public void getPhoneNumber() {
        assertEquals(BUDDY_INFO_NUMBER, buddyInfo.getPhoneNumber());
    }

    @Test
    public void setPhoneNumber() {
        buddyInfo.setPhoneNumber(BUDDY_INFO_NEW_NUMBER);
        assertEquals(BUDDY_INFO_NEW_NUMBER, buddyInfo.getPhoneNumber());
    }

    @Test
    public void getAddress() {
        assertEquals(BUDDY_INFO_ADDRESS, buddyInfo.getAddress());
    }

    @Test
    public void setAddress() {
        buddyInfo.setAddress(BUDDY_INFO_NEW_ADDRESS);
        assertEquals(BUDDY_INFO_NEW_ADDRESS, buddyInfo.getAddress());
    }

    @Test
    public void testToString() {
        String expected = "Name: " + BUDDY_INFO_NAME +
                ", Phone Number: " + BUDDY_INFO_NUMBER +
                ", Address: " + BUDDY_INFO_ADDRESS;
        //Print Address Book
        assertEquals(expected, buddyInfo.toString());
    }
}