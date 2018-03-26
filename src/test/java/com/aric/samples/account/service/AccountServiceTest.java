package com.aric.samples.account.service;

import com.aric.samples.account.model.Account;
import com.aric.samples.account.repository.AccountRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    private static final double BALANCE = 450D;
    private static final long OWNER_TCKN = 123L;
    private static final String OWNER_FIRST_NAME = "Fatih";
    private static final String OWNER_LAST_NAME = "Yılmaz";

    private static final double BALANCE_HASAN = 450D;
    private static final long OWNER_TCKN_HASAN = 123L;
    private static final String OWNER_FIRST_NAME_HASAN = "Hasanol";
    private static final String OWNER_LAST_NAME_HASAN = "Yılmaz";

    private static final double DEPOSIT_AMOUNT = 100D;
    private static final double TRANSFER_AMOUNT_LESS_THAN_HALF_OF_SENDER_BALANCE = 50D;
    private static final double TRANSFER_AMOUNT_MORE_THAN_HALF_OF_SENDER_BALANCE = 250D;
    private static final double NEGATIVE_TRANSFER_AMOUNT = -50D;
    private static Account FATIH;
    private static Account HASAN;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Autowired
    private AccountService accountService;


    @Before
    public void setUp() {
        FATIH = new Account();
        FATIH.setId(0);
        FATIH.setBalance(BALANCE);
        FATIH.setOwnerTckn(OWNER_TCKN);
        FATIH.setOwnerFirstName(OWNER_FIRST_NAME);
        FATIH.setOwnerLastName(OWNER_LAST_NAME);

        HASAN = new Account();
        HASAN.setId(1);
        HASAN.setBalance(BALANCE_HASAN);
        HASAN.setOwnerTckn(OWNER_TCKN_HASAN);
        HASAN.setOwnerFirstName(OWNER_FIRST_NAME_HASAN);
        HASAN.setOwnerLastName(OWNER_LAST_NAME_HASAN);

        final AccountRepository mockAccountRepository = Mockito.mock(AccountRepository.class);
        ReflectionTestUtils.setField(accountService, "accountRepository", mockAccountRepository);
        Mockito.when(mockAccountRepository.findByOwnerFirstNameAndOwnerLastName(OWNER_FIRST_NAME, OWNER_LAST_NAME)).thenReturn(Arrays.asList(FATIH));
        Mockito.when(mockAccountRepository.findOne(FATIH.getId())).thenReturn(FATIH);
        Mockito.when(mockAccountRepository.save(FATIH)).thenReturn(FATIH);
        Mockito.when(mockAccountRepository.findOne(HASAN.getId())).thenReturn(HASAN);
        Mockito.when(mockAccountRepository.save(HASAN)).thenReturn(HASAN);
    }


    @Test
    public void testFindAccountsByFirstNameAndLastName() throws Exception {
        final List<Account> accountList = accountService.findAccountsByFirstNameAndLastName(OWNER_FIRST_NAME, OWNER_LAST_NAME);
        Assert.assertEquals("No user found with this first and last name.", accountList.get(0), FATIH);
    }

    @Test
    public void testDeposit() throws Exception {
        final Account account = accountService.deposit(FATIH.getId(), DEPOSIT_AMOUNT);
        double expected = BALANCE + DEPOSIT_AMOUNT;
        Assert.assertEquals(account.getBalance(), expected, 0.001);
    }

    @Test
    public void testTransferWithLessThanHalfOfSenderBalance() throws Exception {
        double expectedDifferenceBetweenAccounts = TRANSFER_AMOUNT_LESS_THAN_HALF_OF_SENDER_BALANCE * 2D;
        final Account account = accountService.transfer(FATIH.getId(), HASAN.getId(), TRANSFER_AMOUNT_LESS_THAN_HALF_OF_SENDER_BALANCE);
        double actualDifferenceBetweenAccounts = HASAN.getBalance() - FATIH.getBalance();
        Assert.assertEquals("Withdrawn money is not equal to deposited money!",
                expectedDifferenceBetweenAccounts, actualDifferenceBetweenAccounts, 0.001);
    }

    @Test
    public void testTransferWithMoreThanHalfOfSenderBalance() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Amount cannot be greater than balance");
        final Account account = accountService.transfer(FATIH.getId(), HASAN.getId(), TRANSFER_AMOUNT_MORE_THAN_HALF_OF_SENDER_BALANCE);
    }

    @Test
    public void testTransferWithNegativeAmount() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Amount should be a positive value");
        final Account account = accountService.transfer(FATIH.getId(), HASAN.getId(), NEGATIVE_TRANSFER_AMOUNT);

    }

}
