package net.bytes.projects.rpg.engine;

import net.bytes.projects.rpg.engine.entity.PlayerEntity;
import net.bytes.projects.rpg.engine.windows.GameWindow;

public class RPGLauncher {

    public static void main(String[] args) {
        try {
            GameWindow window = new GameWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
