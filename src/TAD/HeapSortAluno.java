package TAD;

public class HeapSortAluno {
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
        int maior = i;
        int esq = 2 * i + 1;
        int dir = 2 * i + 2;

        if (esq < n && arr[esq].nota > arr[maior].nota) maior = esq;
        if (dir < n && arr[dir].nota > arr[maior].nota) maior = dir;

        if (maior != i) {
            Aluno temp = arr[i];
            arr[i] = arr[maior];
            arr[maior] = temp;
            heapify(arr, n, maior);
        }
    }

    public static void main(String[] args) {
        Aluno[] alunos = GeradorDeAlunos.gerarAlunos(10000);
        long inicio = System.nanoTime();
        heapSort(alunos);
        long fim = System.nanoTime();
        long tempoMs = (fim - inicio) / 1_000_000;
        System.out.println("tempo de execucao: " + tempoMs + " ms");
    }
}
