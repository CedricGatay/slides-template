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

package com.codetroopers.eput.services;

import javax.ejb.Stateless;
import java.util.UUID;

/**
 * Created by cgatay on 01/02/16.
 */
//tag::class[]
@Stateless // <1>
public class UUIDService {

    public String makeUUID(){
        return UUID.randomUUID().toString(); // <2>
    }
}
//end::class[]
