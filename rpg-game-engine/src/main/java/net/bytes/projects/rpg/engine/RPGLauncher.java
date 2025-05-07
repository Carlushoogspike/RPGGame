package net.bytes.projects.rpg.engine;

import net.bytes.projects.rpg.engine.manager.EventManager;
import net.bytes.projects.rpg.engine.listener.PlayerMovementListener;
import net.bytes.projects.rpg.engine.windows.GameWindow;

public class RPGLauncher {

    public static void main(String[] args) {
        try {
            GameWindow window = new GameWindow();

            PlayerMovementListener movementListener = new PlayerMovementListener();
            EventManager.registerListener(movementListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
