package com.qaprosoft.carina.demo.api.randomUser;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class DeleteUserById extends AbstractApiMethodV2 {
    public DeleteUserById(String s){
        super(null, "api/users/api.user/_deleteUser/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url_place"));
        request.body(s);
    }

}
