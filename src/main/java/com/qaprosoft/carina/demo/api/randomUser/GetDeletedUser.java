package com.qaprosoft.carina.demo.api.randomUser;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetDeletedUser extends AbstractApiMethodV2 {

    public GetDeletedUser(String id){
        super(null, "api/users/api.user/_getDeletedUser/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url_place"));
        replaceUrlPlaceholder("id", id);


    }
}
