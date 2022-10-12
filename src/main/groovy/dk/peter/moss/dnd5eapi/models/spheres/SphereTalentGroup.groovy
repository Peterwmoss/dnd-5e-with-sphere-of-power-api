package dk.peter.moss.dnd5eapi.models.spheres

class SphereTalentGroup {
    String name
    List<SphereTalent> talents

    SphereTalentGroup(String name, List<SphereTalent> talents = new ArrayList()) {
        this.name = name
        this.talents = talents
    }

    void addTalent(SphereTalent talent) {
        this.talents.push(talent)
    }

    SphereTalent removeTalent(String name) {
        def idx = this.talents.findIndexOf {it.name == name }
        return this.talents.remove(idx)
    }
}
