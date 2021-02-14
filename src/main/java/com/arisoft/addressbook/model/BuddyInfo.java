package com.arisoft.addressbook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

/**
 * This class represents a BuddyInfo object that holds a name and phone number
 *
 * @author Aritra Sengupta
 */

@Entity
public class BuddyInfo {

    private String name;
    private String phoneNumber;
    private Long buddyInfoId;
    @JsonIgnore
    private AddressBook addressBook;

    public BuddyInfo() {

    }

    public BuddyInfo(BuddyInfo buddyInfo){
        this.name = buddyInfo.name;
        this.phoneNumber = buddyInfo.phoneNumber;
        this.buddyInfoId = buddyInfo.buddyInfoId;
        this.addressBook = buddyInfo.addressBook;
    }

    public BuddyInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getBuddyInfoId() {
        return buddyInfoId;
    }

    public void setBuddyInfoId(Long id) {
        this.buddyInfoId = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JoinColumn(nullable = false)
    @ManyToOne(cascade = CascadeType.PERSIST)
    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(getName());
        sb.append(", Phone Number: ").append(getPhoneNumber());
        if(buddyInfoId != null) {
            sb.append(", Id: ").append(buddyInfoId);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BuddyInfo buddyInfo = (BuddyInfo) o;

        if (!Objects.equals(name, buddyInfo.name)) return false;
        if (!Objects.equals(phoneNumber, buddyInfo.phoneNumber))
            return false;
        return Objects.equals(buddyInfoId, buddyInfo.buddyInfoId);
    }
}
