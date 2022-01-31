package com.qaprosoft.carina.demo.api.randomUser.utils;

import com.qaprosoft.carina.demo.api.randomUser.UserData.Location;
import com.qaprosoft.carina.demo.api.randomUser.UserData.User;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

public class ObjToJsonDataWriter {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    FileReader reader;
    JSONParser parser = new JSONParser();
    JSONObject obj;


    public ObjToJsonDataWriter(String path) throws IOException, ParseException {
        reader = new FileReader(path);
        obj = (JSONObject) parser.parse(reader);
    }

    public JSONObject fillName(User name, User last){
        obj.put("name", name.getFirst()+" "+last.getLast());
        return obj;
    }

    public JSONObject fillName(User name, User last, User middleName){
        obj.put("name", name.getFirst()+" "+last.getLast()+" "+middleName.getMiddleName());
        return obj;
    }

    public JSONObject fillAddress(Location city, Location street){
        obj.put("address", city.getCity()+", "+street.getStreet());
        return obj;
    }
    public JSONObject fillAddress(Location country, Location city, Location street){
        obj.put("address",country.getCountry()+", "+city.getCity()+", "+street.getStreet());
        return obj;
    }

    public JSONObject fillAddress(String country, String city, String street){
        obj.put("address",country+", "+city+", "+street);
        return obj;
    }

    public JSONObject fillId(User id){
        obj.put("place_id",id.getId());
        return obj;
    }

}
