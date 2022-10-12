package dk.peter.moss.dnd5eapi.controllers

import dk.peter.moss.dnd5eapi.models.spheres.MagicSphere
import dk.peter.moss.dnd5eapi.services.SphereService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SphereController {
    @GetMapping("/spheres/alteration")
    MagicSphere getAlteration() {
        return SphereService.Alteration()
    }
}
