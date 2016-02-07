package com.codetroopers.eput.services;

import com.codetroopers.eput.models.GoldenBookEntry;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class GoldenBookEntriesProducer {
    @Inject
    private EntityManager em;

    private List<GoldenBookEntry> bookEntries;

    @PostConstruct
    @SuppressWarnings("unchecked")
    public void initList() {
        bookEntries = new ArrayList<>();
        bookEntries.add(new GoldenBookEntry("John", "C'est trop bien, je peux plus m'en passer"));
        bookEntries.add(new GoldenBookEntry("Henry", "waaaaaa, j'adore"));
        bookEntries.add(new GoldenBookEntry("Marc", "Je veux la même chez moi !"));
    }


    /**
     * This method returns the list of the available bookEntries.
     * It is annotated with the @Produces annotation to tell that it generates values
     * It is annotated with the @Named annotation to be able to call it by name in bookEntries.jsf
     *
     * @return list of bookEntries.
     */
    @Produces
    @Named
    public List<GoldenBookEntry> loadGoldenBookEntries() {
        return bookEntries;
    }
}
