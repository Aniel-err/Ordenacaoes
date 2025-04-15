package TAD;

import java.io.*;
import java.util.*;

public class InsertionSortAluno {

    static class Aluno {
        String nome;
        double nota;

        public Aluno(String nome, double nota) {
            this.nome = nome;
            this.nota = nota;
        }
    }

    public static void insertionSort(Aluno[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Aluno chave = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].nota > chave.nota) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = chave;
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
        String nomeArquivo = gerarNomeArquivo("insertion");

        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            writer.println("tamanho,tempo_ms");

            for (int tamanho : tamanhos) {
                Aluno[] vetor = gerarVetorAlunos(tamanho);

                long inicio = System.nanoTime();
                insertionSort(vetor);
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
