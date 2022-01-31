package com.qaprosoft.carina.demo.api.randomUser.utils;


import com.qaprosoft.carina.demo.api.randomUser.UserData.Location;
import com.qaprosoft.carina.demo.api.randomUser.UserData.User;

public class StrToObjConverter {
    private String locationStr;
    private String userInfo;

    Location location;
    User user =new User();

    public StrToObjConverter(Location location){
        this.location=location;
    }

    public StrToObjConverter(User user){
        this.user=user;
    }

    public Location getLocationObj(String locationStr){
        this.locationStr = locationStr;
        System.out.println("Location : "+locationStr);
        return location;
    }

    public User getUserObj(String userInfo){
        this.userInfo=userInfo;
        return user;
    }



}
