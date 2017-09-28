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

public class GameScreen implements ActionListener {

    BattleSystem combat = new BattleSystem();

    ImageIcon characterPic = getIcon("Character.jpg");
    ImageIcon enemyPic = getIcon("Monster.jpg");

    Combatant player = new Combatant(10, 5);
    Combatant enemy = new Combatant(10, 0);

    String gameName = "Title";
    String battleText = "";


    GridLayout screenLayout = new GridLayout(2, 2);
    GridLayout menuLayout = new GridLayout(0, 1);
    GridLayout detailsLayout = new GridLayout(2, 1);

    JFrame screen = new JFrame(gameName);
    JPanel gameStart = new JPanel();
    JPanel battleScreen = new JPanel();
    JPanel battleMenu = new JPanel();
    JPanel battleDetails = new JPanel();


    JLabel charIcon = new JLabel(characterPic);
    JLabel enemyIcon = new JLabel(enemyPic);
    JLabel statScreen = new JLabel();
    JTextArea battleUpdateScreen = new JTextArea();

    JButton start = new JButton("Start Game");

    JButton attack = new JButton("Attack");
    JButton skills = new JButton("Skills & Magic");
    JButton defend = new JButton("Defend");
    JButton items = new JButton("Items");


    public GameScreen() throws IOException {

    }

    public void generateScreen() {

        start.addActionListener(this);
        attack.addActionListener(this);
        skills.addActionListener(this);
        defend.addActionListener(this);
        items.addActionListener(this);

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

    @Override
    public void actionPerformed(ActionEvent event) {

        String action = event.getActionCommand();

        if (action.equals("Start Game")) {
            gameStart.setVisible(false);
            screen.remove(gameStart);
            screen.add(battleScreen);


        } else if (action.equals("Attack")) {

            battleText += combat.attack(player, enemy) + "\n";

            battleUpdateScreen.setText(battleText);
            battleUpdateScreen.repaint();
        } else if (action.equals("Skills & Magic")) {

        } else if (action.equals("Defend")) {

        } else if (action.equals("Items")) {

        }


        screen.repaint();


    }

    private ImageIcon getIcon(final String picName) throws IOException {
        InputStream iconStream = getIconStream(picName);
        return new ImageIcon(ImageIO.read(iconStream));
    }

    private InputStream getIconStream(final String picName) {
        return getClass().getResourceAsStream("/resources/icons/" + picName);
    }
}
