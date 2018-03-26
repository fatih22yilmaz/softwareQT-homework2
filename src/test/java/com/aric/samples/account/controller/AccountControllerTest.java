package com.aric.samples.account.controller;


import com.aric.samples.account.model.Account;
import com.aric.samples.account.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testQueryShouldReturnUserAccountWhenNameAndLastNamePassed() throws Exception {
        Account account1 = new Account();
        account1.setBalance(450.0);
        account1.setOwnerTckn(12345);
        account1.setOwnerFirstName("Fatih");
        account1.setOwnerLastName("Yılmaz");
        Account account2 = new Account();
        account1.setOwnerTckn(678910);
        account1.setOwnerFirstName("Hasan Emre");
        account1.setOwnerLastName("ARI");

        AccountService mockAccount;
        mockAccount = org.mockito.Mockito.mock(AccountService.class);
        Mockito.when(mockAccount.findAccountsByFirstNameAndLastName("Fatih", "Yılmaz"))
                .thenReturn(Arrays.asList(account1, account2));

        mockMvc.perform(get("/query").param("firstName", "Fatih")
                .param("lastName", "Yılmaz")).andExpect(status().isOk())
                //.andExpect(content().contentType("application/json"))
                .andExpect(jsonPath(("$[0].id")).exists())
                .andExpect(jsonPath("$[0].balance").value(450));
    }


}