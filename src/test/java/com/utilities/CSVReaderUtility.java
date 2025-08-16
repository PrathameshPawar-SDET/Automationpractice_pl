package com.utilities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtility {

    public static Iterator<User> readCSVFile(String filemae){
        File csvFile = new File(System.getProperty("user.dir")+"//testdata//"+filemae);
        FileReader csvFileReader = null;
        CSVReader csvReader;
        String[] line;
        List<User> userList=null;
        User userData;

        try {
            csvFileReader = new FileReader(csvFile);
            csvReader = new CSVReader(csvFileReader);
            csvReader.readNext();
            userList = new ArrayList<>();
            while ((line=csvReader.readNext())!=null){
              userData = new User(line[0],line[1]);
              userList.add(userData);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException |CsvValidationException e){
            e.printStackTrace();
        }
        return userList.iterator();


    }

}
