package dk.peter.moss.dnd5eapi.util

import java.nio.file.Files
import java.nio.file.Path

class FileUtils {
    static String readFile(String path) {
        try {
            return Files.readString(Path.of(path))
        } catch (IOException e) {
            System.err.println(e.message)
            return null
        }
    }
}
