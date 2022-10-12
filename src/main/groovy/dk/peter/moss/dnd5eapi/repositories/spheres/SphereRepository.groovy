package dk.peter.moss.dnd5eapi.repositories.spheres

import dk.peter.moss.dnd5eapi.interfaces.Repository
import dk.peter.moss.dnd5eapi.models.spheres.MagicSphere
import dk.peter.moss.dnd5eapi.repositories.spheres.abilities.SphereAbilityRepository
import dk.peter.moss.dnd5eapi.repositories.spheres.talents.SphereTalentRepository
import dk.peter.moss.dnd5eapi.types.spheres.SphereType

class SphereRepository implements Repository<SphereType, MagicSphere> {
    def final static sphereAbilityRepo = new SphereAbilityRepository()
    def final static sphereTalentRepository = new SphereTalentRepository()

    def final db = new HashMap<SphereType, MagicSphere>()

    SphereRepository() {
        db.put(SphereType.Alteration, alterationSphere())
    }

    private static MagicSphere alterationSphere() {
        return new MagicSphere(
                SphereType.Alteration,
                sphereAbilityRepo.get(SphereType.Alteration),
                sphereTalentRepository.get(SphereType.Alteration)
        )
    }

    @Override
    MagicSphere get(SphereType identifier) {
        return db.get(identifier)
    }

    @Override
    Map<SphereType, MagicSphere> getAll() {
        return db
    }
}
