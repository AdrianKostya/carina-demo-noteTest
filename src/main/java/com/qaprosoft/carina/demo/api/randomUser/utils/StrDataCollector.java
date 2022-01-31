package com.qaprosoft.carina.demo.api.randomUser.utils;

import com.qaprosoft.carina.demo.api.randomUser.UserData.User;
import io.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class StrDataCollector {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    JsonPath jsonPath;

    public StrDataCollector(String path){
        jsonPath= new JsonPath(path);
        LOGGER.info("Random USER received INFO : "+jsonPath+"\n");
    }


    public String getGender(){
        String gender = jsonPath.getString("results[0].gender");
        return gender;
    }

    public String getName(){
        String nameStr = jsonPath.getString("results[0].name.first");
        return nameStr;
    }

    public String getMiddleName(){
        String nameStr = jsonPath.getString("results[0].name.middle");
        return nameStr;
    }

    public String getLast(){
        String lastStr = jsonPath.getString("results[0].name.last");
        return lastStr;
    }

    public String getCountry(){
        String countryStr = jsonPath.getString("results[0].location.country");
        return countryStr;
    }
    public String getCity(){
        String cityStr = jsonPath.getString("results[0].location.city");
        return cityStr;
    }

    public String getStreet(){
        String streetStr = jsonPath.getString("results[0].location.street.name");
        return streetStr;
    }

    public String getPhone(){
        String phone = jsonPath.getString("results[0].phone");
        return phone;
    }

    public String getID(){
        String id = jsonPath.getString("info.seed");
        System.out.println("ID IS : "+id);
        return id;
    }

    public String getIDDel(){
        String id = jsonPath.getString("place_id");
        System.out.println("ID IS : "+id);
        return id;
    }
}
