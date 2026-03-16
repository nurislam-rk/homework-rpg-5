package com.narxoz.rpg;

import com.narxoz.rpg.decorator.*;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.facade.AdventureResult;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.hero.HeroProfile;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Homework 5 Demo: Decorator + Facade ===\n");

        // Create hero and boss
        HeroProfile hero = new HeroProfile("Arthur", 100);
        BossEnemy boss = new BossEnemy("Dragon King", 120, 15);

        // Base attack
        AttackAction basicAttack = new BasicAttack("Sword Strike", 10);

        // Decorated attacks
        AttackAction fireAttack =
                new FireRuneDecorator(basicAttack);

        AttackAction poisonAttack =
                new PoisonCoatingDecorator(basicAttack);

        AttackAction ultimateAttack =
                new FireRuneDecorator(
                        new PoisonCoatingDecorator(
                                new CriticalFocusDecorator(basicAttack)));

        System.out.println("===== DECORATOR DEMO =====\n");

        System.out.println("Base Attack:");
        System.out.println("Name: " + basicAttack.getActionName());
        System.out.println("Damage: " + basicAttack.getDamage());
        System.out.println("Effects: " + basicAttack.getEffectSummary());

        System.out.println("\nFire Decorated Attack:");
        System.out.println("Name: " + fireAttack.getActionName());
        System.out.println("Damage: " + fireAttack.getDamage());
        System.out.println("Effects: " + fireAttack.getEffectSummary());

        System.out.println("\nPoison Decorated Attack:");
        System.out.println("Name: " + poisonAttack.getActionName());
        System.out.println("Damage: " + poisonAttack.getDamage());
        System.out.println("Effects: " + poisonAttack.getEffectSummary());

        System.out.println("\nUltimate Multi-Decorator Attack:");
        System.out.println("Name: " + ultimateAttack.getActionName());
        System.out.println("Damage: " + ultimateAttack.getDamage());
        System.out.println("Effects: " + ultimateAttack.getEffectSummary());

        // Facade demo
        System.out.println("\n===== FACADE DEMO =====");

        DungeonFacade facade = new DungeonFacade().setRandomSeed(42);

        AdventureResult result = facade.runAdventure(hero, boss, ultimateAttack);

        System.out.println("\nAdventure Result:");
        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());
        System.out.println("Reward: " + result.getReward());

        System.out.println("\nBattle Log:");
        for (String line : result.getLog()) {
            System.out.println(line);
        }

        System.out.println("\n=== Demo Complete ===");
    }
}