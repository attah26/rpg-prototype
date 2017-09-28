/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.io.IOException;

/**
 *
 * @author Isaac
 */
public class Rpg {

    /*
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws IOException {
        GameScreen runGame = new GameScreen();
        
        runGame.generateScreen();
    }
    
}
