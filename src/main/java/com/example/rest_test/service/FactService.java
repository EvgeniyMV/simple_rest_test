package com.example.rest_test.service;
import com.example.rest_test.model.*;

import java.util.List;

public interface FactService {

    void create(Fact fact);
    boolean delete(int factId);
    boolean update (Fact fact, int factId);

    Fact read(int factId);
   List<Fact> readByAuthor (FactAuthor factAuthor);
    List<Fact> readAll();



}
