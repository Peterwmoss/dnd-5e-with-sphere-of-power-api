package dk.peter.moss.dnd5eapi.builders.action

import dk.peter.moss.dnd5eapi.interfaces.Builder
import dk.peter.moss.dnd5eapi.models.actions.Action

abstract class ActionBuilder<T extends Action, Q extends Builder<T>> implements Builder<T> {
    protected String name

    Q setName(String name) {
        this.name = name
        return this
    }
}
