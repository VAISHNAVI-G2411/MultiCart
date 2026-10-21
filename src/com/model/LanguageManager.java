package com.model;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.MissingResourceException;

public class LanguageManager {

    private ResourceBundle bundle;

    public void selectLanguage(int choice) {

    Locale locale;

    switch (choice) {
        case 1:
            locale = Locale.ENGLISH;
            break;

        case 2:
           locale = Locale.forLanguageTag("ta");
            break;

        case 3:
           locale = Locale.forLanguageTag("hi");
            break;

        case 4:
            locale = Locale.forLanguageTag("te");
            break;

        case 5:
            locale = Locale.forLanguageTag("ml");
            break;

        default:
            locale = Locale.ENGLISH;
    }

    try {
        bundle = ResourceBundle.getBundle(
            "com.resources.messages",
            locale
        );

        System.out.println("Language selected successfully.");

    } catch (MissingResourceException e) {

        System.out.println("Language file not found.");
        System.out.println("Using English language instead.");

        try {
            bundle = ResourceBundle.getBundle(
                "com.resources.messages",
                Locale.ENGLISH
            );
        } catch (MissingResourceException ex) {
            System.out.println("English language file also not found.");
        }
    }
}

public String getMessage(String key) {

    if (bundle == null) {
        return key;
    }

    try {
        return bundle.getString(key);
    } catch (MissingResourceException e) {
        return key;
    }
}
}


