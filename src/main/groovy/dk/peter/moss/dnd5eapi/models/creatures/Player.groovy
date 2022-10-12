package dk.peter.moss.dnd5eapi.models.creatures

import dk.peter.moss.dnd5eapi.types.SkillType

class Player extends Creature {
    Map<SkillType, Integer> skills = new HashMap()
    Map<SkillType, Boolean> proficiencies = new HashMap()
}
