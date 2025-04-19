package Inverso_teste;

public class HeapSortAlunoInverso {
    public static void heapSort(Aluno[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            Aluno temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(Aluno[] arr, int n, int i) {
        int menor = i;
        int esq = 2 * i + 1;
        int dir = 2 * i + 2;

        if (esq < n && arr[esq].nota < arr[menor].nota) menor = esq;
        if (dir < n && arr[dir].nota < arr[menor].nota) menor = dir;

        if (menor != i) {
            Aluno temp = arr[i];
            arr[i] = arr[menor];
            arr[menor] = temp;

            heapify(arr, n, menor);
        }
    }

    public static void main(String[] args) {
        Aluno[] alunos = GeradorDeAlunos.gerarAlunos(10000);
        long inicio = System.nanoTime();
        heapSort(alunos);
        long fim = System.nanoTime();
        long tempoMs = (fim - inicio) / 1_000_000;
        System.out.println("tempo de execucao (decrescente): " + tempoMs + " ms");
    }
}

