package com.a505.hobbyit.hobby.enums;

public enum HobbyFree {
    FREE("FREE"),
    NONFREE("NON-FREE");

    private final String value;

    HobbyFree(String value) {
        this.value = value;
    }

    public String registry(){
        return value;
    }
}
