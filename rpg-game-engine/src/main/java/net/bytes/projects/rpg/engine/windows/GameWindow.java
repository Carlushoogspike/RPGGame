package net.bytes.projects.rpg.engine.windows;

import net.bytes.projects.rpg.engine.entity.PlayerEntity;

import javax.swing.*;
import java.io.IOException;

public class GameWindow extends JFrame {

    public GameWindow() throws IOException {
        setTitle("RPG Game");
        setSize(512, 512);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setLayout(null);

        PlayerEntity player = new PlayerEntity();
        getContentPane().add(player);

        setFocusable(true);
        addKeyListener(player);

        setVisible(true);
    }

}
