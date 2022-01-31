package com.qaprosoft.carina.demo.api.randomUser;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostNewUser extends AbstractApiMethodV2 {

    public PostNewUser(String obj){
        super(null, "api/users/api.user/_postUser/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url_place"));
        System.out.println("request body : "+obj);
        request.body(obj);

    }
}
