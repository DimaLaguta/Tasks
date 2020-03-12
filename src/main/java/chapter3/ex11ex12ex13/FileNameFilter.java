package chapter3.ex11ex12ex13;

import java.io.File;
import java.io.FilenameFilter;

public class FileNameFilter implements FilenameFilter {
    String extension;

    FileNameFilter(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(extension);
    }
}
