package dk.peter.moss.dnd5eapi.repositories.spheres.abilities

import dk.peter.moss.dnd5eapi.models.spheres.SphereAbility
import dk.peter.moss.dnd5eapi.interfaces.Repository
import dk.peter.moss.dnd5eapi.types.CastTimeType
import dk.peter.moss.dnd5eapi.types.DurationType
import dk.peter.moss.dnd5eapi.types.RangeType
import dk.peter.moss.dnd5eapi.types.spheres.SphereType
import dk.peter.moss.dnd5eapi.types.StatType
import dk.peter.moss.dnd5eapi.types.TargetType
import dk.peter.moss.dnd5eapi.util.FileUtils

class SphereAbilityRepository implements Repository<SphereType, List<SphereAbility>> {
    final static String DESCRIPTION_BASE_URI = "./descriptions/spheres"

    def final db = new HashMap<SphereType, List<SphereAbility>>()

    SphereAbilityRepository() {
        db.put(SphereType.Alteration, [shapeshift()])
    }

    private static SphereAbility shapeshift() {
        def final ability = new SphereAbility("Shapeshift")
        ability.castingTime = CastTimeType.Action
        ability.rangeType = RangeType.Touch
        ability.setDuration(DurationType.Minutes, 10)
        ability.concentration = true
        ability.setTarget(TargetType.WillingCreature, 1)
        ability.savingThrow = StatType.Constitution
        ability.cost = 0
        ability.description = FileUtils.readFile(DESCRIPTION_BASE_URI + "/alteration/abilities/shapeshift/index")

        def final augment1 = new SphereAbility("Augment 1")
        augment1.cost = 1
        augment1.setTarget(TargetType.Creature, 1)
        augment1.description = FileUtils.readFile(DESCRIPTION_BASE_URI + "/alteration/abilities/shapeshift/augments/1")
        ability.addAugment(augment1)

        def final augment2 = new SphereAbility("Augment 2")
        augment2.cost = 2
        augment2.concentration = false
        augment2.description = FileUtils.readFile(DESCRIPTION_BASE_URI + "/alteration/abilities/shapeshift/augments/2")
        ability.addAugment(augment2)

        return ability
    }

    @Override
    List<SphereAbility> get(SphereType identifier) {
        return db.get(identifier)
    }

    @Override
    Map<SphereType, List<SphereAbility>> getAll() {
        return db
    }
}
