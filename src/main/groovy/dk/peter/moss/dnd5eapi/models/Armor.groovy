package dk.peter.moss.dnd5eapi.models

import dk.peter.moss.dnd5eapi.types.ArmorType

class Armor {
    Integer base
    Integer dexterityToAdd
    Boolean disadvantageOnStealth
    ArmorType armorType

    Armor(Integer base, Integer dexToAdd, ArmorType type, Boolean disadvantage = false) {
        this.base = base
        this.dexterityToAdd = dexToAdd
        this.armorType = type
        this.disadvantageOnStealth = disadvantage
    }

    Integer calculateArmorClass(Integer dex = 0) {
        return this.base + Math.min(dex, this.dexterityToAdd)
    }
}
