import java.util.concurrent.ThreadLocalRandom;

public class MergeSortTest {

    public static void mergeSort(int[] arr, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(arr, inicio, meio);
            mergeSort(arr, meio + 1, fim);
            merge(arr, inicio, meio, fim);
        }
    }

    public static void merge(int[] arr, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[inicio + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[meio + 1 + j];
        }

        int i = 0, j = 0, k = inicio;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }
        while (i < n1) arr[k++] = left[i++];
        while (j < n2) arr[k++] = right[j++];
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
            System.out.println("ordenando com merge sort, tamanho: " + tamanho);
            double tempo = medirTempo(() -> mergeSort(vetor, 0, vetor.length - 1));
            System.out.printf("tempo de execucao: %.3f segundos\n\n", tempo);
        }
    }
}
