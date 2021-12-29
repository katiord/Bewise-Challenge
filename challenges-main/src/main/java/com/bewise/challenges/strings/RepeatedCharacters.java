package com.bewise.challenges.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedCharacters {

    public Boolean isValid(String cadena) {

        Boolean cond1 = Boolean.FALSE;
        Boolean cond2 = Boolean.FALSE;
        Map<Character, Integer> listaCaracterCantidad = new HashMap<Character, Integer>();
        Map<Integer, Integer> listaCantidadDeCantidades = new HashMap<Integer, Integer>();
        List<Integer> listaCantidadDeCantidadesReducida = new ArrayList<Integer>();

        char[] chars = cadena.toCharArray();
        for (Character caracter : chars) {
            if (!listaCaracterCantidad.containsKey(caracter)) {
                listaCaracterCantidad.put(caracter, 1);
            } else {
                Integer cantidad = listaCaracterCantidad.get(caracter);
                cantidad++;
                listaCaracterCantidad.put(caracter, cantidad);
            }
        }

        for (Map.Entry<Character, Integer> caracterCantidad : listaCaracterCantidad.entrySet()) {
            if (!listaCantidadDeCantidades.containsKey(caracterCantidad.getValue())) {
                listaCantidadDeCantidades.put(caracterCantidad.getValue(), 1);
            } else {
                Integer cantidad = listaCantidadDeCantidades.get(caracterCantidad.getValue());
                cantidad++;
                listaCantidadDeCantidades.put(caracterCantidad.getValue(), cantidad);
            }
        }

        if(listaCantidadDeCantidades.size() == 1) {
            cond1 = Boolean.TRUE;
        }
        if (listaCantidadDeCantidades.size() == 2) {
            for (Map.Entry<Integer, Integer> cantidadDeCantidades : listaCantidadDeCantidades.entrySet()) {
                listaCantidadDeCantidadesReducida.add(cantidadDeCantidades.getKey());
            }
            int resultado = listaCantidadDeCantidadesReducida.get(0) - listaCantidadDeCantidadesReducida.get(1);
            if (resultado == 1 || resultado == -1) {
                cond2 = Boolean.TRUE;
            }

        }

        return cond1 || cond2;
    }

}
