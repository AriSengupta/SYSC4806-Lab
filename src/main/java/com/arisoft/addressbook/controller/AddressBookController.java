package com.arisoft.addressbook.controller;

import com.arisoft.addressbook.model.AddressBook;
import com.arisoft.addressbook.model.BuddyInfo;
import com.arisoft.addressbook.repository.AddressBookRepository;
import com.arisoft.addressbook.repository.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aritra Sengupta
 * on 2021-02-04.
 */

@RestController
public class AddressBookController {

    private final AddressBookRepository addressBookRepository;
    private final BuddyInfoRepository buddyInfoRepository;

    @Autowired
    public AddressBookController(AddressBookRepository addressBookRepository,
                                 BuddyInfoRepository buddyInfoRepository){
        this.addressBookRepository = addressBookRepository;
        this.buddyInfoRepository = buddyInfoRepository;
    }

    @PostMapping("/addressbook")
    public AddressBook addAddressBook() {
        AddressBook addressBook = addressBookRepository.findById(1L).orElse(null);
        if(addressBook == null){
            AddressBook newAddressBook = new AddressBook();
            addressBookRepository.save(newAddressBook);
            return newAddressBook;
        }
        return addressBook;
    }

    @GetMapping("/addressbook")
    public AddressBook getAddressBook(){
        return addressBookRepository.findById(1L).orElse(null);
    }

    @DeleteMapping("/addressbook")
    public AddressBook clearAddressBook() {
        AddressBook addressBook = addressBookRepository.findById(1L).orElse(null);
        if(addressBook != null){
            //Delete all Buddy Infos
            buddyInfoRepository.deleteAll();
            addressBookRepository.save(new AddressBook());
        }
        return addressBookRepository.findById(1L).orElse(null);
    }
}
