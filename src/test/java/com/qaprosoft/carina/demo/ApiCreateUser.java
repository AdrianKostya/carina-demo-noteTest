package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.randomUser.*;
import com.qaprosoft.carina.demo.api.randomUser.UserData.Location;
import com.qaprosoft.carina.demo.api.randomUser.UserData.User;
import com.qaprosoft.carina.demo.api.randomUser.utils.*;
import net.minidev.json.parser.ParseException;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.*;
import java.util.stream.Collectors;


public class ApiCreateUser extends AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    String emptyUserJson = "src/test/resources/api/users/api.user/_postUser/rq.json";
    String emptyIdJson = "src/test/resources/api/users/api.user/_deleteUser/rq.json";
    String updateDataJson = "src/test/resources/api/users/api.user/_putUserData/rq.json";

//    //TEST CASE: 1
//    //1.GET Random user

    @Test
    public void getRandomUser() {
        GetRandomUser getRandomUser = new GetRandomUser();
        getRandomUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        getRandomUser.callAPI();
        getRandomUser.validateResponse();
    }

//    //TEST CASE: 2
//    //1.GET Random user, 2.Replace data from received JSON, 3.Fill Json with extracted data
//    //4.Create new User

    @Test
    public void createNewUser() throws IOException, ParseException {
        GetRandomUser getRandomUser = new GetRandomUser();
        getRandomUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        String randomUserData = getRandomUser.callAPI().asString();
        getRandomUser.validateResponse();
        JsonObjDataCollector jsonObjDataCollector = new JsonObjDataCollector(randomUserData);
        User name = jsonObjDataCollector.setFirst();
        User last = jsonObjDataCollector.setLast();
        Location city = jsonObjDataCollector.setCity();
        Location street = jsonObjDataCollector.getStreet();
        ObjToJsonDataWriter emptyUser = new ObjToJsonDataWriter(emptyUserJson);
        emptyUser.fillName(name, last).toJSONString();
        String splicedUser = emptyUser.fillAddress(city, street).toJSONString();
        System.out.println("Spliced user is : " + splicedUser);
        PostNewUser postNewUser = new PostNewUser(splicedUser);
        postNewUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        postNewUser.callAPI();
        postNewUser.validateResponse();
    }


////    //TEST CASE: 3
////    //1.GET Random user, 2.Replace data from received JSON, 3.Fill Json with extracted data
////    //4.Create new User, 5.From response Get user ID and delete after by ID;

    @Test
    public void DeleteUserById() throws IOException, ParseException {
        GetRandomUser getRandomUser = new GetRandomUser();
        getRandomUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        String randomUserData = getRandomUser.callAPI().asString();
        getRandomUser.validateResponse();
        JsonObjDataCollector jsonObjDataCollector = new JsonObjDataCollector(randomUserData);
        User name = jsonObjDataCollector.setFirst();
        User last = jsonObjDataCollector.setLast();
        Location city = jsonObjDataCollector.setCity();
        Location street = jsonObjDataCollector.getStreet();
        ObjToJsonDataWriter emptyUser = new ObjToJsonDataWriter(emptyUserJson);
        emptyUser.fillName(name, last).toJSONString();
        String splicedUser = emptyUser.fillAddress(city, street).toJSONString();
        PostNewUser postUserMethod = new PostNewUser(splicedUser);
        postUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String response = postUserMethod.callAPI().asString();
        postUserMethod.validateResponse();
        JsonObjDataCollector getId = new JsonObjDataCollector(response);
        User id = getId.getObjLocationId();
        System.out.println("User is : "+id+" "+"User id is : "+id.getId());
        ObjToJsonDataWriter emptyUserId = new ObjToJsonDataWriter(emptyIdJson);
        String splicedUser1 = emptyUserId.fillId(id).toJSONString();
        DeleteUserById deleteUserMethod = new DeleteUserById(splicedUser1);
        deleteUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteUserMethod.callAPI();
        deleteUserMethod.validateResponse();
    }
