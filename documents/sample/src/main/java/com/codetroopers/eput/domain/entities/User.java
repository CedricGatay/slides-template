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

package com.codetroopers.eput.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by cgatay on 19/01/16.
 */
//tag::class[]
@Entity // <1>
@Table(name = "user") // <2>
public class User {
    @Id @GeneratedValue // <3>
    public Long id;
    @NotNull // <4>
    public String name;
    @NotNull // <4>
    public String email;
    @NotNull
    public String password;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User() {
    }
}
//end::class[]
