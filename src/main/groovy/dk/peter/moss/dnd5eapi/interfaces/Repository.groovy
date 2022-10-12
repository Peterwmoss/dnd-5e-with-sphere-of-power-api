package dk.peter.moss.dnd5eapi.interfaces

interface Repository<I, R> {
    R get(I identifier)
    Map<I, R> getAll()
}
