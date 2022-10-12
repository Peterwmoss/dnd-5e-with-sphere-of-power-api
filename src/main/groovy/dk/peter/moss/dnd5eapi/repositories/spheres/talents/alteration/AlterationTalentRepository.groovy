package dk.peter.moss.dnd5eapi.repositories.spheres.talents.alteration

import dk.peter.moss.dnd5eapi.interfaces.Repository
import dk.peter.moss.dnd5eapi.models.spheres.talents.alteration.AlterationTalent
import dk.peter.moss.dnd5eapi.types.spheres.SphereTalentType

class AlterationTalentRepository implements Repository<SphereTalentType, List<AlterationTalent>> {
    final Map<SphereTalentType, List<AlterationTalent>> db = new HashMap()

    AlterationTalentRepository() {
        db.put(SphereTalentType.Genotype, [Genotypes.animalistic()])
    }

    @Override
    List<AlterationTalent> get(SphereTalentType identifier) {
        return db.get(identifier)
    }

    @Override
    Map<SphereTalentType, List<AlterationTalent>> getAll() {
        return db
    }
}
