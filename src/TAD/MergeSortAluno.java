package TAD;
public class MergeSortAluno {
    public static void mergeSort(Aluno[] arr, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(arr, inicio, meio);
            mergeSort(arr, meio + 1, fim);
            merge(arr, inicio, meio, fim);
        }
    }

    private static void merge(Aluno[] arr, int inicio, int meio, int fim) {
        Aluno[] temp = new Aluno[fim - inicio + 1];
        int i = inicio, j = meio + 1, k = 0;

        while (i <= meio && j <= fim) {
            if (arr[i].nota <= arr[j].nota) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= meio) temp[k++] = arr[i++];
        while (j <= fim) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, inicio, temp.length);
    }

    public static void main(String[] args) {
        Aluno[] alunos = GeradorDeAlunos.gerarAlunos(10000);
        long inicio = System.nanoTime();
        mergeSort(alunos, 0, alunos.length - 1);
        long fim = System.nanoTime();
        long tempoMs = (fim - inicio) / 1_000_000;
        System.out.println("tempo de execucao: " + tempoMs + " ms");
    }
}
