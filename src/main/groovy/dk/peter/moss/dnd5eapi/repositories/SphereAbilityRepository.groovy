package dk.peter.moss.dnd5eapi.repositories

import dk.peter.moss.dnd5eapi.models.spheres.SphereAbility
import dk.peter.moss.dnd5eapi.types.CastTimeType
import dk.peter.moss.dnd5eapi.types.DurationType
import dk.peter.moss.dnd5eapi.types.RangeType
import dk.peter.moss.dnd5eapi.types.StatType
import dk.peter.moss.dnd5eapi.types.TargetType

class SphereAbilityRepository extends Repository {
    final static String DESCRIPTION_BASE_URI = "./descriptions/spheres/abilities"
    SphereAbility shapeshift() {
        def final ability = new SphereAbility("Shapeshift")
        ability.castingTime = CastTimeType.Action
        ability.rangeType = RangeType.Touch
        ability.setDuration(DurationType.Minutes, 10)
        ability.concentration = true
        ability.setTarget(TargetType.WillingCreature, 1)
        ability.savingThrow = StatType.Constitution
        ability.cost = 0
        ability.description = this.readFile(DESCRIPTION_BASE_URI + "/shapeshift/index")

        def final augment1 = new SphereAbility("Augment 1")
        augment1.cost = 1
        augment1.setTarget(TargetType.Creature, 1)
        augment1.description = this.readFile(DESCRIPTION_BASE_URI + "/shapeshift/augments/1")
        ability.addAugment(augment1)

        def final augment2 = new SphereAbility("Augment 2")
        augment2.cost = 2
        augment2.concentration = false
        augment2.description = this.readFile(DESCRIPTION_BASE_URI + "/shapeshift/augments/2")
        ability.addAugment(augment2)

        return ability
    }
}
