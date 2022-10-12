package dk.peter.moss.dnd5eapi.services

import dk.peter.moss.dnd5eapi.models.spheres.MagicSphere
import dk.peter.moss.dnd5eapi.repositories.SphereRepository

class SphereService {
    static SphereRepository repository = new SphereRepository()
    static MagicSphere Alteration() {
        return repository.alterationSphere()
    }
}
