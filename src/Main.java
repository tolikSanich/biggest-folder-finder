import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {

        String folder ="E:\\Программы";
        File file = new File(folder);
       long start = System.currentTimeMillis();
        FolderSizeCalculator calculator = new FolderSizeCalculator(file);
        ForkJoinPool pool = new ForkJoinPool();
        long size = pool.invoke(calculator);

        System.out.println(size);
        long duration = System.currentTimeMillis()-start;
        System.out.println(duration);

        long start1 = System.currentTimeMillis();
        System.out.println(getSizeFolder(file));
        long duration1 = System.currentTimeMillis()-start1;
        System.out.println(duration1);

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