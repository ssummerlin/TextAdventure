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

    public List<Scene> scenes = new ArrayList<>(3);

    TangibleListener listener;

    /**
     * Creates a world based on the app settings.
     */
    public World() {
        switch (AppSettings.story) {
            case MT1_Beginning:
                break;
            case MT2_CaveEscape:
                scenes.add(SceneFactory.buildCaveEscapeScene());
                break;
            case MT3_TestDirections:
            case MT6_TestDirections:
                listener = new ConsoleEscapeTangibleListener();
                for (int i = 0; i < 3; i++) {
                    try {
                        scenes.add(SceneFactory.buildConsoleEscape(i, listener));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case MT4_HouseAndCave:
                for (int i = 0; i < 3; i++) {
                    try {
                        scenes.add(SceneFactory.buildHouseAndCaveScene(i));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case MT5_DigEscape:
                scenes.add(SceneFactory.buildDigEscape());
                break;
            case TestScene:
                scenes.add(SceneFactory.buildTestScene());
                break;
            case MT7_MonsterScene:
                scenes.add(SceneFactory.buildMonsterRing());
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
        List<String> directions = scenes.get(currentIndex).getPossibleDirections();
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

    private class ConsoleEscapeTangibleListener implements TangibleListener {
        @Override
        public void tangibleUsed(Tangible tangible) {
            Tangible iDoor = scenes.get(scenes.size() - 1).getItem("door");
            if (iDoor instanceof Door) {
                ((Door) iDoor).setIsOpen(true);
                System.out.println("You hear a large gear turn down the hall. Did a door just become unlocked?");
            }
        }
    }
}
