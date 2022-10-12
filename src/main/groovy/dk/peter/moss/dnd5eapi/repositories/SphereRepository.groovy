package dk.peter.moss.dnd5eapi.repositories

import dk.peter.moss.dnd5eapi.models.spheres.MagicSphere

class SphereRepository {
    MagicSphere alterationSphere() {
        def final sphereAbilityRepo = new SphereAbilityRepository()
        def final sphere = new MagicSphere("Alteration")
        sphere.abilities.push(sphereAbilityRepo.shapeshift())
        return sphere
    }
}
