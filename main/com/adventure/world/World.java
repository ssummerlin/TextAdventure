package main.com.adventure.world;

import main.com.adventure.settings.AppSettings;
import main.com.adventure.world.objects.Tangible;
import main.com.adventure.world.objects.TangibleListener;
import main.com.adventure.world.objects.doors.Door;
import main.com.adventure.world.scenes.Scene;
import main.com.adventure.world.scenes.SceneFactory;

import java.util.ArrayList;
import java.util.List;

public class World {

    private List<Scene> scenes = new ArrayList<>( 3);

    private TangibleListener listener;

    /**
     * Creates a world based on the app settings.
     */
    public World() {
        switch (AppSettings.story) {
            case MT1_Beginning:
                break;
            case MT2_CaveEscape:
                getScenes().add( SceneFactory.buildCaveEscapeScene() );
                break;
            case MT3_TestDirections:
            case MT6_TestDirections:
                setListener( new main.com.adventure.world.World.ConsoleEscapeTangibleListener() );
                for (int i = 0; i < 3; i++) {
                    try {
                        getScenes().add( SceneFactory.buildConsoleEscape( i, getListener() ) );
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case MT4_HouseAndCave:
                for (int i = 0; i < 3; i++) {
                    try {
                        getScenes().add( SceneFactory.buildHouseAndCaveScene( i ) );
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case MT5_DigEscape:
                getScenes().add( SceneFactory.buildDigEscape() );
                break;
            case TestScene:
                getScenes().add( SceneFactory.buildTestScene() );
                break;
            case MT7_MonsterScene:
                getScenes().add( SceneFactory.buildMonsterRing() );
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + AppSettings.story);
        }
        
    }

    /**
     * Builds the user-facing string of the possible directions for a given scene.
     * @param currentIndex - the location index of the scene that should be used to determine possible directions
     * @return - the user-facing string of possible directions
     */
    public String getPossibleDirections(int currentIndex) {
        List<String> directions = getScenes().get( currentIndex ).getPossibleDirections();
        if (directions == null || directions.isEmpty()) {
            return "";
        }
        String response = directions.stream().reduce("You can MOVE", (current, element) -> {
            if (directions.get(0).equals(element)) {
                current += " " + element;
            } else if (directions.get(directions.size() - 1).equals(element)) {
                if (directions.size() > 2) {
                    current += ", or " + element + ".";
                } else if (directions.size() == 2) {
                    current += " or " + element + ".";
                } else {
                    current = " " + element + ".";
                }
            } else {
                current += ", " + element;
            }
            return current;
        });
        return response;
    }

    public
    java.util.List < main.com.adventure.world.scenes.Scene > getScenes() {
        return scenes;
    }

    public
    void setScenes( java.util.List < main.com.adventure.world.scenes.Scene > scenes ) {
        this.scenes = scenes;
    }

    public
    main.com.adventure.world.objects.TangibleListener getListener() {
        return listener;
    }

    public
    void setListener( main.com.adventure.world.objects.TangibleListener listener ) {
        this.listener = listener;
    }

    private class ConsoleEscapeTangibleListener implements TangibleListener {
        @Override
        public void tangibleUsed(Tangible tangible) {
            Tangible iDoor = getScenes().get( getScenes().size() - 1 ).getItem( "door" );
            if (iDoor instanceof Door) {
                ((Door) iDoor).setIsOpen(true);
                System.out.println("You hear a large gear turn down the hall. Did a door just become unlocked?");
            }
        }
    }
}
