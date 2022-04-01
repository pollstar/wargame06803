package ua.pollstar.softserve;

public class Warrior {
    int health = 50;
    int attack = 5;
    boolean isAlive = true;

    void attackEnemy(Warrior enemy) {
        enemy.health -= attack;
        if(enemy.health < 0) {
            enemy.isAlive = false;
        }
    }
}
