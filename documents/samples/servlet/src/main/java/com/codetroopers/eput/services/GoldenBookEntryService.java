package com.codetroopers.eput.services;

import com.codetroopers.eput.models.GoldenBookEntry;
import com.codetroopers.eput.models.UserInfo;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * This class is annotated with the Stateless marker. It allows to automatically handle transactions.
 */
@Stateless
public class GoldenBookEntryService {
    @Inject
    Event<GoldenBookEntry> mepoEvent;
    @Inject
    UserInfo userInfo;
    @Inject
    EntityManager em;


    public void insertNewGoldenBookEntry(final GoldenBookEntry entry) {
        em.merge(entry);
        mepoEvent.fire(entry);
    }
}
