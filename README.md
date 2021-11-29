## Prova di laboratorio TPSIT sui thread in Java


Codice da cui partire

```java
public class ProvaLab {
  static public int[] numeri = { 55, 42, 57, 44, 0, 68, 14, 62, 55, 73, 21, 78, 55, 40, 58, 42, 7, 81, 65, 95, 0, 35,
      60, 54, 67, 49, 61, 78, 72, 13, 34, 23, 23, 15, 20, 96, 74, 7, 21, 48, 98, 32, 99, 38, 68, 21, 53, 55, 62, 36, 49,
      80, 84, 76, 38, 16, 73, 62, 89, 29, 75, 56, 64, 5, 89, 63, 2, 13, 79, 27, 53, 76, 21, 28, 94, 13, 73, 35, 82,
      50, 15, 55, 4, 96, 55, 1, 39, 83, 41, 29, 74, 35, 95, 84, 42, 59, 19, 40, 99, 70, 9, 49, 26, 6, 8, 16, 95, 89, 16,
      79, 94, 85, 89, 79, 4, 84, 90, 71, 16, 4, 5, 97, 56, 68, 19, 97, 69, 74, 14, 75, 67, 92, 53, 87, 29, 97, 52, 21,
      37, 6, 11, 6, 51, 96, 27, 16, 49, 45, 22, 41, 95, 29, 82, 68, 92, 40, 95, 22, 83, 58};

  public static void main(String[] args) throws InterruptedException {
    System.out.println("La dimensione dell'array è: " + numeri.length);
    int N = 5;
    int size = numeri.length / N;
    System.out.println("La dimensione delle porzioni è: " + size);
    // Inserisci qui il codice opportuno, utilizza Executors.newFixedThreadPool(N)
    System.out.println("Il Lavoro è terminato");
  }
}


// inserisci qui o in altri file il codice opportuno
// simula il lavoro da fare su i vari numeri con:
// Thread.sleep(ProvaLab.numeri[j]*10);
```

Usare `CountDownLatch` per sincronizzare il lavoro di N thread, ciscuno dei quali lavora su una porzione isolata dell'array `numeri`.
Le porzioni sono:  inizio:`indice=i*size` fino a: `indice<i*size+size`

Ogni thread oltre che simulare il lavoro su ogni elemento deve anche stampare un messaggio del tipo:
*Sono il thread 1: l'elemento 35 dell'array è 96*
