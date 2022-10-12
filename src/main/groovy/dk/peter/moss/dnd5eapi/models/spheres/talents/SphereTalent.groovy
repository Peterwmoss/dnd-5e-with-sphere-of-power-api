package dk.peter.moss.dnd5eapi.models.spheres.talents

abstract class SphereTalent {
    String name
    String description

    SphereTalent(String name) {
        this.name = name
    }
}
