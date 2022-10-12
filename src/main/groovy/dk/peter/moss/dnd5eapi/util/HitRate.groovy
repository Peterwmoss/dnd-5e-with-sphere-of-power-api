package dk.peter.moss.dnd5eapi.util

import dk.peter.moss.dnd5eapi.models.rolls.AttackRoll

class HitRate {
    float rate
    float criticalFailure
    float criticalSuccess

    private int advantageProbability(int roll) {
        return (2 * roll - 1) / 400
    }

    private int disadvantageProbability(int roll) {
        return (41 - 2 * roll) / 400
    }

    HitRate(int AC, AttackRoll roll) {
        def dc = AC - roll.modifier - 1

        dc = dc <= 0 ? 1 : dc

        if (roll.advantage) {
            this.rate = 1 - Math.pow(dc, 2) / 400
            this.criticalFailure = advantageProbability(1)
            this.criticalSuccess = advantageProbability(20)
        } else if (roll.disadvantage) {
            this.rate = Math.pow(1 - 0.05 * dc, 2)
            this.criticalFailure = disadvantageProbability(1)
            this.criticalSuccess = disadvantageProbability(20)
        } else {
            this.rate = 1 - 0.05 * dc
            this.criticalFailure = 0.05
            this.criticalSuccess = 0.05
        }
    }
}
