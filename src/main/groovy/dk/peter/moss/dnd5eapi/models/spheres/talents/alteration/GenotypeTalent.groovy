package dk.peter.moss.dnd5eapi.models.spheres.talents.alteration

import dk.peter.moss.dnd5eapi.models.Armor
import dk.peter.moss.dnd5eapi.models.Movement
import dk.peter.moss.dnd5eapi.models.dice.Die
import dk.peter.moss.dnd5eapi.types.DamageType

import java.util.function.BiFunction

class GenotypeTalent extends AlterationTalent {
    String special
    Map<String, String> features = new HashMap()
    BiFunction<Integer, Integer, Integer> armorClass

    Map<Limbs, Integer> limbs = new HashMap()
    Map<Integer, Map<Movement, Integer>> speed = new HashMap()
    Map<String, Tuple2<Die, DamageType>> naturalWeapons = new HashMap()

    GenotypeTalent(String name) {
        super(name)
    }

    void setAC(Integer base, Boolean allowArmor = false) {
        this.armorClass = (Integer dex, Armor armor) -> {
            if (allowArmor) {
                return armor.calculateArmorClass(dex)
            }
            return base + dex
        }
    }

    void addSpeed(Movement movement, Integer speed, Integer level = 1) {
        def final current = this.speed.get(level)
        if (current) {
            current.put(movement, speed)
        } else {
            this.speed.put(level, new HashMap())
            this.speed.get(level).put(movement, speed)
        }
    }

    void addNaturalWeapon(String name, Die die, DamageType damageType) {
        def tuple = Tuple.tuple(die, damageType)
        this.naturalWeapons.put(name, tuple)
    }

    void addHeads(Integer count = 1) { this.limbs.put(Limbs.Head, count) }
    void addLegs(Integer count = 1) { this.limbs.put(Limbs.Leg, count) }
    void addArms(Integer count = 1) { this.limbs.put(Limbs.Arm, count) }
    void addFins(Integer count = 1) { this.limbs.put(Limbs.Fin, count) }
    void addTails(Integer count = 1) { this.limbs.put(Limbs.Tail, count) }
    void addWings(Integer count = 1) { this.limbs.put(Limbs.Wing, count) }

    private enum Limbs {
        Head,
        Leg,
        Arm,
        Fin,
        Tail,
        Wing,
    }

}
