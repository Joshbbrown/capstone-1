package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CashRegisterTest {
    private CashRegister cashRegister;


    @Before
    public void setup() {
        cashRegister = new CashRegister();
    }



    @Test
    public void testChangeReturn(){
        Assert.assertEquals(12.34,12);
        Assert.assertEquals(1.43,1);
        Assert.assertEquals(5.05,5);
    }


}
