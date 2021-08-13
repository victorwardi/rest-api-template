package com.vwardi.restapitemplate.contract.request;

import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.vwardi.restapitemplate.model.Basic;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Request object to create a new Basic")
public class CreateNewBasicRequest {

    @Valid
    @JsonUnwrapped
    private final FooRequest fooRequest;

    public CreateNewBasicRequest (String name, Integer age) {
        this.fooRequest = new FooRequest(name, age);
    }

    private CreateNewBasicRequest() {
        this.fooRequest = null;
    }

    public Basic toModel() {
        Basic basic = new Basic();
        basic.setName(this.fooRequest.getName());
        return basic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateNewBasicRequest that = (CreateNewBasicRequest) o;
        return Objects.equals(fooRequest, that.fooRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fooRequest);
    }
}
