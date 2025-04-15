package INT;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSortTest {

    public static void quickSort(int[] arr, int inicio, int fim) {
        if (inicio < fim) {
            int p = particionar(arr, inicio, fim);
            quickSort(arr, inicio, p - 1);
            quickSort(arr, p + 1, fim);
        }
    }

    public static int particionar(int[] arr, int inicio, int fim) {
        int pivo = arr[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (arr[j] <= pivo) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[fim];
        arr[fim] = temp;
        return i + 1;
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
            System.out.println("ordenando com quick sort, tamanho: " + tamanho);
            double tempo = medirTempo(() -> quickSort(vetor, 0, vetor.length - 1));
            System.out.printf("tempo de execucao: %.3f segundos\n\n", tempo);
        }
    }
}
