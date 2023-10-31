package com.example.rest_test.service;
import com.example.rest_test.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class FactServiceImpl  implements FactService {
    private static final HashMap<Integer, Fact> factBase = new HashMap<>();
    private static int id = 0;


    @Override
    public void create(Fact fact) {
        if (fact != null) {
            factBase.put(id, fact);
            fact.setId(id++);
        }

    }

    @Override
    public boolean delete(int factId) {
        if (factBase.containsKey(factId)) {
            factBase.remove(factId);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Fact fact, int factId) {
        System.out.println(factId);
        if(factBase.containsKey(factId) && fact != null) {
            factBase.put(factId, fact);
            fact.setId(factId);
            return true;
        }
        return false;
    }

    @Override
    public Fact read(int factId) {
        if (factBase.containsKey(factId)) return factBase.get(factId);
        return null;
    }

    @Override
    public List<Fact> readByAuthor(FactAuthor factAuthor) {
        List<Fact> factsByAuthor = new ArrayList<>();
         factBase.values().forEach(f -> { if (f.getAuthor().equals(factAuthor)) factsByAuthor.add(f);});
            return factsByAuthor;
    }

    @Override
    public List<Fact> readAll() {
        return new ArrayList<>(factBase.values());
    }
}
