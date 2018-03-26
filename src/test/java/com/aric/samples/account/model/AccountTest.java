package com.aric.samples.account.model;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    /*
     *
     *TODO Generated valuelar için test ARAŞTIRILACAK
     */

    public static final double BALANCE = 450D;
    public static final long OWNER_TCKN = 12345678900L;
    public static final String OWNER_FIRST_NAME = "Suleyman";
    public static final String OWNER_LAST_NAME = "AKARI";
    private Account account;


    @Test
    public void testGetUserId() {
        Assert.fail("Not implemented yet!");
    }

    @Test
    public void testGetUserBalance() {
        account = new Account();
        account.setBalance(BALANCE);
        Assert.assertEquals(account.getBalance(), BALANCE, 0.0001);
    }


}
