package com.bewise.challenges.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting {


	public static List<Jugador> ordenarPorPuntuacionYNombre(List<Jugador> jugadores){

        Collections.sort(jugadores, new Comparator<Jugador>() {
            public int compare(Jugador obj1, Jugador obj2) {
                if(obj1.getPuntuacion() == obj2.getPuntuacion()){
                    return obj1.getNombre().compareTo(obj2.getNombre());
                }
                return obj1.getPuntuacion() > obj2.getPuntuacion()?-1:1;
            }
        });
        return jugadores;
	}

   
	public static List<Jugador> ordenarPorPuntuacionPerdidasYNombre(List<Jugador> jugadores){
        Collections.sort(jugadores, new Comparator<Jugador>() {
            public int compare(Jugador obj1, Jugador obj2) {
                if(obj1.getPuntuacion() == obj2.getPuntuacion()){
                    if(obj1.getPerdidas() == obj2.getPerdidas()){
                        return obj1.getNombre().compareTo(obj2.getNombre());
                    }
                    return obj1.getPerdidas() > obj2.getPerdidas()?1:-1;
                }
                return obj1.getPuntuacion() > obj2.getPuntuacion()?-1:1;
            }
        });
        return jugadores;
	}
}
