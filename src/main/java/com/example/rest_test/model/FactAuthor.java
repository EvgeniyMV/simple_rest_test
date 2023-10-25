package com.example.rest_test.model;

public class FactAuthor {
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) this.name = name;
        else this.name = "Неизвестный автор";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FactAuthor)) return false;
        if (this.name.equalsIgnoreCase(((FactAuthor) obj).getName())) return true;
        return false;
    }
}
