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

import com.codetroopers.eput.domain.entities.GoldenBookEntry;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;


@Stateless
public class GoldenBookEntryDAO {
    @Inject
    EntityManager em;

    public List<GoldenBookEntry> all() {
        List<GoldenBookEntry> bookEntries = new ArrayList<>();
        bookEntries.add(new GoldenBookEntry("John", "C'est trop bien, je peux plus m'en passer"));
        bookEntries.add(new GoldenBookEntry("Henry", "waaaaaa, j'adore"));
        bookEntries.add(new GoldenBookEntry("Marc", "Je veux la même chez moi !"));
        return bookEntries;
    }

    public GoldenBookEntry create() {
        return null;
    }
}
