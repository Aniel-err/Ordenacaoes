import java.util.concurrent.ThreadLocalRandom;

public class BubbleSortTest {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;  
        }
    }

    public static int[] gerarVetorAleatorio(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = ThreadLocalRandom.current().nextInt(1_000_000);
        }
        return vetor;
    }

    public static double medirTempo(Runnable metodo) {
        long inicio = System.nanoTime();
        metodo.run();
        long fim = System.nanoTime();
        return (fim - inicio) / 1_000_000_000.0;
    }

    public static void main(String[] args) {
        int[] tamanhos = {10000, 50000, 100000,300000,800000,1000000};

        for (int tamanho : tamanhos) {
            int[] vetor = gerarVetorAleatorio(tamanho);
            System.out.println("ordenando com bubble sort, tamanho: " + tamanho);
            double tempo = medirTempo(() -> bubbleSort(vetor));
            System.out.printf("tempo de execucao: %.3f segundos\n\n", tempo);
        }
    }
}
