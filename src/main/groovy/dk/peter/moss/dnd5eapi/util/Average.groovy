package dk.peter.moss.dnd5eapi.util

import dk.peter.moss.dnd5eapi.models.dice.Die

class Average {
    static float fromDieAndCount(Die die, int count) {
        return (die.sides + 1) * count / 2
    }
}
