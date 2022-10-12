package dk.peter.moss.dnd5eapi.models.rolls

import dk.peter.moss.dnd5eapi.models.dice.Die

class DamageRoll {
    Die die
    int count
    int modifier

    DamageRoll(Die die, int count, int modifier = 0) {
        this.die = die
        this.count = count
        this.modifier = modifier
    }

}