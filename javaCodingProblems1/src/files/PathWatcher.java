package files;

import java.io.IOException;
import java.lang.reflect.InaccessibleObjectException;
import java.nio.file.*;

public class PathWatcher {

    public void watchFolder(Path path) throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
        while (true) {
            WatchKey key = watchService.take();
            for (WatchEvent<?> watchEvent: key.pollEvents()) {
                WatchEvent.Kind<?> kind = watchEvent.kind();
                WatchEvent<Path> watchEventPath = (WatchEvent<Path>) watchEvent;
                Path filename = watchEventPath.context();
                System.out.println(filename);
            }
            boolean valid = key.reset();

            if (!valid) {
                break;
            }
        }

    }
}
