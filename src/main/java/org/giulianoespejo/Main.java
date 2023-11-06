package org.giulianoespejo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String[] dna1 = {"TTGCGA","AAGTGC","TTATTT","AGATGG","GCGTCA","TCACTG"};
        System.out.println("Matriz");
        mostrarMatriz(arrayToMatriz(dna1));
        System.out.println("Resultado " + isMutant(dna1));

        System.out.println("\n");
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        System.out.println("Matriz");
        mostrarMatriz(arrayToMatriz(dna));
        System.out.println("Resultado " + isMutant(dna));

        System.out.println("\n");
        String[] dna2 = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
        System.out.println("Matriz");
        mostrarMatriz(arrayToMatriz(dna2));
        System.out.println("Resultado " + isMutant(dna2));

        System.out.println("\n");
        String[] dna3 = {"ATGCAA","CAGTGC","TTATAT","AGAACG","GTCCCC","TCACTG"};
        System.out.println("Matriz");
        mostrarMatriz(arrayToMatriz(dna3));
        System.out.println("Resultado " + isMutant(dna3));

        System.out.println("\n");
        String[] dna4 = {"AGCTGC","AGCTGC","AGCTGC","AGCTGC","AGCTGC","AGCTGC"};
        System.out.println("Matriz");
        mostrarMatriz(arrayToMatriz(dna4));
        System.out.println("Resultado " + isMutant(dna4));

        System.out.println("\n");
        String[] dna5 = {"AAAAAA","AAAAAA","AAAAAA","AAAAAA","AAAAAA","AAAAAA"};
        System.out.println("Matriz");
        mostrarMatriz(arrayToMatriz(dna5));
        System.out.println("Resultado " + isMutant(dna5));

        System.out.println("\n");
        String[] dna6 = {"JJJJJJ","JJJJJJ","JJJJJJ","JJJJJJ","JJJJJJ","JJJJJJ"};
        System.out.println("Matriz");
        mostrarMatriz(arrayToMatriz(dna6));
        System.out.println("Resultado " + isMutant(dna6));

        System.out.println("\n");
        String[] dna7 = {"ACGTGC","ACTGCG","ACCGTC","ACGTCT","GCATAC","ACGTAC"};
        System.out.println("Matriz");
        mostrarMatriz(arrayToMatriz(dna7));
        System.out.println("Resultado " + isMutant(dna7));

        System.out.println("\n");
        String[] dna8 = {"CCGTGC",
                         "ACTGCG",
                         "ACCCTC",
                         "ACCCCT",
                         "GCATCC",
                         "ACGTAC"};
        System.out.println("Matriz");
        mostrarMatriz(arrayToMatriz(dna8));
        System.out.println("Resultado " + isMutant(dna8));

        System.out.println("\n");
        String[] dna9 = {"GTCAGT",
                         "ATCTGG",
                         "GTCTGA",
                         "ACGTTG",
                         "CGCGTG",
                         "TAGACA"};
        System.out.println("Matriz");
        mostrarMatriz(arrayToMatriz(dna9));
        System.out.println("Resultado " + isMutant(dna9));

        System.out.println("\n");
        String[] dna10 = {"AAAAAA",
                          "AAAAAA",
                          "CGCTGC",
                          "TCGCGT",
                          "ATGAAC",
                          "ACCTGC"};
        System.out.println("Matriz");
        mostrarMatriz(arrayToMatriz(dna10));
        System.out.println("Resultado " + isMutant(dna10));

        System.out.println("\n");
        String[] dna11 = {"AACCAA",
                "AAACAA",
                "CGAAGC",
                "TCAAGT",
                "ATGAAC",
                "ACCTGC"};
        System.out.println("Matriz");
        mostrarMatriz(arrayToMatriz(dna11));
        System.out.println("Resultado " + isMutant(dna11));

    }

    
    public static boolean isMutant(String[] dna) {
        boolean isMutant = false;
        int contador = 0 ;
        char[][] dnaChar = arrayToMatriz(dna);
        try {
            //llamado a funciones de busqueda
            contador+= busquedaDiagonal(dnaChar);
            System.out.println("Diagonales -> " + contador);
            contador+= busquedaHorizontal(dnaChar);
            System.out.println("Diagonales + Horizontales -> " + contador);
            contador+=busquedaVertical(dnaChar);
            System.out.println("Diagonales + Horizontales + Verticales -> " + contador);
            if (contador > 1){
                //si hay mas de uno es mutante
                isMutant = true;
            }
        }catch (Exception e){
            //en caso de falla muestra el error
            System.out.println(e);
        }
        //retorno si es mutante
        return  isMutant;
    }

    public static int busquedaDiagonal(char[][] a) throws Exception{
        //verifica que la matriz sea cuadrada
        if(a.length != a[0].length)
            throw new Exception("La matriz no es cuadrada");
        String secuenciaDiagonalIzq = "";
        String secuenciaDiagonalDer = "";
        int contador = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (i == j){
                    //si los iteradores son iguales guarda el caracter en un string
                    secuenciaDiagonalIzq += a[i][j];
                }else if (i + j == a.length-1) {
                    //si no si la sumatoria de los iteradores es igual al tamanio de la matriz menos 1, almacena el caracter en otro string
                    secuenciaDiagonalDer += a[i][j];
                }
            }
        }
        //si alguno de ambos string contienen alguna combinacion devuelve un entero que representa la cantidad de secuencias encontradas
        if (secuenciaDiagonalIzq.contains("AAAA")||secuenciaDiagonalIzq.contains("TTTT")||secuenciaDiagonalIzq.contains("GGGG")||secuenciaDiagonalIzq.contains("CCCC")){
            //suma uno al contador
            contador+=1;
        }
        //pregunto lo mismo para el segundo string
        if(secuenciaDiagonalDer.contains("AAAA")||secuenciaDiagonalDer.contains("TTTT")||secuenciaDiagonalDer.contains("GGGG")||secuenciaDiagonalDer.contains("CCCC")){
            //se suma uno al contador
            contador+=1;
        }
        //retorno el contador
        return contador;
    }

    public static int busquedaVertical(char[][] a){
        String secuenciaVertical = "";
        int contador = 0;
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                //con 2 bucles realizo una busqueda y guarda los caracteres en un string
                secuenciaVertical += a[j][i];
            }
            //con un condicional pregunto si contiene alguna secuencia mutante
            if(secuenciaVertical.contains("AAAA")||secuenciaVertical.contains("TTTT")||secuenciaVertical.contains("GGGG")||secuenciaVertical.contains("CCCC")){
                //si contiene se suma 1 al contador
                contador +=1;
            }
            secuenciaVertical = "";
        }
        //devuelve el contador
        return contador;
    }

    public static int busquedaHorizontal(char[][] a){
        String secuenciaHorizontal = "";
        int contador = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                //con dos bucles se realiza una busqueda horizontal
                secuenciaHorizontal += a[i][j];
            }
            //con un condicional pregunto si contiene alguna secuencia mutante
            if(secuenciaHorizontal.contains("AAAA")||secuenciaHorizontal.contains("TTTT")||secuenciaHorizontal.contains("GGGG")||secuenciaHorizontal.contains("CCCC")){
                //si contiene se suma 1 al contador
                contador+=1;
            }
            secuenciaHorizontal = "";
        }
        //retorno el contador
        return contador;
    }

    public static char[][] arrayToMatriz(String[] a){
        char[][] c = new char[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].toCharArray().length; j++) {
                //convierto cada String en un Array de caracteres y los almaceno como una fila en una matriz de caracteres
                c[i][j] = a[i].toCharArray()[j];
            }
        }
        //retorno la matriz
        return c;
    }

    public static void mostrarMatriz(char[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}