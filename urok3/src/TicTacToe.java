import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    /*
                settings
                 */
    private static char[][] map;    // матрица игры
    private static int SIZE = 3;    // размерность поля
    private static final char DOT_EMPTY = '⚫';
    private static final char DOT_X = 'X';
    private static final char DOT_O = '⚪';
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static boolean SILLY_MODE;


    public static void main(String[] args) {
        setSillyMode();
        initMap();
        printMap();

        while (true) {
            humanTurn();    // Ход человека
            if (isEndGame(DOT_X)) {
                break;
            }

            computerTurn();    // Ход компьютера
            if (isEndGame(DOT_O)) {
                break;
            }

        }
        System.out.println("Game over");
    }

    /**
     * Метод генерации игрового поля
     */

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    /**
     * Метод вывода игрового поля
     */
    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Ход человека
     */
    private static void humanTurn() {
        int x, y;

        do {
            System.out.println("Введите координаты ячейки через пробел");
            y = scanner.nextInt() - 1;
            x = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    /**
     * Ход компьютера
     */
    private static void computerTurn() {
        int x = -1;
        int y = -1;

        if (SILLY_MODE) {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(x, y));
        } else {

            boolean moveFound = false;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    // Проверяем клетки по направлениям
                    if (map[i][j] == DOT_EMPTY) {
                        // проверка направления
                        // лево верх
                        if (i - 1 > 0 && j - 1 >= 0 && map[i - 1][j - 1] == DOT_O) {
                            y = i;
                            x = j;
                            moveFound = true;
                            System.out.println("LU");
                        }
                        // верх
                        else if (i - 1 >= 0 && map[i - 1][j] == DOT_O) {
                            y = i;
                            x = j;
                            moveFound = true;
                            System.out.println("U");
                        }
                        // право верх
                        else if (i - 1 >= 0 && j + 1 < SIZE && map[i - 1][j + 1] == DOT_O) {
                            y = i;
                            x = j;
                            moveFound = true;
                            System.out.println("RU");
                        }

                        // право
                        else if (j + 1 < SIZE && map[i][j + 1] == DOT_O) {
                            y = i;
                            x = j;
                            moveFound = true;
                            System.out.println("R");
                        }
                        // право низ
                        else if (i + 1 < SIZE && j + 1 < SIZE && map[i + 1][j + 1] == DOT_O) {
                            y = i;
                            x = j;
                            moveFound = true;
                            System.out.println("RD");
                        }
                        // низ
                        else if (i + 1 < SIZE && map[i + 1][j] == DOT_O) {
                            y = i;
                            x = j;
                            moveFound = true;
                            System.out.println("D");
                        }

                        // лево низ
                        else if (i + 1 < SIZE && j - 1 >= 0 && map[i + 1][j - 1] == DOT_O) {
                            y = i;
                            x = j;
                            moveFound = true;
                            System.out.println("LD");
                        }
                        // лево
                        else if (j - 1 >= 0 && map[i][j - 1] == DOT_O) {
                            y = i;
                            x = j;
                            moveFound = true;
                            System.out.println("L");
                        }
                    }
                    // если ход найден прервываем внутренний цикл
                    if (moveFound) {
                        break;
                    }
                }
                // если ход найден прервываем внешний цикл
                if (moveFound) {
                    break;
                }
            }
            // Если ничего не нашли делаем глупый ход
            if (x == -1) {
                do {
                    x = random.nextInt(SIZE);
                    y = random.nextInt(SIZE);
                } while (!isCellValid(x, y));
            }
        }
        System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
        map[y][x] = DOT_O;
    }


    /**
     * Метод валидации ячейки по введенным координатам
     *
     * @param x - координата по горизонтали
     * @param y - координата по вертикали
     * @return boolean - признак валидности
     */
    private static boolean isCellValid(int x, int y) {
        boolean result = true;
        // проверка координаты
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            result = false;
        }
        // проверка заполненности ячейки
        if (map[y][x] != DOT_EMPTY) {
            result = false;
        }

        return result;
    }

    /**
     * Метод проверки игры на завершение
     *
     * @param playerSymbol символ, которым игрок завершает ход
     * @return boolean - признак завершения игры
     */
    private static boolean isEndGame(char playerSymbol) {
        boolean result = false;

        printMap();

        // проверяем необходимость следующего хода
        if (checkWin(playerSymbol)) {
            System.out.println("Победили " + playerSymbol);
            result = true;
        } else if (isMapFull()) {
            System.out.println("Ничья");
            result = true;
        }

        return result;
    }

    /**
     * Проверка заполнености поля
     *
     * @return boolean признак оптимальности
     */
    private static boolean isMapFull() {
        boolean result = true;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY)
                    result = false;
            }
        }
        return result;
    }


    /**
     * Проверка наличия победной комбинации
     *
     * @param playerSymbol - символ игрока
     * @return result
     */
    private static boolean checkWin(char playerSymbol) {
        boolean result = false;

        if (
                (map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol) ||
                        (map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol) ||
                        (map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol) ||
                        (map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[1][1] == playerSymbol && map[0][2] == playerSymbol)) {
            result = true;
        }

        return result;
    }

    /**
     * Сложность
     *
     * @return boolean - низкая сложность
     */
    public static boolean setSillyMode() {
        System.out.println("Хотите включить легкий режим ? [true/false]");
        boolean sillyMode = scanner.nextBoolean();
        if (sillyMode) {
            System.out.println("Включен легкий режим");
        } else System.out.println("Включен нормальный режим");
        return SILLY_MODE = sillyMode;
    }

}
