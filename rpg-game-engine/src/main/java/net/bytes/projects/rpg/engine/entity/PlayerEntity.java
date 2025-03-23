package net.bytes.projects.rpg.engine.entity;

import net.bytes.projects.rpg.engine.utils.ImageUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class PlayerEntity extends JLabel implements MovableEntity {

    private final ImageIcon originalIcon;
    private final BufferedImage copyIcon;

    public PlayerEntity() throws IOException {
        URL imageURL = Objects.requireNonNull(getClass().getResource("/art/base.png"));
        this.copyIcon = ImageIO.read(imageURL);

        this.originalIcon = new ImageIcon(imageURL);
        setSize(originalIcon.getIconWidth(), originalIcon.getIconHeight());
        setLocation(0, 0);
        setIcon(originalIcon);

    }

    @Override
    public void onUp() {
        System.out.println("Subindo");
        calculateLocation(Pos.UP);
    }

    @Override
    public void onDown() {
        System.out.println("Descendo");
        calculateLocation(Pos.DOWN);
    }

    @Override
    public void onLeft() {
        System.out.println("Esquerda");
        calculateLocation(Pos.LEFT);
        var result = ImageUtils.flipImageHorizontal(copyIcon, ImageUtils.ImageRotate.FLIP_HORIZONTAL_LEFT);
        setIcon(new ImageIcon(result));
    }

    @Override
    public void onRight() {
        System.out.println("Direita");
        calculateLocation(Pos.RIGHT);
        var result = ImageUtils.flipImageHorizontal(copyIcon, ImageUtils.ImageRotate.FLIP_HORIZONTAL_RIGHT);
        setIcon(new ImageIcon(result));
    }

    @Override
    public void onAction() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            onUp();
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            onDown();
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            onLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            onRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void calculateLocation(Pos pos) {
        switch (pos) {
            case UP:
                setLocation(getX(), getY() - 5);
                break;
            case DOWN:
                setLocation(getX(), getY() + 5);
                break;
            case LEFT:
                setLocation(getX() - 5, getY());
                break;
            case RIGHT:
                setLocation(getX() + 5, getY());
                break;
        }
    }


    private enum Pos {
        UP, DOWN, LEFT, RIGHT
    }
}
