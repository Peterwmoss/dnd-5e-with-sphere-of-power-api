package dk.peter.moss.dnd5eapi.models.spheres

import dk.peter.moss.dnd5eapi.models.spheres.talents.SphereTalent
import dk.peter.moss.dnd5eapi.types.spheres.SphereTalentType
import dk.peter.moss.dnd5eapi.types.spheres.SphereType

class MagicSphere {
    SphereType name

    List<SphereAbility> abilities
    Map<SphereTalentType, List<SphereTalent>> talents

    MagicSphere(SphereType name, List<SphereAbility> abilities = new ArrayList(), Map<SphereTalentType, List<SphereTalent>> talents = new HashMap()) {
        this.name = name
        this.abilities = abilities
        this.talents = talents
    }
}
