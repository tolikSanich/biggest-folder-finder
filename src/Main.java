import java.io.File;

public class Main {

    public static void main(String[] args) {
        String folder ="E:\\фильмы";
        File file = new File(folder);
        System.out.println(getSizeFolder(file));

    }
    public static long getSizeFolder(File folder) {
        long sum = 0;
        if (folder.isFile()){
            return folder.length();
        }
        File[] files = folder.listFiles();
        for (File file : files) {
                sum += getSizeFolder(file);
        }
    return sum;
    }

}