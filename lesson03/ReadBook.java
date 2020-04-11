package Lesson_3.hw;

import java.io.*;
import java.util.Random;

public class ReadBook {

    private static final int CHAR_BOUND_L = 65;
    private static final int CHAR_BOUND_H = 90;
    private static final Random rnd = new Random();

    public static void main(String[] args) throws IOException {

        writeFileContents("Symbols_book.txt", 149796); // 10485760
        readBook("Symbols_book.txt");

    }

    private static String generateSymbols(int amount) {
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            for (int j = 0; j < 70; j++) {
                sequence.append((char) (CHAR_BOUND_L + rnd.nextInt(CHAR_BOUND_H - CHAR_BOUND_L)));
            }
            sequence.append("\n");
        }
        return sequence.toString();
    }

    private static void writeFileContents(String fileName, int length) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(generateSymbols(length).getBytes());
        fos.flush();
        fos.close();
    }
    static void readBook(String name) {

        try (RandomAccessFile raf = new RandomAccessFile(name, "r");
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            byte[] byteArray = new byte[1800];
            long fileSize = raf.length();
            long pageSize = 1800;
            long pages = fileSize / pageSize;

            while (true) {
                System.out.println("Введите страницу от 0 до " + pages);

                int page = Integer.parseInt(br.readLine());
                if (page <= pages && page >= 0) {
                    long t = System.currentTimeMillis();
                    raf.seek(page);
                    raf.read(byteArray, 0, byteArray.length);
                    for (byte b : byteArray) {
                        System.out.print((char) b);
                    }
                    System.out.println();
                    System.out.println("Время, потраченное на поиск: " + (System.currentTimeMillis() - t));
                } else {
                    System.out.println("Такой страницы не существует.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
