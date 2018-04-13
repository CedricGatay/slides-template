package com.codetroopers.eput.controllers;

import com.codetroopers.eput.domain.entities.GoldenBookEntry;
import com.codetroopers.eput.models.UserInfo;
import com.codetroopers.eput.services.GoldenBookEntryService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class GoldenBookEntryController {
    @Inject
    UserInfo userInfo;
    @Inject
    GoldenBookEntryService goldenBookEntryService;

    private GoldenBookEntry newEntry;

    public String insertNewEntry() {
        //here we persist our new Entry value
        goldenBookEntryService.insertNewGoldenBookEntry(newEntry);
        return "entries" + "?faces-redirect=true";
    }

    @Produces
    @Named
    public GoldenBookEntry newBookEntry() {
        return newEntry;
    }

    @PostConstruct
    public void initClass() {
        newEntry = new GoldenBookEntry();
        if (userInfo.getLoggedIn()) {
            newEntry.setAuthor(userInfo.getName());
        }
    }
}
