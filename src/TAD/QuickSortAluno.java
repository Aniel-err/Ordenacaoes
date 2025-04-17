package TAD;

public class QuickSortAluno {
    public static void quickSort(Aluno[] arr, int inicio, int fim) {
        if (inicio < fim) {
            int p = particiona(arr, inicio, fim);
            quickSort(arr, inicio, p - 1);
            quickSort(arr, p + 1, fim);
        }
    }

    private static int particiona(Aluno[] arr, int inicio, int fim) {
        Aluno pivo = arr[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (arr[j].nota <= pivo.nota) {
                i++;
                Aluno temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Aluno temp = arr[i + 1];
        arr[i + 1] = arr[fim];
        arr[fim] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Aluno[] alunos = GeradorDeAlunos.gerarAlunos(10000);
        long inicio = System.nanoTime();
        quickSort(alunos, 0, alunos.length - 1);
        long fim = System.nanoTime();
        long tempoMs = (fim - inicio) / 1_000_000;
        System.out.println("tempo de execucao: " + tempoMs + " ms");
    }
}
