package Inverso_teste;


public class InsertionSortAlunoInverso {
    public static void insertionSort(Aluno[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Aluno chave = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].nota < chave.nota) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = chave;
        }
    }
}