import java.io.File;

public class Main {

    public static void main(String[] args) {
        String folder ="E:\\фильмы";
        File file = new File(folder);


    }
    public static long sizeFolder(File folder) {
        long sum = 0;
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                sizeFolder(folder);
                continue;
            }
            sum += file.length();
        }
    return sum;
    }

}