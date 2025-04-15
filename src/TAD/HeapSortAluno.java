package TAD;

import java.io.*;
import java.util.*;

public class HeapSortAluno {

    static class Aluno {
        String nome;
        double nota;

        public Aluno(String nome, double nota) {
            this.nome = nome;
            this.nota = nota;
        }
    }

    public static void heapify(Aluno[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left].nota > arr[largest].nota)
            largest = left;

        if (right < n && arr[right].nota > arr[largest].nota)
            largest = right;

        if (largest != i) {
            Aluno temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void heapSort(Aluno[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            Aluno temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static Aluno[] gerarVetorAlunos(int tamanho) {
        Aluno[] alunos = new Aluno[tamanho];
        Random rand = new Random();
        for (int i = 0; i < tamanho; i++) {
            String nome = "aluno" + (i + 1);
            double nota = rand.nextDouble() * 10;
            alunos[i] = new Aluno(nome, nota);
        }
        return alunos;
    }

    public static String gerarNomeArquivo(String prefixo) {
        int i = 1;
        while (true) {
            String nome = prefixo + "_teste" + i + ".csv";
            File f = new File(nome);
            if (!f.exists()) return nome;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] tamanhos = {10000, 50000, 100000};
        String nomeArquivo = gerarNomeArquivo("heap");

        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            writer.println("tamanho,tempo_ms");

            for (int tamanho : tamanhos) {
                Aluno[] vetor = gerarVetorAlunos(tamanho);

                long inicio = System.nanoTime();
                heapSort(vetor);
                long fim = System.nanoTime();

                double tempoMs = (fim - inicio) / 1_000_000.0;
                writer.printf("%d,%.3f%n", tamanho, tempoMs);
                System.out.printf("ordenou vetor de %d em %.3f ms%n", tamanho, tempoMs);
            }

            System.out.println("resultados salvos em: " + nomeArquivo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
