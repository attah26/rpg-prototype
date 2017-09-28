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
public class BattleSystem {
    
    int damage;
    
    public String attack(Combatant player1, Combatant enemy1)
    {
        damage = player1.strength - enemy1.defense;
        enemy1.setHP(enemy1.getHP() - damage);
             
        String outcome = "User dealt "+damage+" damage!!! \n"+"Enemy has: "+enemy1.getHP()+"HP remaining." ;
        
        return outcome;
    }
    
}
