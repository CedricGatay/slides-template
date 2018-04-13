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

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by cgatay on 13/01/16.
 */
//tag::class[]
@WebFilter(urlPatterns = "/*") // <1>
public class MyFilter implements  Filter{
    Logger logger;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // init your filter
        logger = Logger.getLogger(getClass().getName());
    }

    @Override
    //tag::filter[]
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        logger.info("Before filtering");
        filterChain.doFilter(request, response); // <2>
        logger.info("After filtering");
    }
    //end::filter[]

    @Override
    public void destroy() {
        // destroy allocated things
    }

}
//end::class[]