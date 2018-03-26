package com.aric.samples.account.model;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testGetUserBalance() throws Exception{
        account = new Account();
        account.setBalance(BALANCE);
        Assert.assertEquals(account.getBalance(), BALANCE, 0.0001);
    }
    @Test
    public void testGetUserOwnerTckn ()throws Exception {
        account = new Account();
        account.setOwnerTckn(OWNER_TCKN);
        Assert.assertEquals(account.getOwnerTckn(), OWNER_TCKN);
    }
    @Test
    public void testGetUserOwnerFirstName() throws Exception{
        account = new Account();
        account.setOwnerFirstName(OWNER_FIRST_NAME);
        Assert.assertEquals(account.getOwnerFirstName(), OWNER_FIRST_NAME);
    }
    @Test
    public void testGetUserOwnerLastName() throws Exception{
        account = new Account();
        account.setOwnerLastName(OWNER_LAST_NAME);
        Assert.assertEquals(account.getOwnerLastName(), OWNER_LAST_NAME);
    }
    @Test
    public void testSetUserBalance() throws Exception{
        account = new Account();
        account.setBalance(BALANCE);
        Assert.assertEquals(account.getBalance(), BALANCE, 0.0001);
    }
    @Test
    public void testSetUserOwnerTckn() throws Exception{
        account = new Account();
        account.setOwnerTckn(OWNER_TCKN);
        Assert.assertEquals(account.getOwnerTckn(), OWNER_TCKN);
    }
    @Test
    public void testSetUserOwnerFirstName() throws Exception{
        account = new Account();
        account.setOwnerFirstName(OWNER_FIRST_NAME);
        Assert.assertEquals(account.getOwnerFirstName(), OWNER_FIRST_NAME);
    }
    @Test
    public void testSetUserOwnerLastName() throws Exception{
        account = new Account();
        account.setOwnerLastName(OWNER_LAST_NAME);
        Assert.assertEquals(account.getOwnerLastName(), OWNER_LAST_NAME);
    }
    @Test
    public void testDeposit() throws Exception{
        account = new Account();
        account.setBalance(450D);
        final double result = account.deposit(50);
        final double expected = 500D;
        Assert.assertEquals(result,expected,0.0001);
    }
    @Test
    public void testDepositWithNegativeValue() throws Exception{
        account = new Account();
        account.setBalance(450D);
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Amount should be a positive value");
        final double result = account.deposit(-50);

    }
    @Test
    public void testDepositWithZero() throws Exception{
        account = new Account();
        account.setBalance(450D);
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Amount should be a positive value");
        final double result = account.deposit(0);

    }
    @Test
    public void testWithdrawLessThanHalfOfTheBalance() throws Exception{
        account = new Account();
        account.setBalance(450D);
        final double result = account.withdraw(100D);
        final double expected = 350D;
        Assert.assertEquals(result,expected,0.0001);
    }
    @Test
    public void testWithdrawMoreThanHalfOfTheBalance() throws Exception{
        account = new Account();
        account.setBalance(450D);
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Amount cannot be greater than balance");
        final double result = account.withdraw(250D);


    }
    @Test
    public void testWithdrawWithGreaterThanBalance() throws Exception{
        account = new Account();
        account.setBalance(450D);
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Amount cannot be greater than balance");
        final double result = account.withdraw(500D);

    }
    @Test
    public void testWithdrawWithNegativeAmount() throws Exception{
        account = new Account();
        account.setBalance(450D);
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Amount should be a positive value");
        final double result = account.withdraw(-50D);

    }
}
