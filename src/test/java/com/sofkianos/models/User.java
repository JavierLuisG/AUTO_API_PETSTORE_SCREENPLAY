package com.sofkianos.models;

public record User(
        long id,
        String username,
        String firstName,
        String lastName,
        String email,
        String password,
        String phone,
        int userStatus
) {
}