package dk.peter.moss.dnd5eapi.models.actions

import dk.peter.moss.dnd5eapi.models.dice.Die
import dk.peter.moss.dnd5eapi.models.rolls.AttackRoll
import dk.peter.moss.dnd5eapi.models.rolls.DamageRoll
import dk.peter.moss.dnd5eapi.util.Average
import dk.peter.moss.dnd5eapi.util.HitRate

class AttackAction extends Action {
    AttackRoll attackRoll
    List<DamageRoll> damageRolls

    int range

    AttackAction(String name, AttackRoll attackRoll, List<DamageRoll> damageRolls = [], int range = 5) {
        super(name)
        this.attackRoll = attackRoll
        this.damageRolls = damageRolls
        this.range = range
    }

    private class Damage {
        int rolled
        int modifiers
        int total

        Damage(int rolled, int modifiers) {
            this.rolled = rolled
            this.modifiers = modifiers
            this.total = rolled + modifiers
        }
    }

    private Damage damageRoll() {
        def rolled = 0
        def modifiers = 0
        for (roll in this.damageRolls) {
            for (def i = 0; i < roll.count; i++) {
                rolled += roll.die.roll()
            }
            modifiers += roll.modifier
        }
        return new Damage(rolled, modifiers)
    }

    int toHit() {
        return this.attackRoll.roll()
    }

    int damage() {
        return this.damageRoll().total
    }

    int critical() {
        def final damage = this.damageRoll()
        return damage.rolled * 2 + damage.modifiers
    }

    HitRate hitRate(int AC) {
        return new HitRate(AC, this.attackRoll)
    }

    double averageDamage(int AC) {
        def rolled = 0
        def modifiers = 0
        for (roll in this.damageRolls) {
            rolled += Average.fromDieAndCount(roll.die, roll.count)
            modifiers += roll.modifier
        }
        def total = rolled + modifiers

        def hitRate = this.hitRate(AC)
        def normalDamage = (total * (hitRate.rate - hitRate.criticalSuccess))
        def criticalDamage = ((rolled * 2 + modifiers) * hitRate.criticalSuccess)
        return normalDamage + criticalDamage
    }

    int averageRoll() {
        return Average.fromDieAndCount(new Die.D20(), 1) + this.attackRoll.modifier
    }
}
