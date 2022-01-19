package com.batchbot.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.Objects;

@Getter
@Setter
public class CaseDTO implements Comparable<CaseDTO> {

    private String firstName;

    private String lastName;

    private String eyeColor;

    private String hairColor;

    @Override
    public boolean equals (final Object o) {
        if (this == o) return true;
        if (!(o instanceof CaseDTO)) return false;

        CaseDTO that = (CaseDTO) o;
        return Objects.equals(that.getFirstName(), this.getFirstName())
                && Objects.equals(that.getLastName(), this.getLastName())
                && Objects.equals(that.getEyeColor(), this.getEyeColor())
                && Objects.equals(that.getHairColor(), this.getHairColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getEyeColor(), getHairColor());
    }

    @Override
    public int compareTo(final CaseDTO o) {
        return Comparator.comparing(CaseDTO::getFirstName)
                .thenComparing(CaseDTO::getLastName)
                .thenComparing(CaseDTO::getEyeColor)
                .thenComparing(CaseDTO::getHairColor)
                .compare(this, o);
    }
}
