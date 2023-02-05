package uk.co.ii.financialtoolsservice.demo.webclient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.ReplayProcessor;

class DemoControllerTest {
    /**
     * Method under test: {@link DemoController#getAllCustomers()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllCustomers() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "uk.co.ii.financialtoolsservice.demo.webclient.CustomerDataProvider.getCustomer()" because "this.customerDataProvider" is null
        //       at uk.co.ii.financialtoolsservice.demo.webclient.CustomerService.getAllCustomer(CustomerService.java:20)
        //       at uk.co.ii.financialtoolsservice.demo.webclient.DemoController.getAllCustomers(DemoController.java:28)
        //   See https://diff.blue/R013 to resolve this issue.

        (new DemoController(new CustomerService(null))).getAllCustomers();
    }

    /**
     * Method under test: {@link DemoController#getAllCustomers()}
     */
    @Test
    void testGetAllCustomers2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        CustomerDataProvider customerDataProvider = mock(CustomerDataProvider.class);
        when(customerDataProvider.getCustomer()).thenReturn(new ArrayList<>());
        ResponseEntity<List<Customer>> actualAllCustomers = (new DemoController(
                new CustomerService(customerDataProvider))).getAllCustomers();
        assertTrue(actualAllCustomers.hasBody());
        assertEquals(HttpStatus.OK, actualAllCustomers.getStatusCode());
        assertTrue(actualAllCustomers.getHeaders().isEmpty());
        verify(customerDataProvider).getCustomer();
    }

    /**
     * Method under test: {@link DemoController#getAllCustomersAsStream()}
     */
    @Test
    void testGetAllCustomersAsStream() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new DemoController(new CustomerService(new CustomerDataProvider()))).getAllCustomersAsStream();
    }

    /**
     * Method under test: {@link DemoController#getAllCustomersAsStream()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllCustomersAsStream2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "uk.co.ii.financialtoolsservice.demo.webclient.CustomerDataProvider.getCustomerStream()" because "this.customerDataProvider" is null
        //       at uk.co.ii.financialtoolsservice.demo.webclient.CustomerService.getAllCustomerFlux(CustomerService.java:23)
        //       at uk.co.ii.financialtoolsservice.demo.webclient.DemoController.getAllCustomersAsStream(DemoController.java:36)
        //   See https://diff.blue/R013 to resolve this issue.

        (new DemoController(new CustomerService(null))).getAllCustomersAsStream();
    }

    /**
     * Method under test: {@link DemoController#getAllCustomersAsStream()}
     */
    @Test
    void testGetAllCustomersAsStream3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        CustomerDataProvider customerDataProvider = mock(CustomerDataProvider.class);
        when(customerDataProvider.getCustomerStream()).thenReturn(DirectProcessor.create());
        (new DemoController(new CustomerService(customerDataProvider))).getAllCustomersAsStream();
        verify(customerDataProvider).getCustomerStream();
    }

    /**
     * Method under test: {@link DemoController#getAllCustomersAsStream()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllCustomersAsStream4() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Flux.doOnComplete(java.lang.Runnable)" because the return value of "uk.co.ii.financialtoolsservice.demo.webclient.CustomerService.getAllCustomerFlux()" is null
        //       at uk.co.ii.financialtoolsservice.demo.webclient.DemoController.getAllCustomersAsStream(DemoController.java:36)
        //   See https://diff.blue/R013 to resolve this issue.

        CustomerDataProvider customerDataProvider = mock(CustomerDataProvider.class);
        when(customerDataProvider.getCustomerStream()).thenReturn(null);
        (new DemoController(new CustomerService(customerDataProvider))).getAllCustomersAsStream();
    }

    /**
     * Method under test: {@link DemoController#getAllCustomersAsStream()}
     */
    @Test
    void testGetAllCustomersAsStream5() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        CustomerDataProvider customerDataProvider = mock(CustomerDataProvider.class);
        when(customerDataProvider.getCustomerStream()).thenReturn(ReplayProcessor.create(3, true));
        (new DemoController(new CustomerService(customerDataProvider))).getAllCustomersAsStream();
        verify(customerDataProvider).getCustomerStream();
    }

    /**
     * Method under test: {@link DemoController#getAllCustomersAsStream2()}
     */
    @Test
    void testGetAllCustomersAsStream22() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new DemoController(new CustomerService(new CustomerDataProvider()))).getAllCustomersAsStream2();
    }

    /**
     * Method under test: {@link DemoController#getAllCustomersAsStream2()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllCustomersAsStream23() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "uk.co.ii.financialtoolsservice.demo.webclient.CustomerDataProvider.getCustomerStream()" because "this.customerDataProvider" is null
        //       at uk.co.ii.financialtoolsservice.demo.webclient.CustomerService.getAllCustomerFlux(CustomerService.java:23)
        //       at uk.co.ii.financialtoolsservice.demo.webclient.DemoController.getAllCustomersAsStream2(DemoController.java:43)
        //   See https://diff.blue/R013 to resolve this issue.

        (new DemoController(new CustomerService(null))).getAllCustomersAsStream2();
    }

    /**
     * Method under test: {@link DemoController#getAllCustomersAsStream2()}
     */
    @Test
    void testGetAllCustomersAsStream24() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        CustomerDataProvider customerDataProvider = mock(CustomerDataProvider.class);
        DirectProcessor<Customer> createResult = DirectProcessor.create();
        when(customerDataProvider.getCustomerStream()).thenReturn(createResult);
        assertSame(createResult,
                (new DemoController(new CustomerService(customerDataProvider))).getAllCustomersAsStream2());
        verify(customerDataProvider).getCustomerStream();
    }
}

