package es.etg.dam.puerta.salida;

import es.etg.dam.sala.Sala;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Salida implements Runnable{
    
    private final Sala sala;

    @Override
    public void run() {
        sala.decrementar();
    }
}
