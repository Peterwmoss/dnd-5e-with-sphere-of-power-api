package dk.peter.moss.dnd5eapi.builders.creature

import dk.peter.moss.dnd5eapi.interfaces.Builder
import dk.peter.moss.dnd5eapi.models.creatures.Creature
import dk.peter.moss.dnd5eapi.types.StatType
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

abstract class CreatureBuilder<T extends Creature, Q extends Builder<T>> implements Builder<T> {
    protected T creature

    boolean verify() {
        if (this.creature.stats.size() < StatType.values().length) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Creature must have all stats defined")
        }
    }
}
