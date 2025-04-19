package Inverso_teste;

public class TesteOrdenacaoInversa {

    private static void testar(String nomeAlgoritmo, Aluno[] alunos, Runnable algoritmo) {
        Aluno[] copia = new Aluno[alunos.length];
        System.arraycopy(alunos, 0, copia, 0, alunos.length);

        long inicio = System.nanoTime();
        algoritmo.run();
        long fim = System.nanoTime();

        long tempoMs = (fim - inicio) / 1_000_000;
        System.out.println(nomeAlgoritmo + " - tempo de execucao (decrescente): " + tempoMs + " ms");
    }

    public static void main(String[] args) {
        Aluno[] alunos = GeradorDeAlunos.gerarAlunos(100000); 

        testar("QuickSortInverso", alunos, () ->
            QuickSortAlunoInverso.quickSort(alunos.clone(), 0, alunos.length - 1)
        );

        testar("MergeSortInverso", alunos, () ->
            MergeSortAlunoInverso.mergeSort(alunos.clone(), 0, alunos.length - 1)
        );

        testar("HeapSortInverso", alunos, () ->
            HeapSortAlunoInverso.heapSort(alunos.clone())
        );

        testar("BubbleSortInverso", alunos, () ->
            BubbleSortAlunoInverso.bubbleSort(alunos.clone())
        );

        testar("SelectionSortInverso", alunos, () ->
            SelectionSortAlunoInverso.selectionSort(alunos.clone())
        );

        testar("InsertionSortInverso", alunos, () ->
            InsertionSortAlunoInverso.insertionSort(alunos.clone())
        );
    }
}