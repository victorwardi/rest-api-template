package com.vwardi.restapitemplate.controller.response;

import com.vwardi.restapitemplate.model.Basic;
import org.springframework.util.Assert;

public class CreateNewBasicResponse {

    private final String id;
    private final String name;

    public CreateNewBasicResponse(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public CreateNewBasicResponse(Basic basic) {

        Assert.notNull(basic, "Basic cannot be null");
        Assert.notNull(basic.getId(), "Basic id cannot be null");
        Assert.notNull(basic.getName(), "Basic name cannot be null");

        this.id = basic.getId().toString();
        this.name = basic.getName();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
