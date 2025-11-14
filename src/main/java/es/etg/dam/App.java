package es.etg.dam;

import es.etg.dam.puerta.entrada.Entrada;
import es.etg.dam.puerta.salida.Salida;
import es.etg.dam.sala.Sala;

public class App {

    public static final int PERSONAS_ENTRAN = 10;
    public static final int PERSONAS_SALEN = 15;
    public static final int VAL_I = 1;
    public static final String TXT_SALA = "En la sala hay ";
    public static final String PERSONAS = " personas";

    public static void main(String[] args) {
        
        Sala sala = new Sala();

        for (int i = VAL_I; i <= PERSONAS_ENTRAN; i++){
            Thread entrada = new Thread (new Entrada(sala));
            entrada.start();
        }

        for (int i = VAL_I; i <= PERSONAS_SALEN; i++){
            Thread salida = new Thread (new Salida(sala));
            salida.start();
        }

        System.out.println(TXT_SALA + sala.getAforo() + PERSONAS);
    }
}