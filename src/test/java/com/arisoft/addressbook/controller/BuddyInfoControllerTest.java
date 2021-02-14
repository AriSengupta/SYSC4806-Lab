package com.arisoft.addressbook.controller;

import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class BuddyInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    static final String BUDDY_INFO_NAME = "Bob";
    static final String BUDDY_INFO_NUMBER = "123-4567";

    @BeforeEach
    public void setup() throws Exception{
        //Create Address Book
        mockMvc.perform(MockMvcRequestBuilders.post("/addressbook")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @AfterEach
    public void cleanUp() throws Exception {
        //Delete Address Book
        mockMvc.perform(MockMvcRequestBuilders.delete("/addressbook")
                .accept(MediaType.APPLICATION_JSON));
    }

    @Test
    public void addBuddyInfo() throws Exception {
        //Add Buddy Info
        mockMvc.perform(MockMvcRequestBuilders.post("/buddyinfo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"name\":\"" + BUDDY_INFO_NAME + "\",\n" +
                        "\t\"phoneNumber\":\"" + BUDDY_INFO_NUMBER + "\"\n" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"" + BUDDY_INFO_NAME + "\"")))
                .andExpect(content().string(containsString("\"phoneNumber\":\"" + BUDDY_INFO_NUMBER + "\"")));
    }

    @Test
    public void readBuddyInfo() throws Exception {
        //Add Buddy Info
        mockMvc.perform(MockMvcRequestBuilders.post("/buddyinfo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"name\":\"" + BUDDY_INFO_NAME + "\",\n" +
                        "\t\"phoneNumber\":\"" + BUDDY_INFO_NUMBER + "\"\n" +
                        "}"))
                .andExpect(status().isOk());

        //Read Buddy Info
        mockMvc.perform(MockMvcRequestBuilders.get("/buddyinfo")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"" + BUDDY_INFO_NAME + "\"")))
                .andExpect(content().string(containsString("\"phoneNumber\":\"" + BUDDY_INFO_NUMBER + "\"")));
    }

    @Test
    public void updateBuddyInfo() throws Exception {
        //Add Buddy Info
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/buddyinfo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"name\":\"" + BUDDY_INFO_NAME + "\",\n" +
                        "\t\"phoneNumber\":\"" + BUDDY_INFO_NUMBER + "\"\n" +
                        "}"))
                .andExpect(status().isOk())
                .andReturn();

        //Get id of new Buddy Info
        JSONObject jsonObject = new JSONObject(result.getResponse().getContentAsString());
        int buddyInfoId = jsonObject.getInt("buddyInfoId");

        //Update Buddy Info
        mockMvc.perform(MockMvcRequestBuilders.put("/buddyinfo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"name\":\"" + BUDDY_INFO_NAME + "\",\n" +
                        "\t\"phoneNumber\":\"000-0000\",\n" +
                        "\t\"buddyInfoId\":\"" + buddyInfoId + "\"\n" +
                        "}"))
                .andExpect(status().isOk());

        //Read Buddy Info
        mockMvc.perform(MockMvcRequestBuilders.get("/buddyinfo")
                .param("id", String.valueOf(buddyInfoId))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"" + BUDDY_INFO_NAME + "\"")))
                .andExpect(content().string(containsString("\"phoneNumber\":\"000-0000\"")));
    }

    @Test
    public void deleteAddressBook() throws Exception {
        //Add Buddy Info
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/buddyinfo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"name\":\"" + BUDDY_INFO_NAME + "\",\n" +
                        "\t\"phoneNumber\":\"" + BUDDY_INFO_NUMBER + "\"\n" +
                        "}"))
                .andExpect(status().isOk())
                .andReturn();

        //Get id of new Buddy Info
        JSONObject jsonObject = new JSONObject(result.getResponse().getContentAsString());
        int buddyInfoId = jsonObject.getInt("buddyInfoId");

        //Delete Buddy Info
        mockMvc.perform(MockMvcRequestBuilders.delete("/buddyinfo")
                        .param("id", String.valueOf(buddyInfoId)))
                        .andExpect(status().isOk());

        //Read Buddy Info
        mockMvc.perform(MockMvcRequestBuilders.get("/buddyinfo")
                .param("id", String.valueOf(buddyInfoId))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("[null]")));
    }
}
