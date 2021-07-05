package com.vwardi.restapitemplate.contract.response;

import org.springframework.util.Assert;

import com.vwardi.restapitemplate.model.Basic;

import io.swagger.annotations.ApiModelProperty;

public class UpdateBasicResponse {

    @ApiModelProperty(value = "Basic id")
    private final String id;

    @ApiModelProperty(value = "Basic name")
    private final String name;

    public UpdateBasicResponse(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public UpdateBasicResponse(Basic basic) {

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
