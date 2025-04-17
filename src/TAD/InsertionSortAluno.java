package TAD;
public class InsertionSortAluno {
    public static void insertionSort(Aluno[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Aluno chave = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].nota > chave.nota) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = chave;
        }
    }

    public static void main(String[] args) {
        Aluno[] alunos = GeradorDeAlunos.gerarAlunos(10000);
        long inicio = System.nanoTime();
        insertionSort(alunos);
        long fim = System.nanoTime();
        long tempoMs = (fim - inicio) / 1_000_000;
        System.out.println("tempo de execucao: " + tempoMs + " ms");
    }
}
