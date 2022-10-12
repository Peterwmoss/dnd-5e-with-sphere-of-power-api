package dk.peter.moss.dnd5eapi.repositories

import java.nio.file.Files
import java.nio.file.Path

abstract class Repository {
    protected String readFile(String path) {
        try {
            return Files.readString(Path.of(path))
        } catch (IOException e) {
            System.err.println(e.message)
            return null
        }
    }
}
