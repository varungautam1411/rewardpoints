package com.customer.rewardpoints;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class TestApplication extends RewardsPointsApplicationTest {


    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void shouldReturnJSON() throws Exception {
        this.mockMvc.perform(get("/customerRewards/101")).andDo(print()).andExpect(status().isOk()).andExpect(content().contentType("application/json"));

    }

    @Test
    public void shouldReturnException() throws Exception {
        this.mockMvc.perform(get("/customerRewards/106")).andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void purchaseOlderThanThreeMonths() throws Exception {

     MvcResult result = mockMvc.perform(get("/customerRewards/106").header("MockHttpServletResponse", 64).contentType(MediaType.APPLICATION_JSON)
                        .content("{\"Body\":\"testUserDetails\"}"))
                .andDo(MockMvcResultHandlers.print()).andReturn();
        String content = result.getResponse().getContentAsString();
           Assert.assertTrue(content.equalsIgnoreCase("Month of purchase Older than three"));
    }
    @Test
    public void notCurrentYear() throws Exception {

        MvcResult result = mockMvc.perform(get("/customerRewards/108").header("MockHttpServletResponse", 64).contentType(MediaType.APPLICATION_JSON)
                        .content("{\"Body\":\"testUserDetails\"}"))
                .andDo(MockMvcResultHandlers.print()).andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertTrue(content.equalsIgnoreCase("This purchase is not of this year"));
    }

    @Test
    public void transactionNotOldEnough() throws Exception {

        MvcResult result = mockMvc.perform(get("/customerRewards/107").header("MockHttpServletResponse", 64).contentType(MediaType.APPLICATION_JSON)
                        .content("{\"Body\":\"testUserDetails\"}"))
                .andDo(MockMvcResultHandlers.print()).andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertTrue(content.equalsIgnoreCase("Transaction date is less than a month old"));
    }
    @Test
    public void noTransactionMade() throws Exception {

        MvcResult result = mockMvc.perform(get("/customerRewards/109").header("MockHttpServletResponse", 64).contentType(MediaType.APPLICATION_JSON)
                        .content("{\"Body\":\"testUserDetails\"}"))
                .andDo(MockMvcResultHandlers.print()).andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertTrue(content.equalsIgnoreCase("No transaction made by this customer"));
    }
}