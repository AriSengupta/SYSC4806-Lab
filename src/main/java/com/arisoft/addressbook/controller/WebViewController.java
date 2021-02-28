package com.arisoft.addressbook.controller;

import com.arisoft.addressbook.model.AddressBook;
import com.arisoft.addressbook.model.BuddyInfo;
import com.arisoft.addressbook.repository.AddressBookRepository;
import com.arisoft.addressbook.repository.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Aritra Sengupta
 * on 2021-02-05.
 */

@Controller
public class WebViewController {
    private final AddressBookRepository addressBookRepository;
    private final BuddyInfoRepository buddyInfoRepository;

    @Autowired
    public WebViewController(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository){
        this.addressBookRepository = addressBookRepository;
        this.buddyInfoRepository = buddyInfoRepository;
    }

    @GetMapping("/addressBookView")
    public String addressBookForm(Model model){
        AddressBook addressBook = addressBookRepository.findById(1L).orElse(null);
        if(addressBook == null){
            model.addAttribute("addressBook", new AddressBook());
        } else {
            model.addAttribute("addressBook", addressBook);
        }
        model.addAttribute("buddyInfos", new BuddyInfo());
        return "addressBookView";
    }

    @PostMapping("/createAddressBook")
    public String createAddressBook(Model model) {
        AddressBook addressBook = addressBookRepository.findById(1L).orElse(null);
        if(addressBook == null){
            AddressBook newAddressBook = new AddressBook();
            addressBookRepository.save(newAddressBook);
            model.addAttribute("addressBook", newAddressBook);
        } else {
            model.addAttribute("addressBook", addressBook);
        }
        return "addressBookCreatedView";
    }

    @PostMapping("/createBuddyInfo")
    public String createBuddyInfo(@ModelAttribute("buddy") BuddyInfo buddyInfo) {
        AddressBook addressBook = addressBookRepository.findById(1L).orElse(null);
        if(addressBook == null){
            throw new RuntimeException("No Address Book exists to add BuddyInfos too");
        } else {
            addressBook.addBuddy(buddyInfo);
            buddyInfoRepository.save(buddyInfo);
            addressBookRepository.save(addressBook);
        }
        return "buddyInfoAddedView";
    }
}
