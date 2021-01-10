package com.example.springsocial.workspace.rest;

import java.io.Serializable;

class NewWorkspace implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
