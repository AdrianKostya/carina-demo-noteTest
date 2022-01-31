package com.qaprosoft.carina.demo.api.randomUser;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PutUserData extends AbstractApiMethodV2 {

    public PutUserData(String obj){
        super(null, null);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url_place"));
        System.out.println("request body : "+obj);
        request.body(obj);
    }
}
