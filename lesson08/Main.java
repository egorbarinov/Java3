package Lesson_8.hw;

public class Main {

    public static void main(String[] args) {

//        1 Задать размерность матрицы от 5 до 7
        final int y = 5; //количество строк
        final int x = 7; //длина столбца

//        2 Создать матрицу с указанной размерностью
        int[][] matrix = new int[y][x];

//        3 Заполнить матрицу по спирали (числа увеличиваются на 1) (число начинается с 1)
        int max = y*x;
        String way = "right";
        int row = 0;
        int column = 0;

        for (int i = 1; i <= max; i++) {

            if (way == "right" && (column > x - 1 || matrix[row][column] != 0)) {
                way = "down";
                row++;
                column--;
            }

            if (way == "down" && (row > y - 1 || matrix[row][column] != 0)) {
                way = "left";
                column--;
                row--;
            }

            if (way == "left" && (column < 0 || matrix[row][column] != 0)) {
                way = "up";
                row--;
                column++;
            }

            if (way == "up" && (row < 0 || matrix[row][column] != 0)) {
                way = "right";
                row++;
                column++;
            }

            matrix[row][column] = i;

            if (way == "right") {
                column++;
            }
            else if (way == "down") {
                row++;
            }
            else if (way == "left") {
                column--;
            }
            else if (way == "up") {
                row--;
            }
        }
        printOnConsole(matrix, y, x);
    }

    private static void printOnConsole(int[][] arr, int y, int x){

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
