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

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cgatay on 01/02/16.
 */
//tag::class[]
@Stateful // <1>
@SessionScoped // <2>
public class CartService implements Serializable {

    @Inject
    ItemPriceService itemPriceService;

    private List<String> cartContent;

    public CartService() {
        this.cartContent = new ArrayList<>();
    }

    public List<String> addItemToCart(String item) {
        itemPriceService.checkPrice(item);
        this.cartContent.add(item);
        return this.cartContent; // <3>
    }
}
//end::class[]