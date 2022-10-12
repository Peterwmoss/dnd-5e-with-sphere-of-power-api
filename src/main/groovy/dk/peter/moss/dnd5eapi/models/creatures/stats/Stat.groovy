package dk.peter.moss.dnd5eapi.models.creatures.stats

class Stat {
    int score
    int modifier

    Stat(int score, int modifier) {
        this.score = score
        this.modifier = modifier
    }
}