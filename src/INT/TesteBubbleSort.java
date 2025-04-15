package INT;
import java.util.concurrent.ThreadLocalRandom;

public class TesteBubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    trocou = true;
                }
            }
            if (!trocou) break;
        }
    }

    public static int[] gerarVetorAleatorio(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = ThreadLocalRandom.current().nextInt(1000000);
        }
        return vetor;
    }

    public static void main(String[] args) {
        int tamanho = 10000; // exemplo com 10 mil elementos
        double somaTempos = 0;

        for (int i = 0; i < 10; i++) {
            int[] vetor = gerarVetorAleatorio(tamanho);

            long inicio = System.nanoTime();
            bubbleSort(vetor);
            long fim = System.nanoTime();

            double tempo = (fim - inicio) / 1_000_000.0;
            somaTempos += tempo;

            System.out.printf("execucao %d: %.2f ms\n", i + 1, tempo);
        }

        double media = somaTempos / 10;
        System.out.printf("\ntempo medio: %.2f ms\n", media);
    }
}
