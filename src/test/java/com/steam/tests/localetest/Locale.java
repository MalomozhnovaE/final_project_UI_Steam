package com.steam.tests.localetest;

public enum Locale {
    RU("Русский (Russian)"),

    EN("English (английский)");

    private final String desc;

    Locale(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
