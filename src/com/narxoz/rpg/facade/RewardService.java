package com.narxoz.rpg.facade;

public class RewardService {

    public String determineReward(AdventureResult battleResult) {

        if (battleResult == null) {
            return "No reward";
        }

        if (battleResult.getWinner() == null) {
            return "No reward";
        }

        if (battleResult.getWinner().contains("Hero")) {
            return "Legendary Sword + 500 Gold";
        }

        return "Boss keeps the treasure";
    }
}