package tests.integration;

import src.integration.CustomerCatalog;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerCatalogTest {
    private int customerExistInSystem = 123456789;
    private int customerNotExistInSystem = 987654321;
    private int customerIDIsZero = 0;

    @Test
    public void testcustomerInRegister(){
        CustomerCatalog customerCatalog = new CustomerCatalog();
        boolean expectedResult = true;
        boolean result = customerCatalog.customerInRegister(customerExistInSystem);
        assertEquals("The expected customer does not  exist in the catalog.", expectedResult, result);
    }

    @Test
    public void testcustomerNotInRegister(){
        CustomerCatalog customerCatalog = new CustomerCatalog();
        boolean expectedResult = false;
        boolean result = customerCatalog.customerInRegister(customerNotExistInSystem);
        assertEquals("The expected customer does exist in the catalog.", expectedResult, result);
    }

    @Test
    public void testcustomerIDisZero(){
        CustomerCatalog customerCatalog = new CustomerCatalog();
        boolean expectedResult = false;
        boolean result = customerCatalog.customerInRegister(customerIDIsZero);
        assertEquals("The expected customer does exist in the catalog.", expectedResult, result);
    }

    
}