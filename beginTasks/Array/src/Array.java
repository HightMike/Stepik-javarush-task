

import java.util.Arrays;

public class Array {  // Задача на сортировку результирующего массива при наличии двух уже отсортированных массивов (без применения метода .sort)
    public static void main(String[] args) {
        int a1 [] = {}; // задаем массивы
        int a2 [] = {7,7,14,17}; // еще один
        int array3[] = new int[a1.length+a2.length]; //складываем и получаем длину в 8
        int k = 0; // задаем счетчики
        int j = 0;
        if (a1.length != 0 && a2.length !=0) { // проверка на нулевой массив


            for (int i = 0; i < array3.length - 1; i++) { // цикл по большому массиву

                if (a2[j] < a1[k]) { // k увеличиваем только в  том случае, если элемент с номером j будет больше элемента с номером k
                    array3[i] = a2[j];  //i увеличивется всегда
                    j++; // увеличиваем только в том случае, если выполняется первое условие
                    if (j == a2.length) { // в случае если достигло лимита
                        while (k != a1.length - 1) { // пока k не дойдет до конца
                            i++;
                            array3[i] = a1[k];
                            k++;
                        }
                    } else if (k == a1.length) {
                        while (j != a1.length - 1) {
                            i++;
                            array3[i] = a2[j];
                            j++;
                        }
                    }


                } else {
                    array3[i] = a1[k];
                    k++;
                    if (j == a2.length) { // в случае если достигло лимита
                        while (k != a1.length - 1) { // пока k не дойдет до конца
                            i++;
                            array3[i] = a1[k];
                            k++;
                        }
                    } else if (k == a1.length) {
                        while (j != a2.length - 1) {
                            i++;
                            array3[i] = a2[j];
                            j++;
                        }
                    }
                }
            }
            if (a2[a2.length - 1] < a1[a1.length - 1]) {   // топорный способ добавления в остаток
                array3[array3.length - 1] = a1[a1.length - 1];
            } else {
                array3[array3.length - 1] = a2[a2.length - 1];
            }
            System.out.println(Arrays.toString(array3));
        }
        else if ( a2.length == 0 ) {
            System.out.println(Arrays.toString(a1));
        }
        else {
            System.out.println(Arrays.toString(a2));
        }
    }

}
