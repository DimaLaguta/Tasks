package chapter3.ex11ex12ex13;

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

    public static List<File> sortFilesByDirAndPath(String path){
        File dir = new File(path);
        List<File> files = new ArrayList<>();
        Collections.addAll(files, dir.listFiles());
     //   files.sort(Comparator.comparing(File::isFile).thenComparing(File::getPath));
        files.sort((x1,x2)->Boolean.compare(x1.isFile(),x2.isFile()));
        return files;
    }
}
