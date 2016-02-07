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

package com.codetroopers.eput.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.inject.Singleton;
import java.util.logging.Logger;

/**
 * Created by cgatay on 01/02/16.
 */
//tag::class[]
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class VisitBean {
    Logger logger = Logger.getLogger(getClass().getName());
    private int visits = 0; // <1>

    @PostConstruct
    public void initialized(){
        logger.info("VisitBean initialized..."); // <2>
    }

    @PreDestroy
    public void willBeDestroyed(){
        logger.info("VisitBean will be terminated..."); // <2>
    }

    @Lock(LockType.WRITE) // <3>
    public int increment() {
        return visits++;
    }

    @Lock(LockType.READ) // <3>
    public int count() {
        return visits;
    }
}
//end::class[]