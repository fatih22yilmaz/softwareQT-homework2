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
    public void testGetUserId()throws Exception {
        Assert.fail("Not implemented yet!");
    }

    @Test
    public void testGetUserBalance() throws Exception{
        account = new Account();
        account.setBalance(BALANCE);
        Assert.assertEquals(account.getBalance(), BALANCE, 0.0001);
    }
    @Test
    public void testGetUserOwnerTckn() {
        account = new Account();
        account.setOwnerTckn(OWNER_TCKN);
        Assert.assertEquals(account.getOwnerTckn(), OWNER_TCKN);
    }
    @Test
    public void testGetUserOwnerFirstName() {
        account = new Account();
        account.setOwnerFirstName(OWNER_FIRST_NAME);
        Assert.assertEquals(account.getOwnerFirstName(), OWNER_FIRST_NAME);
    }
    @Test
    public void testGetUserOwnerLastName() {
        account = new Account();
        account.setOwnerLastName(OWNER_LAST_NAME);
        Assert.assertEquals(account.getOwnerLastName(), OWNER_LAST_NAME);
    }
    @Test
    public void testSetUserBalance() {
        account = new Account();
        account.setBalance(BALANCE);
        Assert.assertEquals(account.getBalance(), BALANCE, 0.0001);
    }
    @Test
    public void testSetUserOwnerTckn() {
        account = new Account();
        account.setOwnerTckn(OWNER_TCKN);
        Assert.assertEquals(account.getOwnerTckn(), OWNER_TCKN);
    }
    @Test
    public void testSetUserOwnerFirstName() {
        account = new Account();
        account.setOwnerFirstName(OWNER_FIRST_NAME);
        Assert.assertEquals(account.getOwnerFirstName(), OWNER_FIRST_NAME);
    }
    @Test
    public void testSetUserOwnerLastName() {
        account = new Account();
        account.setOwnerLastName(OWNER_LAST_NAME);
        Assert.assertEquals(account.getOwnerLastName(), OWNER_LAST_NAME);
    }
}
