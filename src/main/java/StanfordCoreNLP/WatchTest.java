package StanfordCoreNLP;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class WatchTest {
    public static void main(String[] args) throws IOException, InterruptedException {
//        WatchTest.watchMyFiles();
//        WatchTest.watchDirectory();
    }

    public static void watchDirectory(){
        try (WatchService service = FileSystems.getDefault().newWatchService()){
            Map<WatchKey, Path> keyMap = new HashMap<>();
//        Path dir = Paths.get("MyMavenProject/files");
//        Files.createDirectory(dir);
            Path path = Paths.get("StanfordCoreNLP/files");
            keyMap.put(path.register(service,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY),
                    path);

            WatchKey watchKey;
            System.out.println("Running the Directory Watch Service");
            do{
                watchKey = service.take();
                Path eventDir = keyMap.get(watchKey);
                for(WatchEvent<?> event : watchKey.pollEvents()){
                    WatchEvent.Kind<?> kind = event.kind();
                    Path eventPath = (Path) event.context();
                    System.out.println(eventDir + ": " + kind + ": " + eventPath);
                }
            }while(watchKey.reset());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





    public static void watchMyFiles() throws IOException, InterruptedException {
        Path path = Paths.get("/Users/kevin/blub");
        WatchService watchService = path.getFileSystem().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

        while (true) {
            WatchKey watchKey = watchService.take(); // blocks

            for (WatchEvent<?> event : watchKey.pollEvents()) {
                WatchEvent<Path> watchEvent = (WatchEvent<Path>) event;
                WatchEvent.Kind<Path> kind = watchEvent.kind();

                System.out.println(watchEvent.context() + ", count: " +
                        watchEvent.count() + ", event: " + watchEvent.kind());
                // prints (loop on the while twice)
                // servers.cfg, count: 1, event: ENTRY_MODIFY
                // servers.cfg, count: 1, event: ENTRY_MODIFY

                switch (kind.name()) {
                    case "ENTRY_MODIFY":
                        handleModify(watchEvent.context()); // reload configuration class
                        break;
                    case "ENTRY_DELETE":
                        handleDelete(watchEvent.context()); // do something else
                        break;
                    case "ENTRY_CREATE":
                        System.out.println("A file has been created!");
                    default:
                        System.out.println("Event not expected " + event.kind().name());
                }
            }

            watchKey.reset();
        }
    }

    private static void handleDelete(Path context) {
        System.out.println("handleDelete  " + context.getFileName());
    }

    private static void handleModify(Path context) {
        System.out.println("handleModify " + context.getFileName());
    }


}