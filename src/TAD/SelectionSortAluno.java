package TAD;
public class SelectionSortAluno {
    public static void selectionSort(Aluno[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].nota < arr[min].nota) {
                    min = j;
                }
            }
            Aluno temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        Aluno[] alunos = GeradorDeAlunos.gerarAlunos(10000);
        long inicio = System.nanoTime();
        selectionSort(alunos);
        long fim = System.nanoTime();
        long tempoMs = (fim - inicio) / 1_000_000;
        System.out.println("tempo de execucao: " + tempoMs + " ms");
    }
}
