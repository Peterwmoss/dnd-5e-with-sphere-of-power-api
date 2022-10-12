package dk.peter.moss.dnd5eapi.builders.creature

import dk.peter.moss.dnd5eapi.models.creatures.Player
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class PlayerBuilder extends CreatureBuilder<Player, PlayerBuilder> {
    PlayerBuilder() {
        this.creature = new Player()
    }

    @Override
    boolean verify() {
        super.verify()
        if (this.creature.skills.size() == 0) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Player must have skill values")
        }
    }

    @Override
    Player build() {
        this.verify()
        return this.creature
    }
}
