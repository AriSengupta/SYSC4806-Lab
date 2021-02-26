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
    private String address;
    private Long buddyInfoId;
    @JsonIgnore
    private AddressBook addressBook;

    public BuddyInfo() {

    }

    public BuddyInfo(BuddyInfo buddyInfo){
        this.name = buddyInfo.name;
        this.phoneNumber = buddyInfo.phoneNumber;
        this.address = buddyInfo.address;
        this.buddyInfoId = buddyInfo.buddyInfoId;
        this.addressBook = buddyInfo.addressBook;
    }

    public BuddyInfo(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public BuddyInfo(String name, String phoneNumber){
        this(name, phoneNumber, "");
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        sb.append(", Address: ").append(getAddress());
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
        return Objects.equals(name, buddyInfo.name) &&
                Objects.equals(phoneNumber, buddyInfo.phoneNumber) &&
                Objects.equals(address, buddyInfo.address) &&
                Objects.equals(buddyInfoId, buddyInfo.buddyInfoId) &&
                Objects.equals(addressBook, buddyInfo.addressBook);
    }

}
