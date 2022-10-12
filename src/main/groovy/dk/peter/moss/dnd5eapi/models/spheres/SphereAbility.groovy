package dk.peter.moss.dnd5eapi.models.spheres


import dk.peter.moss.dnd5eapi.types.AreaType
import dk.peter.moss.dnd5eapi.types.CastTimeType
import dk.peter.moss.dnd5eapi.types.DurationType
import dk.peter.moss.dnd5eapi.types.RangeType
import dk.peter.moss.dnd5eapi.types.StatType
import dk.peter.moss.dnd5eapi.types.TargetType

class SphereAbility {
    String name
    String description = null

    Boolean concentration = null

    RangeType rangeType = null
    Integer range = null
    Integer cost = null

    CastTimeType castingTime = null
    StatType savingThrow = null

    Map<DurationType, Integer> duration = null
    Tuple2<TargetType, Integer> target = null
    Map<String, SphereAbility> augmentations = null
    Map<AreaType, Integer> area = null

    SphereAbility(String name) {
        this.name = name
    }

    void setDuration(DurationType type, Integer length) {
        this.duration = new HashMap()
        this.duration.put(type, length)
    }

    void setTarget(TargetType type, Integer count) {
        this.target = Tuple.of(type, count)
    }

    void addAugment(SphereAbility ability) {
        if (!this.augmentations) {
            this.augmentations = new HashMap()
        }
        this.augmentations.put(ability.name, ability)
    }

    void removeAugment(String name) {
        if (!this.augmentations) {
            return
        }
        def final augment = this.augmentations.find({ it.key == name })
        this.augmentations.remove(augment)
    }
}
