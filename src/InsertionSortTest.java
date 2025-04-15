import java.util.concurrent.ThreadLocalRandom;

public class InsertionSortTest {

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
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
        int[] tamanhos = {10000, 50000, 100000, 300000, 800000, 1000000};

        for (int tamanho : tamanhos) {
            int[] vetor = gerarVetorAleatorio(tamanho);
            System.out.println("ordenando com insertion sort, tamanho: " + tamanho);
            double tempo = medirTempo(() -> insertionSort(vetor));
            System.out.printf("tempo de execucao: %.3f segundos\n\n", tempo);
        }
    }
}
