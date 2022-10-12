package dk.peter.moss.dnd5eapi.builders.action

import dk.peter.moss.dnd5eapi.models.actions.AttackAction
import dk.peter.moss.dnd5eapi.models.rolls.AttackRoll
import dk.peter.moss.dnd5eapi.models.rolls.DamageRoll

class AttackActionBuilder extends ActionBuilder<AttackAction, AttackActionBuilder> {
    protected AttackRoll attackRoll
    protected List<DamageRoll> damageRolls
    protected int range

    AttackActionBuilder setAttackRoll(AttackRoll attackRoll) {
        this.attackRoll = attackRoll
        return this
    }

    AttackActionBuilder setDamageRolls(List<DamageRoll> damageRolls) {
        this.damageRolls = damageRolls
        return this
    }

    AttackActionBuilder setRange(int range) {
        this.range = range
        return this
    }

    @Override
    AttackAction build() {
        return new AttackAction(
                this.name,
                this.attackRoll,
                this.damageRolls,
                this.range
        )
    }
}
