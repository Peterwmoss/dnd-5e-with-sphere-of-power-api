package dk.peter.moss.dnd5eapi.repositories.spheres.talents

import dk.peter.moss.dnd5eapi.models.spheres.talents.SphereTalent
import dk.peter.moss.dnd5eapi.interfaces.Repository
import dk.peter.moss.dnd5eapi.repositories.spheres.talents.alteration.AlterationTalentRepository
import dk.peter.moss.dnd5eapi.types.spheres.SphereTalentType
import dk.peter.moss.dnd5eapi.types.spheres.SphereType

class SphereTalentRepository implements Repository<SphereType, Map<SphereTalentType, List<SphereTalent>>> {
    final Map<SphereType, Map<SphereTalentType, List<SphereTalent>>> db = new HashMap()

    SphereTalentRepository() {
        def final alterationTalentRepository = new AlterationTalentRepository()
        db.put(SphereType.Alteration, alterationTalentRepository.getAll())
    }

    @Override
    Map<SphereTalentType, List<SphereTalent>> get(SphereType identifier) {
        return db.get(identifier)
    }

    @Override
    Map<SphereType, Map<SphereTalentType, SphereTalent>> getAll() {
        return db
    }
}