////
////    //TEST CASE: 4
////    //1.GET Random user, 2.Replace data from received JSON, 3.Fill Json with extracted data
////    //4.Create new User, 5.Get user info by ID;

    @Test
    public void CreateUserAndGetUserInfo() throws IOException, ParseException {
        GetRandomUser getRandomUser = new GetRandomUser();
        getRandomUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        String randomUserData = getRandomUser.callAPI().asString();
        JsonObjDataCollector jsonObjDataCollector = new JsonObjDataCollector(randomUserData);
        User name = jsonObjDataCollector.setFirst();
        User last = jsonObjDataCollector.setLast();
        Location country = jsonObjDataCollector.setCountry();
        Location city = jsonObjDataCollector.setCity();
        Location street = jsonObjDataCollector.getStreet();
        ObjToJsonDataWriter emptyUser = new ObjToJsonDataWriter(emptyUserJson);
        emptyUser.fillName(name, last);
        String splicedUser = emptyUser.fillAddress(country, city, street).toJSONString();
        PostNewUser postNewUser = new PostNewUser(splicedUser);
        postNewUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        String response1 = postNewUser.callAPI().asString();
        JsonObjDataCollector getData1 = new JsonObjDataCollector(response1);
        String id = getData1.getStrLocationId();
        GetCreatedUser getCreatedUser = new GetCreatedUser(id);
        getCreatedUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCreatedUser.callAPI().asString();
        getCreatedUser.validateResponse();
    }

////    //TEST CASE: 5
////    //1.GET Random user, 2.Replace data from received JSON, 3.Fill new Json with extracted data
////    //4.Create new User, 5.From response Get user ID and delete after by ID,
////    //6.Get data about deleted user (should be status 404 - NOT found)

    @Test
    public void DeleteUserByIdAndRequestData() throws IOException, ParseException {
        GetRandomUser getRandomUser = new GetRandomUser();
        getRandomUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        String randomUserData = getRandomUser.callAPI().asString();
        JsonObjDataCollector userData = new JsonObjDataCollector(randomUserData);
        User name = userData.setFirst();
        User last = userData.setLast();
        Location city = userData.setCity();
        Location street = userData.getStreet();
        ObjToJsonDataWriter emptyUser = new ObjToJsonDataWriter(emptyUserJson);
        emptyUser.fillName(name, last);
        String splicedUser = emptyUser.fillAddress(city, street).toString();
        LOGGER.info("JSON after MODIFYING : " + splicedUser);
        PostNewUser postUserMethod = new PostNewUser(splicedUser);
        postUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        String response = postUserMethod.callAPI().asString();
        LOGGER.info("USER is created RS : " + response);
        JsonObjDataCollector getData1 = new JsonObjDataCollector(response);
        User id = getData1.getObjLocationId();
        ObjToJsonDataWriter replaceId = new ObjToJsonDataWriter(emptyIdJson);
        String newBuildedJsonForDL = replaceId.fillId(id).toJSONString();
        DeleteUserById deleteUserMethod = new DeleteUserById(newBuildedJsonForDL);
        deleteUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteUserMethod.callAPI();
        deleteUserMethod.validateResponse();
        String idStr = getData1.getStrLocationId();
        GetDeletedUser getDeletedUser = new GetDeletedUser(idStr);
        getDeletedUser.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        getDeletedUser.callAPI().asString();
        getDeletedUser.validateResponse();
    }

    //
