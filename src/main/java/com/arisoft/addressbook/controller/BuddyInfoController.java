package com.arisoft.addressbook.controller;

import com.arisoft.addressbook.model.AddressBook;
import com.arisoft.addressbook.model.BuddyInfo;
import com.arisoft.addressbook.repository.AddressBookRepository;
import com.arisoft.addressbook.repository.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


/**
 * Created by Aritra Sengupta
 * on 2021-02-04.
 */

@RestController
public class BuddyInfoController {

    final AddressBookRepository addressBookRepository;
    final BuddyInfoRepository buddyInfoRepository;

    @Autowired
    public BuddyInfoController(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository){
        this.addressBookRepository = addressBookRepository;
        this.buddyInfoRepository = buddyInfoRepository;
    }

    //CREATE
    @PostMapping("/buddyinfo")
    public BuddyInfo addBuddyInfo(@RequestBody BuddyInfo buddyInfo) {
        AddressBook addressBook = addressBookRepository.findById(1L).orElse(null);
        if (addressBook != null) {
            addressBook.addBuddy(buddyInfo);
            buddyInfoRepository.save(buddyInfo);
        } else {
            throw new RuntimeException("Address Book needs to be created before adding BuddyInfo");
        }
        return buddyInfo;
    }

    //READ
    @GetMapping("/buddyinfo")
    public Iterable<BuddyInfo> readBuddyInfo(@RequestParam( required = false, value = "id") Long buddyInfoId) {
        if(buddyInfoId == null){
            return buddyInfoRepository.findAll();
        } else {
            BuddyInfo buddyInfo = buddyInfoRepository.findById(buddyInfoId).orElse(null);
            return Collections.singleton(buddyInfo);
        }
    }

    //UPDATE
    @PutMapping("/buddyinfo")
    public BuddyInfo updateBuddyInfo(@RequestBody BuddyInfo buddyInfo) {
        BuddyInfo updatedBuddyInfo =  buddyInfoRepository.findById(buddyInfo.getBuddyInfoId()).orElse(null);
        if(updatedBuddyInfo != null){
            updatedBuddyInfo.setName(buddyInfo.getName());
            updatedBuddyInfo.setPhoneNumber(buddyInfo.getPhoneNumber());
            updatedBuddyInfo.setBuddyInfoId(buddyInfo.getBuddyInfoId());
            buddyInfoRepository.save(updatedBuddyInfo);
        } else {
            throw new RuntimeException("No BuddyInfo found to update");
        }
        return buddyInfo;
    }

    //DELETE
    @DeleteMapping("/buddyinfo")
    public BuddyInfo deleteBuddyInfo(@RequestParam(value = "id") Long buddyInfoId) {
        BuddyInfo buddyInfo = buddyInfoRepository.findById(buddyInfoId).orElse(null);
        if(buddyInfo == null){
            throw new RuntimeException("BuddyInfo with specified id was not found.");
        } else
            buddyInfoRepository.deleteById(buddyInfoId);
        return buddyInfo;
    }
}
