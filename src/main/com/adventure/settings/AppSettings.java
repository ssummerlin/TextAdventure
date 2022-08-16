package main.com.adventure.settings;

public class AppSettings {

    /** You will update this property for each project. **/
    public static final Story story = Story.Invalid_Beginning;

    public enum Story {
        TestScene,

        Invalid_Beginning,
        MT1_Beginning,

        MT2_CaveEscape,
        MT3_TestDirections,
        MT4_HouseAndCave,
        MT5_DigEscape,

        MT6_TestDirections,
        MT7_MonsterScene,
        MT8,

    }

    /**
     * Checks if given story is greater than or equal to the selected story.
     * @param requestedStory - the story
     * @return - true if the current story is greater than or equal to the requested story.
     */
    public static boolean canAccessFunctions(Story requestedStory) {
        return AppSettings.story.ordinal() >= requestedStory.ordinal();
    }

    /**
     * Returns the starting location of a given story.
     * @return the starting location (defaults to 0)
     */
    public static int getStartingLocation() {
        int startingLocation = 0;
        switch (story) {
            case MT3_TestDirections:
            case MT4_HouseAndCave:
            case MT6_TestDirections:
                startingLocation = 1;
                break;
            default:
                startingLocation = 0;
                break;
        }
        return startingLocation;
    }

}
