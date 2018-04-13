package com.codetroopers.eput.services;

import com.codetroopers.eput.domain.GoldenBookEntryDAO;
import com.codetroopers.eput.domain.entities.GoldenBookEntry;
import com.codetroopers.eput.models.UserInfo;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * This class is annotated with the Stateless marker. It allows to automatically handle transactions.
 */
@Stateless
public class GoldenBookEntryService {
    @Inject
    UserInfo userInfo;
    @Inject
    GoldenBookEntryDAO bookEntryDAO;


    public void insertNewGoldenBookEntry(final GoldenBookEntry entry) {


    }

    public List<GoldenBookEntry> loadGoldenBookEntries() {
        return bookEntryDAO.all();
    }
}
