package com.demo.unit7_java_io.part2;

import java.io.IOException;
import java.nio.file.*;

public class WatchFolderExample {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Temp");
        watch(path);
    }

    public static void watch(Path path) {
        FileSystem fileSystem = path.getFileSystem();

        try (WatchService service = fileSystem.newWatchService()) {
            path.register(service, StandardWatchEventKinds.ENTRY_CREATE);
            while (true) {
                WatchKey key = service.take();
                if (!key.reset()) {
                    break;
                }
                for (WatchEvent<?> watchEvent : key.pollEvents()) {
                    if (StandardWatchEventKinds.ENTRY_CREATE == watchEvent.kind()) {
                        Path newPath = ((WatchEvent<Path>) watchEvent).context();
                        System.out.println("New path created: " + newPath);
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
