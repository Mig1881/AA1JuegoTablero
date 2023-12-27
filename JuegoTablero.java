package com.svalero.juegotablero;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static com.svalero.juegotablero.util.Constantes.*;

public class JuegoTablero {

    private String[][] tableroJugador1;
    private String[][] tableroJugador2;


    //private Scanner teclado;
    private String nombreJugador1;
    private String nombreJugador2;
    private int vidas;
    private int numeroVidas1;
    private int numeroVidas2;
    private String Dificultad;
    private String Dificultad2;

    private int numEnemigos;
    private int numEnemigos2;
    boolean juegoTerminadoJ1;
    boolean juegoTerminadoJ2;
    boolean numEnemigosCorrecto;
    boolean numEnemigosCorrecto2;

    Scanner teclado = new Scanner(System.in);
    Random generador = new Random();


    public JuegoTablero() {}




    public void jugar() {
        crearTableros();
        pedirNombreJugador();
        elegirNivelDificultad(JUGADOR1);
        elegirNivelDificultad(JUGADOR2);

        inicializacionJuego();
        do {

            boolean juegoAcabado = false;

            do {

              if (!juegoTerminadoJ1) {
                  representarTablero(JUGADOR1);
                  if (numeroVidas1 > 0) {
                          System.out.println(NUMERO_DE_VIDAS + numeroVidas1);
                  }
                  movimientoJugador(JUGADOR1);
                  if ((numeroVidas1 > 0) && (!juegoTerminadoJ1) && (!juegoTerminadoJ2)){
                      representarTablero(JUGADOR1);
                      System.out.println(NUMERO_DE_VIDAS + numeroVidas1);
                  }
              }
              if (!juegoTerminadoJ2) {
                  representarTablero(JUGADOR2);
                  if (numeroVidas2 > 0) {
                      System.out.println(NUMERO_DE_VIDAS + numeroVidas2);
                  }
                  movimientoJugador(JUGADOR2);
                  if ((numeroVidas2 > 0) && (!juegoTerminadoJ1) && (!juegoTerminadoJ2)){
                      representarTablero(JUGADOR2);
                      System.out.println(NUMERO_DE_VIDAS + numeroVidas2);
                  }

              }

              if (juegoTerminadoJ1 && juegoTerminadoJ2) {
                    juegoAcabado = true;
              }

            } while (!juegoAcabado);

            System.out.println();
            System.out.print("¿Quereis volver a jugar (S/N)? ");
            String respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("S")) {
                elegirNivelDificultad(JUGADOR1);
                elegirNivelDificultad(JUGADOR2);
                inicializacionJuego();
            } else {
                break;
            }

        } while (true);

    }

    private void crearTableros(){
        tableroJugador1 = new String[6][6];
        tableroJugador2 = new String[6][6];

    }
    private void inicializarTableros(){
        //Inicializamos tableros y numero de vidas
        for (String[] fila : tableroJugador1) {
            Arrays.fill(fila, CASILLA_VACIA);
        }
        for (String[] fila : tableroJugador2) {
            Arrays.fill(fila, CASILLA_VACIA);
        }

        numeroVidas1 = 3;
        numeroVidas2 = 3;
        juegoTerminadoJ1 = false;
        juegoTerminadoJ2 = false;
    }

    private void representarTablero(String tablero) {

        if (tablero.equals(JUGADOR1)) {
            System.out.println();
            System.out.println("Tablero de " + nombreJugador1);
            System.out.println();
            for (String[] fila : tableroJugador1) {
                for (String casilla : fila) {
                //TODO  de momento lo anulo para ir HACIENDO PRUEBAS MEJOR
                //    if (casilla.equals(FICHA_ENEMIGO1)) {
                //        System.out.print(CASILLA_VACIA);
                //    } else {
                        System.out.print(casilla);
                //    }
                }
                System.out.println();
            }

        } else {
            System.out.println();
            System.out.println("Tablero de " + nombreJugador2);
            System.out.println();

            for (String[] fila : tableroJugador2) {
                for (String casilla : fila) {
                    if (casilla.equals(FICHA_ENEMIGO2)) {
                        System.out.print(CASILLA_VACIA);
                    } else {
                        System.out.print(casilla);
                    }
                }
                System.out.println();
            }
        }
    }

    private void pedirNombreJugador(){
        System.out.print("Nombre Jugador 1: ");
        nombreJugador1 = teclado.nextLine();
        System.out.print("Nombre Jugador 2: ");
        nombreJugador2 = teclado.nextLine();

    }

    private void elegirNivelDificultad(String jugador) {

        numEnemigosCorrecto2 = false;
        if (jugador.equals(JUGADOR1)) {
            numEnemigosCorrecto = false;
            do {
                System.out.print(ANSI_LETRA_VERDE + nombreJugador1 + ANSI_RESET  + " elige el Nivel de difilcutad, elige entre los valores 1,2,3: ");
                Dificultad = teclado.nextLine();
                switch (Dificultad) {
                    case "1":
                        numEnemigos = 8;
                        numEnemigosCorrecto = true;
                        break;
                    case "2":
                        numEnemigos = 9;
                        numEnemigosCorrecto = true;
                        break;
                    case "3":
                        numEnemigos = 10;
                        numEnemigosCorrecto = true;
                        break;
                    default:
                        System.out.println("Valor no correcto");
                }

            } while (!numEnemigosCorrecto);
        } else {
            numEnemigosCorrecto2 = false;
            do {
                //System.out.println(ANSI_BLANCO_FONDO + nombreJugador1 + MENSAJE_FINAL);
                System.out.print(ANSI_LETRA_VERDE + nombreJugador2 + ANSI_RESET + " elige el Nivel de difilcutad, elige entre 1,2,3: ");
                Dificultad2 = teclado.nextLine();
                switch (Dificultad2) {
                    case "1":
                        numEnemigos2 = 8;
                        numEnemigosCorrecto2 = true;
                        break;
                    case "2":
                        numEnemigos2 = 9;
                        numEnemigosCorrecto2 = true;
                        break;
                    case "3":
                        numEnemigos2 = 10;
                        numEnemigosCorrecto2 = true;
                        break;
                    default:
                        System.out.println("Valor no correcto");
                }

            } while (!numEnemigosCorrecto2);
        }

    }
    private void colocarCasillaDeSalida() {
        int i, j;
        //Generamos casilla salida Jugador 1

        i = generador.nextInt(6);
        j = generador.nextInt(6);
        tableroJugador1[i][j]=CASILLA_SALIDA;
        //Generamos casilla salida Juagador 2

        i = generador.nextInt(6);
        j = generador.nextInt(6);
        tableroJugador2[i][j]=CASILLA_SALIDA;


    }
    private void colocarEnemigos(){
        int x = 0, i = 0, j;
        for (x =0; x < numEnemigos; x++) {
            do {
                i = generador.nextInt(6);
                j = generador.nextInt(6);
            } while ((!tableroJugador1[i][j].equals(CASILLA_VACIA)) || (tableroJugador1[i][j].equals(CASILLA_SALIDA)));
            tableroJugador1[i][j]=FICHA_ENEMIGO1;
        }
        int y;
        for (y =0; y < numEnemigos2; y++) {
            do {
                i = generador.nextInt(6);
                j = generador.nextInt(6);
            } while ((!tableroJugador2[i][j].equals(CASILLA_VACIA)) || (tableroJugador2[i][j].equals(CASILLA_SALIDA)));
            tableroJugador2[i][j]=FICHA_ENEMIGO2;
        }

    }

    private void colocarJugador(){
        int i, j;
        //Colocamos al Jugador1
        do{
            i = generador.nextInt(6);
            j = generador.nextInt(6);
        } while ((!tableroJugador1[i][j].equals(CASILLA_VACIA)) || (tableroJugador1[i][j].equals(CASILLA_SALIDA)));
        tableroJugador1[i][j]=FICHA_JUGADOR1;
        //Colocamos al jugador2
        do{
            i = generador.nextInt(6);
            j = generador.nextInt(6);
        } while ((!tableroJugador2[i][j].equals(CASILLA_VACIA)) || (tableroJugador2[i][j].equals(CASILLA_SALIDA)));
        tableroJugador2[i][j]=FICHA_JUGADOR2;
    }
    private void inicializacionJuego(){
        inicializarTableros();
        colocarCasillaDeSalida();
        colocarJugador();
        colocarEnemigos();
    }


    private void  movimientoJugador(String jugador){
        boolean movimientoCorrecto = false;
        int desplazamiento = 0;
        int coordI = 0;
        int coordJ = 0;
        int coordCalculadaI = 0;
        int coordCalculadaJ = 0;

        if (jugador.equals(JUGADOR1)) {
            do {
                System.out.println(" Recuerda: (1,2,3) nº casillas movimiento, (A,D,W,S) Direccion. (Ejemplo: 1A) ");
                System.out.print("Movimiento " + nombreJugador1 + ": ");
                String movimiento = teclado.nextLine();
                if (movimiento.length() != 2) {
                    System.out.println("No has metido bien la direccion, vuelve a intertarlo");
                    representarTablero(JUGADOR1);
                    continue;
                }
                //Funcion para averiguar dende esta posicionado Jugador1
                String coord = averiguarCoordenada(JUGADOR1);
                //Funciones para pasar la coordenada a numero
                coordI=coordenadaI(coord);
                coordJ=coordenadaJ(coord);

                //Calculo del movimiento
                switch (movimiento.toUpperCase()) {
                    case "1A":
                        if ((coordJ -1) < 0) {
                            coordCalculadaJ = 5;
                        } else {
                            coordCalculadaJ = coordJ -1;
                        }
                        coordCalculadaI = coordI;
                        movimientoCorrecto = true;
                        break;
                    case "1D":
                        if ((coordJ +1) > 5) {
                            coordCalculadaJ = 0;
                        } else {
                            coordCalculadaJ = coordJ + 1;
                        }
                        coordCalculadaI = coordI;
                        movimientoCorrecto = true;
                        break;
                    case "1W":
                        if ((coordI -1) < 0) {
                            coordCalculadaI = 5;
                        } else {
                            coordCalculadaI = coordI - 1;
                        }
                        coordCalculadaJ = coordJ;
                        movimientoCorrecto = true;
                        break;
                    case "1S":
                        if ((coordI +1) > 5) {
                            coordCalculadaI = 0;
                        } else {
                            coordCalculadaI = coordI + 1;
                        }
                        coordCalculadaJ = coordJ;
                        movimientoCorrecto = true;
                        break;
                    case "2A":
                        if ((coordJ -2) < 0) {
                            if (coordJ-2 == -2) {
                                coordCalculadaJ = 4;
                            } else {
                                coordCalculadaJ = 5;
                            }
                        } else {
                            coordCalculadaJ = coordJ -2;
                        }
                        coordCalculadaI = coordI;
                        movimientoCorrecto = true;
                        break;
                    case "2D":
                        if ((coordJ + 2) > 5) {
                            //    coordIntermedia= coordJ -2;
                            if (coordJ+2 == 7) {
                                coordCalculadaJ = 1;
                            } else {
                                coordCalculadaJ = 0;
                            }
                        } else {
                            coordCalculadaJ = coordJ +2;
                        }
                        coordCalculadaI = coordI;
                        movimientoCorrecto = true;
                        break;
                    case "2W":
                        if ((coordI -2) < 0) {
                            if (coordI-2 == -2) {
                                coordCalculadaI = 4;
                            } else {
                                coordCalculadaI = 5;
                            }

                        } else {
                            coordCalculadaI = coordI - 2;
                        }
                        coordCalculadaJ = coordJ;
                        movimientoCorrecto = true;

                        break;
                    case "2S":
                        if ((coordI +2) > 5) {
                            if (coordI + 2 == 7) {
                                coordCalculadaI = 1;
                            } else {
                                coordCalculadaI = 0;
                            }
                        } else {
                            coordCalculadaI = coordI + 2;
                        }
                        coordCalculadaJ = coordJ;
                        movimientoCorrecto = true;
                        break;
                    case "3A":
                        if ((coordJ -3) < 0) {
                            if (coordJ-3 == -3) {
                                coordCalculadaJ = 3;
                            } else {
                                if (coordJ-3 == -2){
                                    coordCalculadaJ = 4;
                                } else {
                                    coordCalculadaJ = 5;
                                }
                            }
                        } else {
                            coordCalculadaJ = coordJ -3;
                        }
                        coordCalculadaI = coordI;
                        movimientoCorrecto = true;
                        break;
                    case "3D":
                        if ((coordJ + 3) > 5) {
                            //    coordIntermedia= coordJ -2;
                            if (coordJ+3 == 8) {
                                coordCalculadaJ = 2;
                            } else {
                                if (coordJ+3 == 7){
                                    coordCalculadaJ = 1;
                                } else {
                                    coordCalculadaJ = 0;
                                }
                            }
                        } else {
                            coordCalculadaJ = coordJ +3;
                        }
                        coordCalculadaI = coordI;
                        movimientoCorrecto = true;
                        break;
                    case "3W":
                        if ((coordI -3) < 0) {
                            if (coordI-3 == -3) {
                                coordCalculadaI = 3;
                            } else {
                                if (coordI -3 == -2){
                                    coordCalculadaI = 4;
                                } else {
                                    coordCalculadaI = 5;
                                }
                            }
                        } else {
                            coordCalculadaI = coordI - 3;
                        }
                        coordCalculadaJ = coordJ;
                        movimientoCorrecto = true;
                        break;
                    case "3S":
                        if ((coordI +3) > 5) {
                            if (coordI + 3 == 8) {
                                coordCalculadaI = 2;
                            } else {
                                if (coordI + 3 == 7){
                                    coordCalculadaI = 1;
                                } else {
                                    coordCalculadaI = 0;
                                }
                            }
                        } else {
                            coordCalculadaI = coordI + 3;
                        }
                        coordCalculadaJ = coordJ;
                        movimientoCorrecto = true;
                        break;
                    default:
                        System.out.println("Movimiento no valido, vuelva a repetirlo");
                        representarTablero(JUGADOR1);
                }
            } while (!movimientoCorrecto);
            if (movimientoCorrecto) {

                if (tableroJugador1[coordCalculadaI][coordCalculadaJ].equals(CASILLA_SALIDA)){
                    tableroJugador1[coordI][coordJ] = CASILLA_VACIA;
                    tableroJugador1[coordCalculadaI][coordCalculadaJ] = FICHA_JUGADOR1;
                    representarTablero(JUGADOR1);
                    System.out.println(ANSI_BLANCO_FONDO + nombreJugador1 + MENSAJE_FINAL_GANADOR);
                    juegoTerminadoJ1 = true;
                } else {
                    if (tableroJugador1[coordCalculadaI][coordCalculadaJ].equals(FICHA_ENEMIGO1)) {
                        numeroVidas1--;
                        System.out.println(MENSAJE_BOMBA);
                        if (numeroVidas1 == 0) {
                            tableroJugador1[coordI][coordJ] = CASILLA_VACIA;
                            tableroJugador1[coordCalculadaI][coordCalculadaJ] = FICHA_JUGADOR1;
                            representarTablero(JUGADOR1);
                            System.out.println(ANSI_BLANCO_FONDO + nombreJugador1 + MENSAJE_FINAL);
                            juegoTerminadoJ1 = true;
                            // TODO PODRIA VISUALIZAR ALGO ESPECIAL, PENSAR EN QUE
                        }
                    }
                }
                if (!juegoTerminadoJ1) {
                    tableroJugador1[coordI][coordJ] = CASILLA_VACIA;
                    tableroJugador1[coordCalculadaI][coordCalculadaJ] = FICHA_JUGADOR1;
                }
            }
        } else {
            do {
                System.out.println(" Recuerda: (1,2,3) nº casillas movimiento, (A,D,W,S) Direccion. (Ejemplo: 1A) ");
                System.out.print("Movimiento " + nombreJugador2 + ": ");
                String movimiento = teclado.nextLine();
                if (movimiento.length() != 2) {
                    System.out.println("No has metido bien la direccion, vuelve a intertarlo");
                    representarTablero(JUGADOR2);
                    continue;
                }
                //Funcion para averiguar dende esta posicionado Jugador1
                String coord = averiguarCoordenada(JUGADOR2);
                //Funciones para pasar la coordenada a numero
                coordI=coordenadaI(coord);
                coordJ=coordenadaJ(coord);
                //Calculo del movimiento
                switch (movimiento.toUpperCase()) {
                    case "1A":
                        if ((coordJ -1) < 0) {
                            coordCalculadaJ = 5;
                        } else {
                            coordCalculadaJ = coordJ -1;
                        }
                        coordCalculadaI = coordI;
                        movimientoCorrecto = true;
                        break;
                    case "1D":
                        if ((coordJ +1) > 5) {
                            coordCalculadaJ = 0;
                        } else {
                            coordCalculadaJ = coordJ + 1;
                        }
                        coordCalculadaI = coordI;
                        movimientoCorrecto = true;
                        break;
                    case "1W":
                        if ((coordI -1) < 0) {
                            coordCalculadaI = 5;
                        } else {
                            coordCalculadaI = coordI - 1;
                        }
                        coordCalculadaJ = coordJ;
                        movimientoCorrecto = true;
                        break;
                    case "1S":
                        if ((coordI +1) > 5) {
                            coordCalculadaI = 0;
                        } else {
                            coordCalculadaI = coordI + 1;
                        }
                        coordCalculadaJ = coordJ;
                        movimientoCorrecto = true;
                        break;
                    case "2A":
                        if ((coordJ -2) < 0) {
                            if (coordJ-2 == -2) {
                                coordCalculadaJ = 4;
                            } else {
                                coordCalculadaJ = 5;
                            }
                        } else {
                            coordCalculadaJ = coordJ -2;
                        }
                        coordCalculadaI = coordI;
                        movimientoCorrecto = true;
                        break;
                    case "2D":
                        if ((coordJ + 2) > 5) {
                            //    coordIntermedia= coordJ -2;
                            if (coordJ+2 == 7) {
                                coordCalculadaJ = 1;
                            } else {
                                coordCalculadaJ = 0;
                            }
                        } else {
                            coordCalculadaJ = coordJ +2;
                        }
                        coordCalculadaI = coordI;
                        movimientoCorrecto = true;
                        break;
                    case "2W":
                        if ((coordI -2) < 0) {
                            if (coordI-2 == -2) {
                                coordCalculadaI = 4;
                            } else {
                                coordCalculadaI = 5;
                            }

                        } else {
                            coordCalculadaI = coordI - 2;
                        }
                        coordCalculadaJ = coordJ;
                        movimientoCorrecto = true;

                        break;
                    case "2S":
                        if ((coordI +2) > 5) {
                            if (coordI + 2 == 7) {
                                coordCalculadaI = 1;
                            } else {
                                coordCalculadaI = 0;
                            }
                        } else {
                            coordCalculadaI = coordI + 2;
                        }
                        coordCalculadaJ = coordJ;
                        movimientoCorrecto = true;
                        break;
                    case "3A":
                        if ((coordJ -3) < 0) {
                            if (coordJ-3 == -3) {
                                coordCalculadaJ = 3;
                            } else {
                                if (coordJ-3 == -2){
                                    coordCalculadaJ = 4;
                                } else {
                                    coordCalculadaJ = 5;
                                }
                            }
                        } else {
                            coordCalculadaJ = coordJ -3;
                        }
                        coordCalculadaI = coordI;
                        movimientoCorrecto = true;
                        break;
                    case "3D":
                        if ((coordJ + 3) > 5) {
                            //    coordIntermedia= coordJ -2;
                            if (coordJ+3 == 8) {
                                coordCalculadaJ = 2;
                            } else {
                                if (coordJ+3 == 7){
                                    coordCalculadaJ = 1;
                                } else {
                                    coordCalculadaJ = 0;
                                }
                            }
                        } else {
                            coordCalculadaJ = coordJ +3;
                        }
                        coordCalculadaI = coordI;
                        movimientoCorrecto = true;
                        break;
                    case "3W":
                        if ((coordI -3) < 0) {
                            if (coordI-3 == -3) {
                                coordCalculadaI = 3;
                            } else {
                                if (coordI -3 == -2){
                                    coordCalculadaI = 4;
                                } else {
                                    coordCalculadaI = 5;
                                }
                            }
                        } else {
                            coordCalculadaI = coordI - 3;
                        }
                        coordCalculadaJ = coordJ;
                        movimientoCorrecto = true;
                        break;
                    case "3S":
                        if ((coordI +3) > 5) {
                            if (coordI + 3 == 8) {
                                coordCalculadaI = 2;
                            } else {
                                if (coordI + 3 == 7){
                                    coordCalculadaI = 1;
                                } else {
                                    coordCalculadaI = 0;
                                }
                            }
                        } else {
                            coordCalculadaI = coordI + 3;
                        }
                        coordCalculadaJ = coordJ;
                        movimientoCorrecto = true;
                        break;
                    default:
                        System.out.println("Movimiento no valido, vuelva a repetirlo");
                        representarTablero(JUGADOR2);
                }
            } while (!movimientoCorrecto);
            if (movimientoCorrecto) {

                if (tableroJugador2[coordCalculadaI][coordCalculadaJ].equals(CASILLA_SALIDA)){
                    tableroJugador2[coordI][coordJ] = CASILLA_VACIA;
                    tableroJugador2[coordCalculadaI][coordCalculadaJ] = FICHA_JUGADOR2;
                    representarTablero(JUGADOR2);
                    System.out.println(ANSI_BLANCO_FONDO + nombreJugador2 + MENSAJE_FINAL_GANADOR);
                    juegoTerminadoJ2 = true;
                } else {
                    if (tableroJugador2[coordCalculadaI][coordCalculadaJ].equals(FICHA_ENEMIGO2)) {
                        numeroVidas2--;
                        System.out.println(MENSAJE_BOMBA);
                        if (numeroVidas2 == 0) {
                            tableroJugador2[coordI][coordJ] = CASILLA_VACIA;
                            tableroJugador2[coordCalculadaI][coordCalculadaJ] = FICHA_JUGADOR2;
                            representarTablero(JUGADOR2);
                            System.out.println(ANSI_BLANCO_FONDO + nombreJugador2 + MENSAJE_FINAL);
                            juegoTerminadoJ2 = true;
                            // TODO PODRIA VISUALIZAR ALGO ESPECIAL, PENSAR EN QUE
                        }
                    }
                }
                if (!juegoTerminadoJ2) {
                    tableroJugador2[coordI][coordJ] = CASILLA_VACIA;
                    tableroJugador2[coordCalculadaI][coordCalculadaJ] = FICHA_JUGADOR2;
                }
            }
        }
    }

    private String averiguarCoordenada (String casillaABuscar) {
        int i = 0;
        int j = 0;
        int coorNumericaI = 0;
        int coorNumericaJ =0;
        String coordenada = "";


        if (casillaABuscar.equals(JUGADOR1)) {
            for (i = 0; i < 6; i++) {
                for (j = 0; j < 6; j++) {
                    if (tableroJugador1[i][j].equals(FICHA_JUGADOR1)) {
                        coorNumericaI = i;
                        coorNumericaJ = j;
                        break;
                    }
                }
            }
        } else {
            for (i = 0; i < 6; i++) {
                for (j = 0; j < 6; j++) {
                    if (tableroJugador2[i][j].equals(FICHA_JUGADOR2)) {
                        coorNumericaI = i;
                        coorNumericaJ = j;
                        break;
                    }
                }
            }
        }
        coordenada = pasarCoordenadaAString(coorNumericaI,coorNumericaJ);
        return coordenada;


    }
    //
    private String pasarCoordenadaAString (int ejeI,int ejeJ) {
        String coordenada;
        String coordenadaI = String.valueOf(ejeI);
        String coordenadaJ = String.valueOf(ejeJ);
        coordenada=coordenadaI+coordenadaJ;
        return coordenada;
    }

    private int coordenadaI (String coordenada) {
        char coordI=coordenada.charAt(0); //
        String coI = new String();
        coI =coI+coordI;
        int cI=Integer.parseInt(coI);
        return cI;
    }

    private int coordenadaJ (String coordenada) {
        char coordJ=coordenada.charAt(1); //
        String coJ = new String();
        coJ =coJ+coordJ;
        int cJ=Integer.parseInt(coJ);
        return cJ;
    }






}








