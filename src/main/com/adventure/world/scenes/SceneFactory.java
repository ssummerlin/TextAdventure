package main.com.adventure.world.scenes;

import main.com.adventure.world.objects.TangibleListener;
import main.com.adventure.world.scenes.s2_m1.CaveEscapeScene;
import main.com.adventure.world.scenes.s2_m2.ConsoleScene;
import main.com.adventure.world.scenes.s2_m2.HallwayDoorScene;
import main.com.adventure.world.scenes.s2_m2.TwoPathsScene;
import main.com.adventure.world.scenes.s2_m3.HouseOutsideScene;
import main.com.adventure.world.scenes.s2_m3.HouseScene;
import main.com.adventure.world.scenes.s2_m3.OutsideCaveScene;
import main.com.adventure.world.scenes.s2_m4.DigEscapeScene;
import main.com.adventure.world.scenes.s3_m2.MonsterScene;

public class SceneFactory {

    /**
     * Builds the scene for the cave escape.
     * @return a CaveEscapeScene object
     */
    public static Scene buildCaveEscapeScene() {
        return new CaveEscapeScene();
    }

    /**
     * Builds the house and cave scene at the given index.
     * @param index - the index of the scene.
     * @return - the scene for the given index.
     * @throws Exception - if the index is too large (max: 2), then an exception is passed.
     */
    public static Scene buildHouseAndCaveScene(int index) throws Exception {
        Scene scene;
        switch (index) {
            case 0:
                scene = new HouseScene();
                break;
            case 1:
                scene = new HouseOutsideScene();
                break;
            case 2:
                scene = new OutsideCaveScene();
                break;
            default:
                throw new Exception("Not a valid lat-lon for this level");
        }
        return scene;
    }

    /**
     * Builds the house and cave scene at the given index.
     * @param index - the index of the scene.
     * @param listener - the listener for the console scene.
     * @return - the scene for the given index.
     * @throws Exception - if the index is too large (max: 2), then an exception is passed.
     */
    public static Scene buildConsoleEscape(int index, TangibleListener listener) throws Exception {
        Scene scene;
        switch (index) {
            case 0:
                scene = new ConsoleScene(listener);
                break;
            case 1:
                scene = new TwoPathsScene();
                break;
            case 2:
                scene = new HallwayDoorScene();
                break;
            default:
                throw new Exception("Not a valid lat-lon for this level");
        }
        return scene;
    }

    /**
     * Builds the dig escape scene.
     * @return a DigEscapeScene object
     */
    public static Scene buildDigEscape() {
        return new DigEscapeScene();
    }

    /**
     * Builds the monster scene.
     * @return a MonsterScene object
     */
    public static Scene buildMonsterRing() {
        return new MonsterScene();
    }

    /**
     * Builds a test scene.
     * @return a OutsideCaveScene object
     */
    public static Scene buildTestScene() {
        return new OutsideCaveScene();
    }

}
