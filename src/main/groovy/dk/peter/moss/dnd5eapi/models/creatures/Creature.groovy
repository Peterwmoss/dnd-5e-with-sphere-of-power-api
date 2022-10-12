package dk.peter.moss.dnd5eapi.models.creatures

import dk.peter.moss.dnd5eapi.types.DamageType
import dk.peter.moss.dnd5eapi.models.Movement
import dk.peter.moss.dnd5eapi.models.actions.Action
import dk.peter.moss.dnd5eapi.models.creatures.stats.Stat
import dk.peter.moss.dnd5eapi.types.StatType

abstract class Creature {
    Map<StatType, Stat> stats = new HashMap()

    List<Action> actions = new ArrayList()
    List<Action> bonusActions = new ArrayList()
    List<Action> reactions = new ArrayList()

    List<DamageType> resistances = new ArrayList()
    List<DamageType> vulnerabilities = new ArrayList()
    List<DamageType> immunities = new ArrayList()

    int hitPoints = 0
    int maxHitPoints = 0
    int armorClass = 0

    Map<Movement, Integer> movement = new HashMap()
}
