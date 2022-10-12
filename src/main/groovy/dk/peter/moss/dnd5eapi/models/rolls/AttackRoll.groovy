package dk.peter.moss.dnd5eapi.models.rolls

class AttackRoll extends DefaultRoll {
    AttackRoll(int modifier, boolean advantage = false, boolean disadvantage = false) {
        super(modifier, advantage, disadvantage)
    }
}