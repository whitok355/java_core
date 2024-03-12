package ja;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class BackupCreator {
    //region
    private static File homeDir;
    private static File backupDir;
    public static File getHomeDir() {
        return homeDir;
    }
    public File getBackupDir() {
        return backupDir;
    }
    public BackupCreator(File homeDir, File backupDir) {
        this.homeDir = homeDir;
        this.backupDir = backupDir;
    }
    //endregion
    public static void createBackup(){
        createDirectory();
        getFilesInDirectory();
    }
    private static void createDirectory(){
        try{
            if(!Files.exists(backupDir.toPath())){
                new File(String.valueOf(backupDir)).mkdir();
                System.out.println("The directory has been created");
            } else{
                throw new IOException("Directory already exist");
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void getFilesInDirectory() {
        try{
            for(File fl: homeDir.listFiles()){
                Files.copy(fl.toPath(), Paths.get(backupDir +"/"+ "Backup" +fl.getName()), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
