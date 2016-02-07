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

import com.codetroopers.eput.domain.entities.User;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Startup
@Singleton
public class MyApplicationInit {

    @Inject
    EntityManager em;

    @PostConstruct
    public void onStart() {

        User cedric = new User("cedric", "cedric@code-troopers.com");
        cedric.password = "coruscant";
        em.persist(cedric);

        User florian = new User("florian", "florian@code-troopers.com");
        florian.password = "dagoba";
        em.persist(florian);
    }
}
