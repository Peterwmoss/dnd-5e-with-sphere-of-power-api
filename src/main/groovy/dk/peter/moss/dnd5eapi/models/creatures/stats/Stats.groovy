package dk.peter.moss.dnd5eapi.models.creatures.stats

import dk.peter.moss.dnd5eapi.types.StatType
import dk.peter.moss.dnd5eapi.util.Modifiers

class Stats {
    static Map<StatType, Stat> generate(Map<StatType, Integer> scores) {
        def final map = new HashMap<StatType, Stat>()
        for (type in StatType.class.getEnumConstants()) {
            def final score = scores[type.name()]
            map[type] = new Stat(score, Modifiers.attributeModifier(score))
        }
        return map
    }
}
