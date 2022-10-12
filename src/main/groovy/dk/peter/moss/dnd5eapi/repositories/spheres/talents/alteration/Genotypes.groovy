package dk.peter.moss.dnd5eapi.repositories.spheres.talents.alteration

import dk.peter.moss.dnd5eapi.models.Movement
import dk.peter.moss.dnd5eapi.models.dice.Die
import dk.peter.moss.dnd5eapi.models.spheres.talents.alteration.GenotypeTalent
import dk.peter.moss.dnd5eapi.types.DamageType
import dk.peter.moss.dnd5eapi.util.FileUtils

class Genotypes {
    protected static final String GENOTYPE_BASE_URI = "./descriptions/spheres/alteration/genotypes"

    static GenotypeTalent animalistic() {
        def final talent = new GenotypeTalent("Animalistic")
        talent.description = FileUtils.readFile(GENOTYPE_BASE_URI + "/animalistic")

        talent.setAC(13)

        talent.addHeads()
        talent.addLegs(4)

        talent.addSpeed(Movement.Walk, 40, 1)
        talent.addSpeed(Movement.Walk, 60, 5)
        talent.addSpeed(Movement.Walk, 80, 11)
        talent.addSpeed(Movement.Walk, 100, 17)

        talent.addNaturalWeapon("Bite", new Die.D6(), DamageType.Piercing)

        talent.special = "The target counts as being of either the beast or monstrosity type (your choice) in addition to its normal type."

        talent.features.put("Overrun", FileUtils.readFile(GENOTYPE_BASE_URI + "/animalistic-overrun"))

        return talent
    }
}
