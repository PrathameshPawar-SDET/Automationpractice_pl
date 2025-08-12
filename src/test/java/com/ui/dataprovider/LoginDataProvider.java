package com.ui.dataprovider;

import com.google.gson.Gson;
import com.ui.pojo.Data;
import com.ui.pojo.User;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {

    @DataProvider(name = "LoginTestDataProvider")
    public Iterator<Object[]> loginDataProvider(){
        Gson gson = new Gson();
        File file = new File(System.getProperty("user.dir")+"\\testdata\\testData.json");
        FileReader testDataFileReader = null;
        try {
            testDataFileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Data data =gson.fromJson(testDataFileReader, Data.class);

        List<Object[]> dataToReturn = new ArrayList<Object[]>();
        if(data!=null && data.getData()!=null) {
            for (User user : data.getData()) {
                dataToReturn.add(new Object[]{user});
            }
        }
        else {
            throw new RuntimeException("No test data found");
        }

        return dataToReturn.iterator();
    }
}
