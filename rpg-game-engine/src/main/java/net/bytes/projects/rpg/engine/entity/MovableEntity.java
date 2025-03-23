package net.bytes.projects.rpg.engine.entity;

import java.awt.event.KeyListener;

public interface MovableEntity extends KeyListener {

    void onUp();

    void onDown();

    void onLeft();

    void onRight();

    void onAction();

}
