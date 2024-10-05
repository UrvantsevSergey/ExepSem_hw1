import java.util.ArrayList;
import java.util.Scanner;
public class z1 {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        int min = 5;

        fillAr(myList);
        arL(myList, min);
        find(myList);
    }

    public static void arL(ArrayList<Integer> myList, int min) {
        if (myList.size() == 0) {
            System.out.println("Список пуст");
        } else if (myList.size() < min) {
            System.out.println("В списке меньше " + min + " элементов");
        }
    }

    public static void fillAr(ArrayList<Integer> myList) {
        System.out.println("Введите элемент массива, для выхода введите 'q'");
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();

        while (!n.equals("q")) {
            try {
                myList.add(Integer.parseInt(n));
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректное число или 'q' для выхода.");
            }
            System.out.println("Введите элемент массива, для выхода введите 'q'");
            n = scanner.nextLine();
        }

        System.out.println("Ваш список: " + myList);
    }

    public static void find(ArrayList<Integer> myList) {
        Scanner scanner = new Scanner(System.in); // Создаем новый сканер
        System.out.println("Введите искомое число:");
        String inputNum = scanner.nextLine();
        int num;

        // Проверка на корректность ввода числа
        while (true) {
            try {
                num = Integer.parseInt(inputNum);
                break; // Выход из цикла, если ввод корректен
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное число:");
                inputNum = scanner.nextLine();
            }
        }

        // Поиск числа в списке
        boolean found = false;
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).equals(num)) {
                System.out.println("Число " + num + " находится на " + i + " позиции");
                found = true; // Устанавливаем флаг, если число найдено
                break; // Выход из цикла, если число найдено
            }
        }

        if (!found) {
            System.out.println("Числа " + num + " в списке нет");
        }

        // Закрываем сканер
        scanner.close(); 
    }
}
public class z2 {
    public static void main(String[] args) {
        String[][] arr = {{"1", "g", "6"}, {"2", "h", "7"}}; // Исправлено: массив должен быть инициализирован правильно
        System.out.println(sum2d(arr));
    }

    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) { // Исправлено: используем arr[i].length для правильного доступа к элементам
                try {
                    int val = Integer.parseInt(arr[i][j]); // Пробуем преобразовать строку в число
                    sum += val; // Добавляем к сумме
                } catch (NumberFormatException e) {
                    // Игнорируем, если элемент не является числом
                }
            }
        }
        return sum;
    }
}
public class z3 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 10, 7};
        try {
            int[] result = substrArr(arr1, arr2);
            for (int value : result) {
                System.out.print(value + " ");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); 
        }
    }

    public static int[] substrArr(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Массивы должны быть одинаковой длины");
        }
        int[] subArr = new int[arr1.length]; 
        for (int i = 0; i < arr1.length; i++) {
            subArr[i] = arr1[i] - arr2[i]; 
        }
        return subArr;
    }
}
public class z4 {
    public static void main(String[] args) {
        int[] arr1 = {6, 12, 25, 16, 5};
        int[] arr2 = {3, 4, 5, 6, 1};

        try {
            int[] result = resArr(arr1, arr2);
            for (int value : result) {
                System.out.print(value + " ");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int[] resArr(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Массивы должны быть одинаковой длины");
        }

        int[] resArr = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0) {
                throw new RuntimeException("Во втором массиве на позиции " + i + " находится ноль, деление на ноль невозможно");
            }
            resArr[i] = arr1[i] / arr2[i];
        }
        return resArr;
    }
}