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

import com.codetroopers.eput.exceptions.PriceInvalidException;
import com.codetroopers.eput.services.CartService;

import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by cgatay on 13/01/16.
 */
//tag::class[]
@WebServlet(urlPatterns = "/ejb/stateful")
public class StatefulServlet extends HttpServlet {

    @Inject
    CartService cartService;

    @Override
    //tag::get[]
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doStatefulThings(req, resp);
        resp.getWriter().flush();
    }
    //end::get[]

    //tag::stateful[]
    private void doStatefulThings(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String item = req.getParameter("item");
        List<String> cartContent;
        try {
            cartContent = cartService.addItemToCart(item);
            resp.getWriter().println("Stateful " + cartContent.stream().collect(Collectors.joining(",")));
        } catch (EJBException e) {
            if (e.getCausedByException() instanceof PriceInvalidException) {
                resp.getWriter().println("Too bad Yoda has no price !");
                resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            } else {
                resp.getWriter().println("Too bad something wrong occurred !");
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
            //need to reset CDI Context by resetting session, future calls will be invalid otherwise (transaction rolled back)
            req.getSession().invalidate();
        }
    }
    //end::stateful[]
}
//end::class[]