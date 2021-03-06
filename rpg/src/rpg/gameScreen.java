/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

/**
 *
 * @author Isaac
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class gameScreen implements ActionListener {
    
    battleSystem combat = new battleSystem();
    
    ImageIcon characterPic = new ImageIcon("C:\\Users\\Isaac\\Desktop\\character.jpg");
    ImageIcon enemyPic = new ImageIcon("C:\\Users\\Isaac\\Desktop\\Monster.jpg");
    
    Combatant player = new Combatant(10, 5);
    Combatant enemy = new Combatant(10, 0);
    
    String gameName = "Title";
    String battleText = "";
    
    
    GridLayout screenLayout = new GridLayout(2, 2);
    GridLayout menuLayout = new GridLayout(0, 1);
    GridLayout detailsLayout = new GridLayout(2,1);
    
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
    
    
    
    
    
    
    
    public void generateScreen()
    {
        
        start.addActionListener(this);
        attack.addActionListener(this);
        skills.addActionListener(this);
        defend.addActionListener(this);
        items.addActionListener(this);
        
        gameStart.add(start);
        
        //segment layouts
        
        battleScreen.setLayout(screenLayout);
        battleMenu.setLayout(menuLayout);
        battleDetails.setLayout(detailsLayout);
        
        
        // screen segements
        
        battleScreen.add(charIcon);
        battleScreen.add(enemyIcon);
        battleScreen.add(battleMenu);
        battleScreen.add(battleDetails);
        
        
        // buttons
        
        battleMenu.add(attack);
        battleMenu.add(skills);
        battleMenu.add(defend);
        battleMenu.add(items);
        
        battleDetails.add(statScreen);
        battleDetails.add(battleUpdateScreen);
        
        /*
            Game Dimensions
        */
       
        screen.add(gameStart);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setSize(1000, 800);
        screen.setVisible(true);
                
        
        
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String action = e.getActionCommand();
        
        if(action.equals("Start Game"))
        {
            gameStart.setVisible(false);
            screen.remove(gameStart);
            screen.add(battleScreen);
            
            
            
        }
        else if(action.equals("Attack"))
        {
            
            battleText += combat.attack(player, enemy)+"\n";
            
            battleUpdateScreen.setText(battleText);
            battleUpdateScreen.repaint();
        }
        else if(action.equals("Skills & Magic"))
        {
            
        }
        else if(action.equals("Defend"))
        {
            
        }
        else if(action.equals("Items"))
        {
            
        }
        
        
        screen.repaint();
        
        
        
        
    }
    

    

    
}
