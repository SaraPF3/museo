package es.etg.dam.sala;

import lombok.Data;

@Data
public class Sala {
    
    private int aforo = 100;

    synchronized public void incrementar() {
        aforo++;
    }

    synchronized public void decrementar() {
        aforo--;
    }
}
