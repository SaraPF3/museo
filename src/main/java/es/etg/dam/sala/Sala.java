package es.etg.dam.sala;

import lombok.Data;

@Data
public class Sala {
    
    private int aforo = 100;

    public void incrementar() {
        aforo++;
    }

    public void decrementar() {
        aforo--;
    }
}
