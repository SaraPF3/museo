package es.etg.dam.puerta.entrada;

import es.etg.dam.sala.Sala;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Entrada implements Runnable {

    private final Sala sala;

    @Override
    public void run() {
        sala.incrementar();
    }
}
