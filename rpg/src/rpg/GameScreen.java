/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

/**
 * @author Isaac
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.InputStream;
import java.io.IOException;

public class GameScreen {

    final BattleSystem combat = new BattleSystem();

    final ImageIcon characterPic = getIcon("Character.jpg");
    final ImageIcon enemyPic = getIcon("Monster.jpg");

    final Combatant player = new Combatant(10, 5);
    final Combatant enemy = new Combatant(10, 0);

    final String gameName = "Title";
    String battleText = "";


    final GridLayout screenLayout = new GridLayout(2, 2);
    final GridLayout menuLayout = new GridLayout(0, 1);
    final GridLayout detailsLayout = new GridLayout(2, 1);

    final JFrame screen = new JFrame(gameName);
    final JPanel gameStart = new JPanel();
    final JPanel battleScreen = new JPanel();
    final JPanel battleMenu = new JPanel();
    final JPanel battleDetails = new JPanel();


    final JLabel charIcon = new JLabel(characterPic);
    final JLabel enemyIcon = new JLabel(enemyPic);
    final JLabel statScreen = new JLabel();
    final JTextArea battleUpdateScreen = new JTextArea();

    final JButton start = new JButton("Start Game");

    final JButton attack = new JButton("Attack");
    final JButton skills = new JButton("Skills & Magic");
    final JButton defend = new JButton("Defend");
    final JButton items = new JButton("Items");


    public GameScreen() throws IOException {

    }

    abstract class GameScreenActionListener implements ActionListener {
        @Override
        public void actionPerformed(final ActionEvent event) {
            handleEvent(event);
            screen.repaint();
        }

        public abstract void handleEvent(final ActionEvent event);
    }

    final ActionListener startListener = new GameScreenActionListener() {
        @Override
        public void handleEvent(final ActionEvent event) {
            gameStart.setVisible(false);
            screen.remove(gameStart);
            screen.add(battleScreen);
        }
    };

    final ActionListener attackListener = new GameScreenActionListener() {
        @Override
        public void handleEvent(final ActionEvent event) {
            battleText += combat.attack(player, enemy) + "\n";

            battleUpdateScreen.setText(battleText);
            battleUpdateScreen.repaint();
        }
    };

    final ActionListener skillsMagicListener = new GameScreenActionListener() {
        @Override
        public void handleEvent(final ActionEvent event) {
        }
    };

    final ActionListener defendListener = new GameScreenActionListener() {
        @Override
        public void handleEvent(final ActionEvent event) {
        }
    };

    final ActionListener itemsListener = new GameScreenActionListener() {
        @Override
        public void handleEvent(final ActionEvent event) {
        }
    };

    public void generateScreen() {

        start.addActionListener(startListener);
        attack.addActionListener(attackListener);
        skills.addActionListener(skillsMagicListener);
        defend.addActionListener(defendListener);
        items.addActionListener(itemsListener);

        gameStart.add(start);

        segmentLayouts();
        screenSegments();
        addButtons();
        initializeScreenAndRunGame();
    }

    private void initializeScreenAndRunGame() {
        screen.add(gameStart);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setSize(1000, 800);
        screen.setVisible(true);
    }

    private void addButtons() {
        battleMenu.add(attack);
        battleMenu.add(skills);
        battleMenu.add(defend);
        battleMenu.add(items);

        battleDetails.add(statScreen);
        battleDetails.add(battleUpdateScreen);
    }

    private void screenSegments() {
        battleScreen.add(charIcon);
        battleScreen.add(enemyIcon);
        battleScreen.add(battleMenu);
        battleScreen.add(battleDetails);
    }

    private void segmentLayouts() {
        battleScreen.setLayout(screenLayout);
        battleMenu.setLayout(menuLayout);
        battleDetails.setLayout(detailsLayout);
    }


    private ImageIcon getIcon(final String picName) throws IOException {
        final InputStream iconStream = getIconStream(picName);
        return new ImageIcon(ImageIO.read(iconStream));
    }

    private InputStream getIconStream(final String picName) {
        return getClass().getResourceAsStream("/resources/icons/" + picName);
    }
}
