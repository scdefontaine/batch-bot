package com.batchbot.dbo;

import lombok.Data;

@Data
public class CaseDBO {

    private String firstName;

    private String lastName;

    private String eyeColor;

    private String hairColor;

    public CaseDBO() {
    }

    public CaseDBO(String firstName, String lastName, String eyeColor, String hairColor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
    }

    @Override
    public String toString() {
        return firstName + ", " + lastName + ", " + eyeColor + ", " + hairColor;
    }

}
