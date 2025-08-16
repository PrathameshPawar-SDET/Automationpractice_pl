package com.utilities;

import com.constant.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Data;
import com.ui.pojo.Environments;
import com.ui.pojo.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JSONUtils {

    public static Environments readJson(Env env){
        Gson gson = new Gson();
        File file = new File(System.getProperty("user.dir")+"//Config//Config.json");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Config config=gson.fromJson(fileReader, Config.class);
        Environments environments = config.getEnvironments().get("QA");
        return environments;
    }

    public static Iterator<Object[]> jsonFileReader(String filename){
        Gson gson = new Gson();
        File file = new File(System.getProperty("user.dir")+"//testdata//"+filename);
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
