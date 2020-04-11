package Lesson_3.hw;

import javafx.animation.ScaleTransition;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class HWLesson3 {

    public static void main(String[] args) throws IOException {

        // 1.Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
        // создадим 5 файлов
        for (int i = 0; i < 6; i++) {
            File file = new File("file_number_" + i +".txt");
            file.createNewFile();
        }

        String str = "Two men, who are in the country for holidays,\n" +
                "are walking in an orchard. They see that there\n" +
                "are a lot of apples on all trees. Only on one tree\n" +
                "there are no apples at all. A small country\n" +
                "boy is sitting near that tree. They call him:\n" +
                "\"Come here, boy. Do you know why there are no apples\n" +
                "on this tree?\" \"Of course I do,\" answers the boy,\n" +
                "\"because it's an oak-tree.\"";

        // читаем в байтовый массив
        byte[] massiveByte = str.getBytes("UTF-8");
        //выводим в консоль
        for (byte o: massiveByte) {
            System.out.print((char) o);
        }
        System.out.println("\n");

        // Усложним задачу. Запишем данные из строки в массив чаров
        char[] result = str.toCharArray();

        // Запишем текст из массива чаров в текстовый файл

        FileOutputStream fos = new FileOutputStream("file_number_0.txt");
        for (int i = 0; i < result.length; i++) {
            fos.write(result[i]);
        }
        fos.flush();
        fos.close();

        // Прочитаем записаный текст в файле
        int ch;
        FileInputStream fis = new FileInputStream("file_number_0.txt");
        while ((ch = fis.read()) != -1) {
            System.out.print((char) ch);
        }
        fis.close();
        System.out.println("\n");

        // Запишем из строки в текстовый файл

        String twoString = "Весьма порой мешает мне заснуть\n" +
                "Волнующая, как ни поверни,\n" +
                "Открывшаяся мне внезапно суть\n" +
                "Какой-нибудь немыслимой фигни.\n";

        try (FileWriter fw = new FileWriter("file_number_1.txt")) {
            fw.write(twoString);
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }

        // прочитаем из строки в текстовом файле в консоль
        try (BufferedReader br = new BufferedReader(new FileReader("file_number_0.txt"))) {
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }

        // 2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт).
        // Может пригодиться следующая конструкция: ArrayList<InputStream> al = new ArrayList<>(); ...
        // Enumeration<InputStream> e = Collections.enumeration(al);
        ArrayList<InputStream> ali = new ArrayList<>();
        ali.add(new FileInputStream("file_number_0.txt"));
        ali.add(new FileInputStream("file_number_1.txt"));
        ali.add(new FileInputStream("file_number_2.txt"));
        ali.add(new FileInputStream("file_number_3.txt"));
        ali.add(new FileInputStream("file_number_4.txt"));

        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(ali));
        FileOutputStream fs = new FileOutputStream("file_number_5.txt");

        int x;
        while ((x = in.read()) != -1) {
            fs.write(x);
            fs.flush();
        }
        in.close();
        fs.close();
    }
}
