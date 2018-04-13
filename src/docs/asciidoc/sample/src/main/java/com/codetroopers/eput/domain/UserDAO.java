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

import com.codetroopers.eput.domain.entities.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by cgatay on 19/01/16.
 */
//tag::class[]
@Stateless
public class UserDAO {
    @Inject
    EntityManager em;

    //tag::allMethod[]
    public List<User> all(){
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
    //end::allMethod[]

    public User create() {
        User user = new User("NAME", "name@code-troopers.com");
        em.persist(user);
        return user;
    }

    public User save(User user) {
        em.persist(user);
        return user;
    }
}
//end::class[]
