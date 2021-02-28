package com.arisoft.addressbook.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class represents an Address Book that holds BuddyInfo instances
 *
 * @author Aritra Sengupta
 */

@Entity
public class AddressBook {

    private List<BuddyInfo> buddyInfos;
    private Long addressBookId;

    public AddressBook() {
        this.buddyInfos = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getAddressBookId() {
        return this.addressBookId;
    }

    public void setAddressBookId(Long id) {
        this.addressBookId = id;
    }

    public void addBuddy(BuddyInfo buddyInfo) {
        buddyInfo.setAddressBook(this);
        this.buddyInfos.add(buddyInfo);
    }

    public void removeBuddy(BuddyInfo buddyInfo) {
        this.buddyInfos.remove(buddyInfo);
        buddyInfo.setAddressBook(null);
    }

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "addressBook")
    public List<BuddyInfo> getBuddyInfos() {
        return this.buddyInfos;
    }

    public void setBuddyInfos(List<BuddyInfo> BuddyInfos) {
        this.buddyInfos = BuddyInfos;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (buddyInfos.isEmpty()) {
            sb.append("Address Book is empty.");
        } else {
            sb.append("Address Book:").append("\n");
            System.out.println(addressBookId);
            if(addressBookId != null){
                sb.append("Address Book Id: ").append(addressBookId).append("\n");
            }
            int i = 0;
            for (BuddyInfo b : buddyInfos) {
                sb.append("Index: ").append(i).append(", ");
                sb.append(b.toString()).append("\n");
                i++;
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBook that = (AddressBook) o;
        if (!Objects.equals(buddyInfos, that.buddyInfos)) return false;
        return Objects.equals(addressBookId, that.addressBookId);
    }

    public static void main(String[] args) {
//        BuddyInfo buddyInfo1 = new BuddyInfo("Bob", "123-4567");
//        BuddyInfo buddyInfo2 = new BuddyInfo("Joe", "111-2222");
//        AddressBook addressBook = new AddressBook();
//
//        //Add one BuddyInfo
//        addressBook.addBuddy(buddyInfo1);
//
//        //Add another BuddyInfo
//        addressBook.addBuddy(buddyInfo2);
//
//        //Print the two BuddyInfo
//        System.out.println(addressBook);
//
//        //Remove one BuddyInfo
//        addressBook.removeBuddy(buddyInfo1);
//
//        //Print remaining BuddyInfo
//        System.out.println(addressBook);
//
//        //Remove remaining BuddyInfo
//        addressBook.removeBuddy(buddyInfo2);
//
//        //Print empty address book
//        System.out.println(addressBook);
    }
}
