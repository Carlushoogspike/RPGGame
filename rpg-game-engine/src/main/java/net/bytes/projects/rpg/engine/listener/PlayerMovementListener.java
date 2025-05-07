package net.bytes.projects.rpg.engine.listener;

import net.bytes.projects.rpg.engine.event.PlayerMoveEvent;
import net.bytes.projects.rpg.engine.manager.EventRegistry;
import net.bytes.projects.rpg.engine.manager.Listener;

public class PlayerMovementListener implements Listener {

    @EventRegistry
    public void onPlayerMove(PlayerMoveEvent event) {
        System.out.println("O jogador se moveu de (" + event.getOldX() + ", " + event.getOldY() + ") para (" + event.getNewX() + ", " + event.getNewY() + ")");
    }
}
