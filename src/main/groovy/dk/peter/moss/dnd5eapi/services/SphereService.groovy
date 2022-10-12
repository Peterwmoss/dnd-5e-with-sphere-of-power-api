package dk.peter.moss.dnd5eapi.services

import dk.peter.moss.dnd5eapi.models.spheres.MagicSphere
import dk.peter.moss.dnd5eapi.repositories.spheres.SphereRepository
import dk.peter.moss.dnd5eapi.types.spheres.SphereType

class SphereService {
    def static final repository = new SphereRepository()

    static MagicSphere Alteration() {
        return repository.get(SphereType.Alteration)
    }
}
