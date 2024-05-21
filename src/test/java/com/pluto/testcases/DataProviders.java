package com.pluto.testcases;

import com.data.dynamic.FakerDataFactory;
import org.testng.annotations.DataProvider;

public class DataProviders {

    
    @DataProvider(name = "getPhlSpecialBanks")
    public Object[][] getPhlSpecialBanks() {
        return new Object[][]{{FakerDataFactory.get12DigitsBankAccountNumber(),"PNBMPHMM","PHILIPPINES","Aklan"},{FakerDataFactory.getBankAccountNumber(),"BOPIPHMM","PHILIPPINES","Aklan"}};
    }

    @DataProvider(name = "searchVesselByName")
    public Object[][] searchVesselByName() {
        return new Object[][]{{"YASA EMIRHAN"},{"YASA"},{"YASA Golden"},{"Star"},{"dubai express"}};
    }

    
}
