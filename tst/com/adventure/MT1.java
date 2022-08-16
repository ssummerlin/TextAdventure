package com.adventure;

import main.com.adventure.settings.AppSettings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MT1 {

    @Test
    void smokeTest() {
        assertNotEquals(AppSettings.Story.Invalid_Beginning, AppSettings.story, "Update the 'story' inside of main.com.adventure.settings.AppSettings to MT1_Beginning");
    }

}
