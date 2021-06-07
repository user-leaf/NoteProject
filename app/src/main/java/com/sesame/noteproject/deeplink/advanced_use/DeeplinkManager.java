package com.sesame.noteproject.deeplink.advanced_use;

public class DeeplinkManager {

    private static volatile DeeplinkManager singleton;

    private DeeplinkManager() {
        init();
    }

    public static DeeplinkManager getInstance() {
        if (singleton == null) {
            synchronized (DeeplinkManager.class) {
                if (singleton == null) {
                    singleton = new DeeplinkManager();
                }
            }
        }
        return singleton;
    }

    private void init() {

    }

}