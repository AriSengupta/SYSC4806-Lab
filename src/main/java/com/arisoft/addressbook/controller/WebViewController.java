package com.arisoft.addressbook.controller;

import com.arisoft.addressbook.model.AddressBook;
import com.arisoft.addressbook.repository.AddressBookRepository;
import com.arisoft.addressbook.repository.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/view")
    public String addressBookForm(Model model){
        AddressBook addressBook = addressBookRepository.findById(1L).orElse(null);
        if(addressBook == null){
            model.addAttribute("addressBook", new AddressBook());
        } else {
            model.addAttribute("addressBook", addressBook);
        }
        model.addAttribute("buddyInfos", buddyInfoRepository.findAll());
        return "addressBookView";
    }

}
