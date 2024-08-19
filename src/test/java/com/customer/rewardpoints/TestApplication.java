package com.customer.rewardpoints;


import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;




import static org.junit.matchers.JUnitMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class TestApplication extends RewardsPointsApplicationTest{


    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
 @Before
 public void setup(){
     mockMvc =MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
 }
    @Test
    public void shouldReturnJSON() throws Exception {
        this.mockMvc.perform(get("/customerRewards/101")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

    }
    @Test
    public void shouldReturnException() throws Exception {
        this.mockMvc.perform(get("/customerRewards/106")).andDo(print()).andExpect(status().is4xxClientError());


    }
}