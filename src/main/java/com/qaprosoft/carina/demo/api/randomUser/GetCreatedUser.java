package com.qaprosoft.carina.demo.api.randomUser;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetCreatedUser extends AbstractApiMethodV2 {

    public GetCreatedUser (String id){
        super(null, "api/users/api.user/_getCreatedUser/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url_place"));
        replaceUrlPlaceholder("id", id);

    }
}
