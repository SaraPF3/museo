# Museo

Hecho por Sara Pérez

> El link al repositorio es: <https://github.com/SaraPF3/museo>

La clase **App** tiene el main en el que se ejecutan los hilos entrada y salida:

```java
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
```

La clase **Sala** tiene el aforo inicial y los métodos para aumentar y disminuir dicho aforo:

```java
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
```

La clase **Entrada** tiene en su método **run()** el método **incrementar()** de la clase **Sala**:

```java
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
```

La clase **Salida** tiene en su método **run()** el método **decrementar()** de la clase **Sala**:

```java
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
```
