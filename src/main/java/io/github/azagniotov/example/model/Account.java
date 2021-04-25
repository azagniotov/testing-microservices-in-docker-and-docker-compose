package io.github.azagniotov.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {

    private final String id;
    private final String name;
    private final String username;
    private final String email;
    private final String phone;

    @JsonCreator
    public Account(@JsonProperty("id") final String id,
                   @JsonProperty("name") final String name,
                   @JsonProperty("username") final String username,
                   @JsonProperty("email") final String email,
                   @JsonProperty("phone") final String phone) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
