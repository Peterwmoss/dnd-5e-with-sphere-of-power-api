package dk.peter.moss.dnd5eapi.controllers

import dk.peter.moss.dnd5eapi.builders.action.AttackActionBuilder

import dk.peter.moss.dnd5eapi.models.dice.Die
import dk.peter.moss.dnd5eapi.models.rolls.AttackRoll
import dk.peter.moss.dnd5eapi.models.actions.AttackAction
import dk.peter.moss.dnd5eapi.models.rolls.DamageRoll
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ActionController {
    @GetMapping("/actions")
    AttackAction attackAction() {
        final var builder =
                new AttackActionBuilder()
                .setName("Lort")
                .setRange(5)
                .setAttackRoll(new AttackRoll(5))
                .setDamageRolls([
                        new DamageRoll(new Die.D4(), 1, 4)
                ])
        return builder.build()
    }

    @GetMapping("/actions/damage")
    int damage() {
        final var builder =
                new AttackActionBuilder()
                        .setName("Lort")
                        .setRange(5)
                        .setAttackRoll(new AttackRoll(5))
                        .setDamageRolls([
                                new DamageRoll(new Die.D4(), 1, 4)
                        ])
        return builder.build().damage()
    }

    @GetMapping("/actions/average-damage")
    int averageDamage(@RequestParam int AC) {
        final var builder =
                new AttackActionBuilder()
                        .setName("Lort")
                        .setRange(5)
                        .setAttackRoll(new AttackRoll(5))
                        .setDamageRolls([
                                new DamageRoll(new Die.D4(), 1, 4)
                        ])
        return builder.build().averageDamage(AC)
    }
}