////    //TEST CASE: 6
////    //1.GET Random user(GET), 2.Save data from received JSON, 3.Fill new Json with extracted data
////    //4.Create new User(POST), 5.Update user Address by ID(PUT), 6.Get updated User info;
//
    @Test
    public void ReplaceDataAboutRandomUser() throws IOException, ParseException {
        //Get random data about user//
        GetRandomUser getRandomUser = new GetRandomUser();
        getRandomUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        String randomUserData = getRandomUser.callAPI().asString();
        //Extract  Data and prepare json with new user//
        JsonObjDataCollector jsonObjDataCollector = new JsonObjDataCollector(randomUserData);
        User name = jsonObjDataCollector.setFirst();
        User last = jsonObjDataCollector.setLast();
        Location city = jsonObjDataCollector.setCity();
        Location street = jsonObjDataCollector.getStreet();
        ObjToJsonDataWriter emptyUser = new ObjToJsonDataWriter(emptyUserJson);
        emptyUser.fillName(name, last);
        String splicedUser = emptyUser.fillAddress(city, street).toString();
        //Create new User//
        PostNewUser postNewUser = new PostNewUser(splicedUser);
        postNewUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        String createdUserRS = postNewUser.callAPI().asString();
        postNewUser.validateResponse();
        //Extract id and set new address for updating//
        JsonObjDataCollector jsonObjDataCollector1 = new JsonObjDataCollector(createdUserRS);
        User id = jsonObjDataCollector1.getObjLocationId();
        ObjToJsonDataWriter objToJsonDataWriter1 = new ObjToJsonDataWriter(updateDataJson);
        objToJsonDataWriter1.fillId(id);
        Location location = new Location("Ukraine", "Chernivtsi", "Holovna 74");
        StrToObjConverter c = new StrToObjConverter(location);
        Location country1 = c.getLocationObj(location.getCountry());
        Location city1 = c.getLocationObj(location.getCity());
        Location street1 = c.getLocationObj(location.getStreet());
        String updatedJson = objToJsonDataWriter1.fillAddress(country1, city1, street1).toJSONString();
        PutUserData putUserData = new PutUserData(updatedJson);
        putUserData.expectResponseStatus(HttpResponseStatusType.OK_200);
        putUserData.callAPI();
        GetCreatedUser getCreatedUser = new GetCreatedUser(id.getId());
        getCreatedUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCreatedUser.callAPI().asString();
        getCreatedUser.validateResponse();
    }

    @Test
    public void PostAndWriteToJson() throws IOException, ParseException {
        GetRandomUser getRandomUser = new GetRandomUser();
        getRandomUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        String response = getRandomUser.callAPI().asString();
        JsonObjDataCollector obj = new JsonObjDataCollector(response);
        User name = obj.setFirst();
        User last = obj.setLast();
        Location city = obj.setCity();
        Location street = obj.getStreet();
        Location country = obj.setCountry();
        ObjToJsonDataWriter emptyUser = new ObjToJsonDataWriter(emptyUserJson);
        emptyUser.fillName(name, last);
        String splicedUser = emptyUser.fillAddress(country, city, street).toJSONString();
        PostNewUser postNewUser = new PostNewUser(splicedUser);
        postNewUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        postNewUser.callAPI();
        postNewUser.validateResponse();
        JsonWriter jsonWriter = new JsonWriter();
        JSONObject jsonObject = jsonWriter.writeName(name, last);
        jsonWriter.writeAddress(jsonObject, country, city, street);
    }



    @Test
    public void getMaleUser(){
        GetRandomUser getRandomUser = new GetRandomUser();
        getRandomUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        String response = getRandomUser.callAPI().asString();
        JsonObjDataCollector obj = new JsonObjDataCollector(response);
        obj.setGender();
        obj.setFirst();
        User userObj= obj.setLast();
        User user;
        System.out.println(userObj);
        if (userObj.getGender().equals("male")) {
            user = new User(userObj.getFirst(), userObj.getLast(), userObj.getGender(), "12341234");
            Assert.assertEquals(user.getGender(),"male");

        }else getMaleUser();
    }

    @Test
    public void sortUsersByName() {
        User user = new User();
        LinkedList<User> userlinkedList = new LinkedList<>();

        for (int i = 0; i <=10; i++) {
                GetRandomUser getRandomUser = new GetRandomUser();
                getRandomUser.expectResponseStatus(HttpResponseStatusType.OK_200);
                String response = getRandomUser.callAPI().asString();
                getRandomUser.validateResponse();
                StrDataCollector jsonStr = new StrDataCollector(response);
                user.setFirst(jsonStr.getName());
                user.setLast(jsonStr.getLast());
                user.setGender(jsonStr.getGender());
                user.setId(jsonStr.getID());
                User user1 = new User(user.getFirst(), user.getLast(), user.getGender(), user.getId());

                userlinkedList.add(user1);
            System.out.println("userlinkedList contain : "+userlinkedList.size()+" objects");
        }
        for (Object user11:userlinkedList){
            System.out.println("Name is : "+user11);
        }

        System.out.println("Sorted is below");
        List <User> sorted = userlinkedList.stream()
                .sorted(Comparator.comparing(User::getFirst))
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
    }

    @Test
    public void addInfoToObjManuallyTest() throws IOException, ParseException {
        GetRandomUser getRandomUser = new GetRandomUser();
        getRandomUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        String response = getRandomUser.callAPI().asString();
        JsonObjDataCollector obj = new JsonObjDataCollector(response);
        User name = obj.setFirst();
        User last = obj.setLast();
        User middleName = obj.setMiddleName();
        ObjToJsonDataWriter emptyUser = new ObjToJsonDataWriter(emptyUserJson);
        if (middleName.getMiddleName() == null) {
            String middleNameS = "Murano";
            middleName.setMiddleName(middleNameS);
        }
        emptyUser.fillName(name, last, middleName);
        Assert.assertEquals(middleName.getMiddleName(), "Murano");

    }


}


