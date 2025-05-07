package net.bytes.projects.rpg.engine.entity;

import net.bytes.projects.rpg.engine.world.WorldPosition;

import java.awt.event.KeyListener;

public interface MovableEntity extends KeyListener {

    void onUp();

    void onDown();

    void onLeft();

    void onRight();

    WorldPosition getPosition();
}
