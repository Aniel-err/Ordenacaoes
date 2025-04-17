package TAD;

public class BubbleSortAluno {
    public static void bubbleSort(Aluno[] arr) {
        int n = arr.length;
        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].nota > arr[j + 1].nota) {
                    Aluno temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    trocou = true;
                }
            }
            if (!trocou) break;
        }
    }

    public static void main(String[] args) {
        Aluno[] alunos = GeradorDeAlunos.gerarAlunos(10000);
        long inicio = System.nanoTime();
        bubbleSort(alunos);
        long fim = System.nanoTime();
        long tempoMs = (fim - inicio) / 1_000_000;
        System.out.println("tempo de execucao: " + tempoMs + " ms");
    }
}
