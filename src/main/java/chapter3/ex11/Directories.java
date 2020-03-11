package chapter3.ex11;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Directories {
    public static List<File> directories(String path) {
        File dir = new File(path);
        List<File> directories = new ArrayList<>();
        Collections.addAll(directories, dir.listFiles(File::isDirectory));
        return directories;
    }

    public static List<String> filesWithExtension(String path, String targetExtension) {
        File dir = new File(path);
        List<String> files = new ArrayList<>();
        //Collections.addAll(files, dir.list(new FileNameFilter(targetExtension)));
        Collections.addAll(files, dir.list((x, y) -> y.toLowerCase().endsWith(targetExtension)));
        return files;
    }
}
