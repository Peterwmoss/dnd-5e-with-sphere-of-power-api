package dk.peter.moss.dnd5eapi.util

class Modifiers {
    static int attributeModifier(int score) {
        def final baseline = 10
        return Math.floor((score - baseline) / 2)
    }

    static int proficiencyModifier(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level must be at least 1")
        }
        def final baseline = 2
        return Math.floor((level - 1) / 4) + baseline
    }
}
