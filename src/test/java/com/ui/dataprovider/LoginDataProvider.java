package com.ui.dataprovider;

import com.google.gson.Gson;
import com.ui.pojo.Data;
import com.ui.pojo.User;
import com.utilities.CSVReaderUtility;
import com.utilities.JSONUtils;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {

    @DataProvider(name = "LoginTestJSONDataProvider")
    public Iterator<Object[]> loginJSONDataProvider(){
        return JSONUtils.jsonFileReader("testData.json");

    }

    @DataProvider(name = "LoginTestCSVDataProvider")
    public Iterator<User> loginCSVDataProvider(){
        return CSVReaderUtility.readCSVFile("testData.csv");
    }
}
