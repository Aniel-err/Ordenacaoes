import java.util.concurrent.ThreadLocalRandom;

public class SelectionSortTest {

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
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
            System.out.println("ordenando com selection sort, tamanho: " + tamanho);
            double tempo = medirTempo(() -> selectionSort(vetor));
            System.out.printf("tempo de execucao: %.3f segundos\n\n", tempo);
        }
    }
}
