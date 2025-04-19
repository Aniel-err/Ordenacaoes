package Inverso_teste;

public class SelectionSortAlunoInverso {
    public static void selectionSort(Aluno[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].nota > arr[maxIdx].nota) {
                    maxIdx = j;
                }
            }
            Aluno temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }
    }
}