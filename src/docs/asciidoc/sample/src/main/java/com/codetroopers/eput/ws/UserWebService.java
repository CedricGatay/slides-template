/*
 * Copyright 2016 Code-Troopers.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codetroopers.eput.ws;


import com.codetroopers.eput.domain.entities.User;
import com.codetroopers.eput.services.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Sample REST WebService, it will be under "ws" app path
 */
//tag::class[]
@ApplicationPath("ws") // <1>
@Path("/users") // <2>
@Produces(MediaType.APPLICATION_JSON) // <3>
public class UserWebService extends Application{

    @Inject
    UserService userService;

    @GET // <4>
    public List<User> users(){
        return userService.all();
    }

    @POST // <4>
    public User create(
            @QueryParam("name") String name, // <5>
            @QueryParam(value = "email") String email){
        User user = new User(name, email);
        user.password = "<FROMWS>";
        return userService.create(user);
    }
}
//end::class[]