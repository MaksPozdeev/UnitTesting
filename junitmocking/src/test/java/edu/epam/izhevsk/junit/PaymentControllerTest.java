package edu.epam.izhevsk.junit;

import org.hamcrest.CustomMatcher;
import org.junit.*;

import static org.mockito.AdditionalMatchers.*;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PaymentControllerTest {

    @Mock
    AccountService mAccSrv;

    @Mock
    DepositService mDepSrv;

    @InjectMocks
    private PaymentController paymentController;

    @Before
    public void setUp() throws InsufficientFundsException {
        paymentController = new PaymentController(mAccSrv, mDepSrv);
        Mockito.when(mAccSrv.isUserAuthenticated(100L)).thenReturn(true);
        Mockito.when(mDepSrv.deposit(geq(100L), Mockito.anyLong())).thenThrow(new InsufficientFundsException());
    }

    @Test
    @Ignore
    public void methodDeposit() throws InsufficientFundsException {
        Mockito.when(!mAccSrv.isUserAuthenticated(Mockito.anyLong())).thenReturn(false);
        Assert.assertTrue(mAccSrv.isUserAuthenticated(100L));
        Mockito.verify(mAccSrv, times(1)).isUserAuthenticated(100L);
        Assert.assertFalse(mAccSrv.isUserAuthenticated(50L));
        mDepSrv.deposit(Mockito.anyLong(), Mockito.anyLong());
        Mockito.verify(mDepSrv, atLeastOnce()).deposit(Mockito.anyLong(), Mockito.anyLong());
    }

    @Test
    public void testSuccessfulDepositForUserId100AndAmount50() throws InsufficientFundsException {
        paymentController.deposit(50L, 100L);
        Mockito.verify(mAccSrv).isUserAuthenticated(100L);
    }

    @Test(expected = InsufficientFundsException.class)
    public void testFailedDepositOfLargeAmountForUnauthenticatedUser() throws InsufficientFundsException {
//        Assert.assertEquals("exception", mDepSrv.deposit(150L, 10L));
        mDepSrv.deposit(150L, 10L);
    }

    @Test
    public void testFailedDepositForUnauthenticatedUser() {
        Assert.assertFalse(mAccSrv.isUserAuthenticated(10L));
    }

    @Test(expected = InsufficientFundsException.class)
    public void testFailedDepositOfLargeAmountForAuthenticatedUser() throws InsufficientFundsException {
//        Assert.assertEquals("exception", mDepSrv.deposit(150L, 100L));
        mDepSrv.deposit(150L, 100L);
    }

    @Test(expected = SecurityException.class)
    public void testFailedDepositOfGoodAmountForUnauthenticatedUser() throws InsufficientFundsException {
        paymentController.deposit(50L, 10L);
    }
}