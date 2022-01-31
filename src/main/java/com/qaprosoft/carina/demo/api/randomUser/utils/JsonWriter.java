package com.qaprosoft.carina.demo.api.randomUser.utils;

import com.qaprosoft.carina.demo.api.randomUser.UserData.Location;
import com.qaprosoft.carina.demo.api.randomUser.UserData.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.FileWriter;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

public class JsonWriter {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    JSONObject users;
    FileWriter fileWriter;
    JSONArray openArray;
    JSONObject userInfo;
    JSONObject user;


    public JsonWriter() throws IOException {
        users = new JSONObject();
        openArray = new JSONArray();
        userInfo = new JSONObject();
        user = new JSONObject();
        fileWriter = new FileWriter("UserInfo.json");
    }

    public JSONObject writeName(User first, User last) {
        openArray.add(user);
        user.put("user", userInfo);
        userInfo.put("first",first.getFirst());
        userInfo.put("last", last.getLast());
        users.put("users", openArray);
        LOGGER.info("Name data was written to json file successful");
        return users;

    }

    public JSONObject writeAddress(JSONObject users, Location country, Location city, Location street) throws IOException {
        JSONObject locationInfo = new JSONObject();
        locationInfo.put("city", city.getCity());
        locationInfo.put("street", street.getStreet());
        locationInfo.put("country", country.getCountry());
        userInfo.put("location", locationInfo);
        fileWriter.write(users.toJSONString());
        fileWriter.flush();
        LOGGER.info("Location data was written to json file successful");

        return users;
    }
}
