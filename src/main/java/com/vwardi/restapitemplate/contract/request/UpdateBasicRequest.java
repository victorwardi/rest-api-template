package com.vwardi.restapitemplate.contract.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vwardi.restapitemplate.model.Basic;
import com.vwardi.restapitemplate.validation.FullName;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Request object to create a new Basic")
public class UpdateBasicRequest {

    @NotBlank
    private final Long id;

    @NotBlank
    @FullName
    @Size(min = 3, max = 200)
    private final String name;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public UpdateBasicRequest(@JsonProperty("id") Long id,
                              @JsonProperty("name") String name) {
        this.name = name;
        this.id = id;
    }

    public Basic toModel() {
        Basic basic = new Basic();
        basic.setId(this.id);
        basic.setName(this.name);
        return basic;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
