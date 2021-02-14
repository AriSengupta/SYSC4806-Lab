package com.arisoft.addressbook.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @AfterEach
    public void cleanUp() throws Exception{
        //Delete Address Book
        mockMvc.perform(MockMvcRequestBuilders.delete("/addressbook").accept(MediaType.APPLICATION_JSON));
    }

    @Test
    public void addAddressBook() throws Exception{
        //Create Address Book
        mockMvc.perform(MockMvcRequestBuilders.post("/addressbook").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"buddyInfos\":[],\"addressBookId\":1}")));
    }

    @Test
    public void getAddressBook() throws Exception{
        //Create Address Book
        mockMvc.perform(MockMvcRequestBuilders.post("/addressbook").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        //Get Address Book
        mockMvc.perform(MockMvcRequestBuilders.get("/addressbook").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"buddyInfos\":[],\"addressBookId\":1}")));
    }

    @Test
    public void deleteAddressBook() throws Exception{
        //Create Address Book
        mockMvc.perform(MockMvcRequestBuilders.post("/addressbook").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        //Delete Address Book
        mockMvc.perform(MockMvcRequestBuilders.delete("/addressbook").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"buddyInfos\":[],\"addressBookId\":1}")));

        //Ensure Address Book is empty
        mockMvc.perform(MockMvcRequestBuilders.get("/addressbook").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
    }
}
