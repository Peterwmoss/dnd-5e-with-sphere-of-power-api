package dk.peter.moss.dnd5eapi.controllers

import dk.peter.moss.dnd5eapi.builders.creature.PlayerBuilder
import dk.peter.moss.dnd5eapi.models.creatures.Creature
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CreatureController {
    @GetMapping("/creatures/player")
    Creature getPlayer() {
        return new PlayerBuilder().build()
    }
}
