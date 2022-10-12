package dk.peter.moss.dnd5eapi.models.spheres

class MagicSphere {
    String name

    List<SphereAbility> abilities = new ArrayList()
    List<SphereTalentGroup> talents = new ArrayList()

    MagicSphere(String name) {
        this.name = name
    }
}
