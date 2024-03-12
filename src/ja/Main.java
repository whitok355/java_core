package ja;

import java.io.File;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        File homeDirectory = new File("./src/ja");
        File backupDirectory = new File("./backup");

        BackupCreator backupCreator = new BackupCreator(homeDirectory, backupDirectory);
        backupCreator.createBackup();

        Tree.print(homeDirectory, " ", false);
    }
}
