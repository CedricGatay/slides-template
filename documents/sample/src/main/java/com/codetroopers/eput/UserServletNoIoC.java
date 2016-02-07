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

package com.codetroopers.eput;

import com.codetroopers.eput.domain.UserDAO;
import com.codetroopers.eput.services.UserServiceNoIoC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cgatay on 13/01/16.
 */
//tag::class[]
@WebServlet(urlPatterns = "/users_no_ioc")
public class UserServletNoIoC extends HttpServlet{

    UserServiceNoIoC userService;

    //tag::ctor[]
    public UserServletNoIoC() {
        userService = new  UserServiceNoIoC(new UserDAO());
    }
    //end::ctor[]

    @Override
    //tag::get[]
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.all().forEach(u ->{
            try {
                resp.getWriter().println(u.name + " - " + u.email);
            } catch (IOException e) {
                //don't ever do this
            }
        });
    }
    //end::get[]
}
//end::class[]