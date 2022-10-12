package dk.peter.moss.dnd5eapi.models.rolls

abstract class DefaultRoll {
    int modifier
    boolean advantage
    boolean disadvantage

    DefaultRoll(int modifier, boolean advantage = false, boolean disadvantage = false) {
        this.modifier = modifier
        this.advantage = advantage
        this.disadvantage = disadvantage
    }

    int roll() {
        return 1 + Math.floor(Math.random() * 20) + this.modifier
    }
}