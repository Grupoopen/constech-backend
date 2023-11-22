package com.construction.systems.constech.profiles.interfaces.rest.resources;

public record CreateProfileResource(String firstName, String lastName, String email, String street, String number, String city, String state, String zipCode) {
}
