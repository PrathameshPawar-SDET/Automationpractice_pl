package com.utilities;

import com.constant.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

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
}
