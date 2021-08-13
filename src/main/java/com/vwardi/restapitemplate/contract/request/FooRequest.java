package com.vwardi.restapitemplate.contract.request;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.vwardi.restapitemplate.validation.FullName;

public class FooRequest {

    @NotBlank
    @FullName
    @Size(min = 3, max = 200)
    private final String name;

    @NotNull
    private final Integer age;

    public FooRequest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Used by Jackson to create an object from JSON
     */
    private FooRequest() {
        this.name = null;
        this.age = null;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FooRequest that = (FooRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
