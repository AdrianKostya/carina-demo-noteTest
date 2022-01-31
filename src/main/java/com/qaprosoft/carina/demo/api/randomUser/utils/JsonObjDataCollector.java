package com.qaprosoft.carina.demo.api.randomUser.utils;

import com.qaprosoft.carina.demo.api.randomUser.UserData.Location;
import com.qaprosoft.carina.demo.api.randomUser.UserData.User;

public class JsonObjDataCollector {
    StrDataCollector strDataCollector;
    User userInfo = new User();

    Location location = new Location();

    public JsonObjDataCollector(String path){
        strDataCollector = new StrDataCollector(path);
    }

    public User setFirst(){
        userInfo.setFirst(strDataCollector.getName());
        return userInfo;
    }

    public User setMiddleName(){
        userInfo.setFirst(strDataCollector.getName());
        return userInfo;
    }

    public User setLast(){
        userInfo.setLast(strDataCollector.getLast());
        return userInfo;
    }

    public User setGender(){
        userInfo.setGender(strDataCollector.getGender());
        System.out.println(userInfo.hashCode());
        return userInfo;
    }

    public User setId(){
        userInfo.setId(strDataCollector.getID());
        return userInfo;
    }

    public String getStrId(){
        String id = strDataCollector.getID();
        return id;
    }

    public String getStrLocationId(){
        String id = strDataCollector.getIDDel();
        return id;
    }
    public User getObjLocationId(){
        userInfo.setId(strDataCollector.getIDDel());
        return userInfo;
    }

    public Location setCountry(){
        location.setCountry(strDataCollector.getCountry());
        return location;
    }

    public Location setCity(){
        location.setCity(strDataCollector.getCity());
        return location;
    }

    public Location getStreet(){
        location.setStreet(strDataCollector.getStreet());
        return location;
    }

}
