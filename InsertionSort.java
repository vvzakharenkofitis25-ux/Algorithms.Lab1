 import java.util.Random;

    public class InsertionSort {
        public static void sort(int[] array) {
            int n = array.length;
            for (int i = 1; i < n; i++) {
                int key = array[i];
                int j = i - 1;

                // Зсуваємо елементи масиву, які більші за key, на одну позицію вперед
                while (j >= 0 && array[j] > key) {
                    array[j + 1] = array[j];
                    j = j - 1;
                }
                // Вставляємо key на йогомісце
                array[j + 1] = key;
            }
        }

        public static void main(String[] args) {
            int size = 100000;

            //ГІРШИЙ ВИПАДОК (Елементи відсортовані у зворотному порядку)
            int[] worstCase = new int[size];
            for (int i = 0; i < size; i++) {
                worstCase[i] = size - i;
            }

            //КРАЩИЙ ВИПАДОК (Масив уже повністю відсортований)
            int[] bestCase = new int[size];
            for (int i = 0; i < size; i++) {
                bestCase[i] = i;
            }

            //СЕРЕДНІЙ ВИПАДОК (Випадкові числа)
            int[] averageCase = new int[size];
            Random random = new Random();
            for (int i = 0; i < size; i++) {
                averageCase[i] = random.nextInt(100000);
            }

            // Заміри часу для кращого випадку
            long startTime = System.nanoTime();
            sort(bestCase);
            long endTime = System.nanoTime();
            double bestTimeSeconds = (endTime - startTime) / 1e9;
            System.out.printf("Кращий випадок (вже відсортований): %.6f секунд\n", bestTimeSeconds);

            // Заміри часу для середнього випадку
            startTime = System.nanoTime();
            sort(averageCase);
            endTime = System.nanoTime();
            double averageTimeSeconds = (endTime - startTime) / 1e9;
            System.out.printf("Середній випадок (випадкові дані): %.6f секунд\n", averageTimeSeconds);

            // Заміри часу для гіршого випадку
            startTime = System.nanoTime();
            sort(worstCase);
            endTime = System.nanoTime();
            double worstTimeSeconds = (endTime - startTime) / 1e9;
            System.out.printf("Гірший випадок (зворотний порядок): %.6f секунд\n", worstTimeSeconds);
        }
    }

