package main.com.adventure.world.objects;

import main.com.adventure.world.objects.keys.Key;

public class HoleContent {
    private String Key(){
        return "";


    };
    private boolean isCovered = true;
    private Key content;
    public HoleContent(Key key) {
        content = key;

    };


    public void setIsCovered(boolean isCovered) {
        this.isCovered = isCovered;

    }

    public boolean isCovered() {
        return this.isCovered;

    }
    public Key getKey(){
        return null;
    }




}
