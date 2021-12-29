package com.bewise.challenges.alphabetSoup;
import java.util.ArrayList;
import java.util.List;

public class WordSearcher {

    private char soup[][];

    public WordSearcher(char soup[][]){
        this.soup = soup;
    }
     public boolean isPresent(String word){
        char[] letras = word.toCharArray();
        boolean palabraEncontrada = false;

        int ultimaFila = this.soup.length;
        int ultimaColumnaumna = this.soup[0].length;

        int indiceLetra = 0;
        List<String> memoriaRecorrido = new ArrayList<String>();

        busqueda:
        for(int fila = 0; fila < ultimaFila; fila++){
            for(int columna = 0; columna < ultimaColumnaumna; columna++){
                palabraEncontrada = letraEncontrada(letras, indiceLetra, fila, columna, memoriaRecorrido);
                if(palabraEncontrada){
                    break busqueda;
                }
            }
        }

        return palabraEncontrada;
    }

    private boolean letraEncontrada(char[] letras, int indiceLetra, int fila, int columna, List<String> memoriaRecorrido) {
        boolean palabraEncontrada = false;

        if (letras[indiceLetra] == this.soup[fila][columna]) {
            System.out.println("letra " + letras[indiceLetra] + " encontrada en fila " + fila + " columna " + columna);

            memoriaRecorrido.add(fila +"-"+ columna);

            if(indiceLetra == letras.length-1){
                return true;
            }
            indiceLetra++;

            int filaMas = fila + 1;
            int filaMenos = fila - 1;
            int columnasMas = columna + 1;
            int columnaMenos = columna - 1;
            int ultimaFila = this.soup.length - 1;
            int ultimaColumna = this.soup[0].length - 1;

            if (filaMas <= ultimaFila && !memoriaRecorrido.contains(filaMas + "-" + columna)) {
                palabraEncontrada =  letraEncontrada(letras, indiceLetra, filaMas, columna, memoriaRecorrido);
            }
            if (filaMenos >= 0 && !palabraEncontrada && !memoriaRecorrido.contains(filaMenos + "-" + columna)) {
                palabraEncontrada =  letraEncontrada(letras, indiceLetra, fila - 1, columna, memoriaRecorrido);
            }
            if (columnasMas <= ultimaColumna && !palabraEncontrada && !memoriaRecorrido.contains(fila + "-" + columnasMas)) {
                palabraEncontrada =  letraEncontrada(letras, indiceLetra, fila, columnasMas, memoriaRecorrido);
            }
            if (columnaMenos >= 0 && !palabraEncontrada && !memoriaRecorrido.contains(fila + "-" + columnaMenos)) {
                palabraEncontrada = letraEncontrada(letras, indiceLetra, fila, columnaMenos, memoriaRecorrido);
            }
            if (filaMas <= ultimaFila && columnasMas <= ultimaColumna && !palabraEncontrada && !memoriaRecorrido.contains(filaMas + "-" + columnasMas)) {
                palabraEncontrada =  letraEncontrada(letras, indiceLetra, filaMas, columnasMas, memoriaRecorrido);
            }
            if (filaMenos >= 0 && columnaMenos >= 0 && !palabraEncontrada && !memoriaRecorrido.contains(filaMenos + "-" + columnaMenos)) {
                palabraEncontrada =  letraEncontrada(letras, indiceLetra, filaMenos, columnaMenos, memoriaRecorrido);
            }
            if (filaMenos >= 0 && columnasMas <= ultimaColumna && !palabraEncontrada && !memoriaRecorrido.contains(filaMenos + "-" + columnasMas)) {
                palabraEncontrada =  letraEncontrada(letras, indiceLetra, filaMenos, columnasMas, memoriaRecorrido);
            }
            if (filaMas <= ultimaFila && columnaMenos >= 0 && !palabraEncontrada && !memoriaRecorrido.contains(filaMas + "-" + columnaMenos)) {
                palabraEncontrada = letraEncontrada(letras, indiceLetra, filaMas, columnaMenos, memoriaRecorrido);
            }
        } 
        return palabraEncontrada;
    }
}
