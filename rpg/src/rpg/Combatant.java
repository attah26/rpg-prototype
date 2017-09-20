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
public class Combatant {
    
    int HP;
    int strength;
    int defense;
    
    public Combatant(int str, int def)
    {
        strength = str;
        defense = def;
        HP = 100;
    }
    
    public void setHP(int hp)
    {
        HP = hp;
    }
    public int getHP()
    {
        return HP;
    }

}

     
