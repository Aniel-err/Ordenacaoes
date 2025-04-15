package TAD;

import java.io.*;
import java.util.*;

public class QuickSortAluno {

    static class Aluno {
        String nome;
        double nota;

        public Aluno(String nome, double nota) {
            this.nome = nome;
            this.nota = nota;
        }
    }

    public static void quickSort(Aluno[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(Aluno[] arr, int low, int high) {
        double pivot = arr[high].nota;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].nota <= pivot) {
                i++;
                Aluno temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Aluno temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
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
        int[] tamanhos = {10000};
        String nomeArquivo = gerarNomeArquivo("quick");

        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            writer.println("tamanho,tempo_ms");

            for (int tamanho : tamanhos) {
                Aluno[] vetor = gerarVetorAlunos(tamanho);

                long inicio = System.nanoTime();
                quickSort(vetor, 0, vetor.length - 1);
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
