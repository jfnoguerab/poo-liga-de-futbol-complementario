package models;

import java.util.Arrays;

public class Jugador {
    private String nombre;
    private Equipo equipo;
    private int id;

    // contador de instancias
    private static int cont = 0;

    // Variables para mostrar los datos
    // en una tabla
    public static int longestNameSize = 0;
    public static int longestTeamNameSize = 0;


    public Jugador(){}

    public Jugador(String nombre, Equipo equipo) {
        this.setNombre(nombre);
        this.setEquipo(equipo);
        cont++;
        this.id = cont;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        if (this.nombre.length() > longestNameSize) {
            longestNameSize = this.nombre.length();
        }
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
        if (this.equipo != null) {
            if (this.equipo.getNombre().length() > longestTeamNameSize) {
                longestTeamNameSize = this.equipo.getNombre().length();
            }
        }
    }

    public static boolean isEmpty() {
        // validamos si el contador de instancias está vacío
        return cont == 0;
    }
    
    public static void printAllJugadores(Jugador[] jugadores, String emptyDataMsg) {
        if (jugadores != null && jugadores[0] != null) {
            // Cabeceras
            // Calculamos los anchos de las columnas
            int numColWide = Integer.toString(cont).length() + 2;
            int idColWide = Integer.toString(cont).length() + 2;
            int nameColWide = (longestNameSize > "nombre".length() ? longestNameSize : "nombre".length()) + 2;
            int teamNameColWide = (longestTeamNameSize > "Sin equipo".length() ? longestTeamNameSize : "Sin equipo".length()) + 2;

            // Creamos el formato de las cabeceras
            String formatHeader = "| %-"+ numColWide +"s "
                            .concat("| %-"+ idColWide +"s ")
                            .concat("| %-"+ nameColWide +"s ")
                            .concat("| %-"+ teamNameColWide +"s |%n");

            // Calculamos el total del ancho de la tabla
            int totalLines = 13 + numColWide + idColWide + nameColWide + teamNameColWide;

            // Imprimimos el borde superior de la tabla
            System.out.printf("-".repeat(totalLines) + "%n");
            
            // Imprimimos las cabeceras de las columnas
            System.out.printf(formatHeader, "#", "ID", "NOMBRE", "EQUIPO");

            // Imprimimos el borde que divide las cabeceras del contenido
            System.out.printf("-".repeat(totalLines) + "%n");
            

            // Contenido
            // Creamos el formato del contenido
            String formatContent = "| %-"+ numColWide +"s "
                            .concat("| %-"+ idColWide +"s ")
                            .concat("| %-"+ nameColWide +"s ")
                            .concat("| %-"+ teamNameColWide +"s |%n");


            // Imprimimos el contenido
            int num = 1;
            for (Jugador jugador : jugadores) {

                System.out.printf(formatContent, num,
                                                jugador.getId(), 
                                                jugador.getNombre(),
                                                jugador.equipo != null ? jugador.equipo.getNombre() : "Sin equipo");
                num++;
            }
            // Imprimimos el borde inferior para cerrar la tabla
            System.out.printf("-".repeat(totalLines) + "%n");


        } else {
            System.out.println(emptyDataMsg);
        }
    }
    
    public static void printListJugadores(Jugador[] jugadores, String emptyDataMsg) {
        if (jugadores != null && jugadores[0] != null) {
            // Cabeceras
            // Calculamos los anchos de las columnas
            int numColWide = Integer.toString(cont).length() + 2;
            int nameColWide = (longestNameSize > "nombre".length() ? longestNameSize : "nombre".length()) + 2;

            // Creamos el formato de las cabeceras
            String formatHeader = "| %-"+ numColWide +"s "
                            .concat("| %-"+ nameColWide +"s |%n");

            // Calculamos el total del ancho de la tabla
            int totalLines = 7 + numColWide  + nameColWide;

            // Imprimimos el borde superior de la tabla
            System.out.printf("-".repeat(totalLines) + "%n");
            
            // Imprimimos las cabeceras de las columnas
            System.out.printf(formatHeader, "#", "NOMBRE");

            // Imprimimos el borde que divide las cabeceras del contenido
            System.out.printf("-".repeat(totalLines) + "%n");
            

            // Contenido
            // Creamos el formato del contenido
            String formatContent = "| %-"+ numColWide +"s "
                            .concat("| %-"+ nameColWide +"s |%n");


            // Imprimimos el contenido
            int num = 1;
            for (Jugador jugador : jugadores) {

                System.out.printf(formatContent, num,
                                                jugador.getNombre());
                num++;
            }
            // Imprimimos el borde inferior para cerrar la tabla
            System.out.printf("-".repeat(totalLines) + "%n");


        } else {
            System.out.println(emptyDataMsg);
        }
    }
    
    public static void printListJugadores(Jugador[] jugadores, Equipo equipo, String emptyDataMsg) {
        if (jugadores != null && jugadores[0] != null) {
            // Cabeceras
            // Calculamos los anchos de las columnas
            int numColWide = Integer.toString(cont).length() + 2;
            int nameColWide = (longestNameSize > "nombre".length() ? longestNameSize : "nombre".length()) + 2;

            // Creamos el formato de las cabeceras
            String formatHeader = "| %-"+ numColWide +"s "
                            .concat("| %-"+ nameColWide +"s |%n");

            // Calculamos el total del ancho de la tabla
            int totalLines = 7 + numColWide  + nameColWide;

            // Imprimimos el borde superior de la tabla
            System.out.printf("-".repeat(totalLines) + "%n");
            
            // Imprimimos las cabeceras de las columnas
            System.out.printf(formatHeader, "#", "NOMBRE");

            // Imprimimos el borde que divide las cabeceras del contenido
            System.out.printf("-".repeat(totalLines) + "%n");
            

            // Contenido
            // Creamos el formato del contenido
            String formatContent = "| %-"+ numColWide +"s "
                            .concat("| %-"+ nameColWide +"s |%n");


            // Imprimimos el contenido
            int num = 1;
            for (Jugador jugador : jugadores) {
                if (jugador.getEquipo() == equipo) {
                    System.out.printf(formatContent, num,
                                                    jugador.getNombre());
                }
                num++;
            }
            // Imprimimos el borde inferior para cerrar la tabla
            System.out.printf("-".repeat(totalLines) + "%n");


        } else {
            System.out.println(emptyDataMsg);
        }
    }
    
    public static void printJugador(int indice, Jugador jugador) {
        if (jugador != null) {
            // Cabeceras
            // Calculamos los anchos de las columnas
            int numColWide = Integer.toString(cont).length() + 2;
            int idColWide = Integer.toString(cont).length() + 2;
            int nameColWide = (longestNameSize > "nombre".length() ? longestNameSize : "nombre".length()) + 2;
            int teamNameColWide = (longestTeamNameSize > "Sin equipo".length() ? longestTeamNameSize : "Sin equipo".length()) + 2;

            // Creamos el formato de las cabeceras
            String formatHeader = "| %-"+ numColWide +"s "
                            .concat("| %-"+ idColWide +"s ")
                            .concat("| %-"+ nameColWide +"s ")
                            .concat("| %-"+ teamNameColWide +"s |%n");

            // Calculamos el total del ancho de la tabla
            int totalLines = 13 + numColWide + idColWide + nameColWide + teamNameColWide;

            // Imprimimos el borde superior de la tabla
            System.out.printf("-".repeat(totalLines) + "%n");
            
            // Imprimimos las cabeceras de las columnas
            System.out.printf(formatHeader, "#", "ID", "NOMBRE", "EQUIPO");

            // Imprimimos el borde que divide las cabeceras del contenido
            System.out.printf("-".repeat(totalLines) + "%n");
            

            // Contenido
            // Creamos el formato del contenido
            String formatContent = "| %-"+ numColWide +"s "
                            .concat("| %-"+ idColWide +"s ")
                            .concat("| %-"+ nameColWide +"s ")
                            .concat("| %-"+ teamNameColWide +"s |%n");


            // Imprimimos el contenido
            System.out.printf(formatContent, indice,
                                            jugador.getId(), 
                                            jugador.getNombre(),
                                            jugador.equipo != null ? jugador.equipo.getNombre() : "Sin equipo");
            // Imprimimos el borde inferior para cerrar la tabla
            System.out.printf("-".repeat(totalLines) + "%n");


        }
    }

    public static Jugador[] eliminarJugador(Jugador[] jugadoresArr, Jugador jugador) {
        int newSize = jugadoresArr.length - 1;
        if (newSize <= 0) {
            newSize = 1;
            // Reiniciamos el contador de instancias
            cont = 0;
        }
        Jugador[] jugadoresUpArr = new Jugador[newSize];
        int index = 0;
        if (jugadoresArr != null && jugadoresArr[0] != null){
            for (Jugador itemJugador : jugadoresArr) {
                if (itemJugador != jugador) {
                    jugadoresUpArr[index] = itemJugador;
                    index++;
                }
                
            }
        }
        return jugadoresUpArr;
    }
    
    public static Jugador[] eliminarJugador(Jugador[] jugadoresArr, Integer[] listIds) {
        int newSize = jugadoresArr.length - listIds.length;
        if (newSize <= 0) {
            newSize = 1;
            // Reiniciamos el contador de instancias
            cont = 0;
        }
        Jugador[] jugadoresUpArr = new Jugador[newSize];
        int index = 0;
        if (jugadoresArr != null && jugadoresArr[0] != null){
            for (Jugador itemJugador : jugadoresArr) {
                if (!existId(listIds, itemJugador.getId())) {
                    jugadoresUpArr[index] = itemJugador;
                    index++;
                }
            }
        }
        return jugadoresUpArr;
    }

    private static boolean existId(Integer[] listIds, Integer idJugador) {
        for (Integer id : listIds) {
            if (id == idJugador) {
                return true;
            }
        }
        return false;
    }
    
    public static int contarJugadoresByEquipo(Jugador[] jugadoresArr, Equipo equipo) {
        int totalJugadores = 0;
        if (jugadoresArr != null && jugadoresArr[0] != null){
            for (Jugador itemJugador : jugadoresArr) {
                if (itemJugador.getEquipo() == equipo) {
                    totalJugadores++;
                }
                
            }
        }
        return totalJugadores;
    }

    public static Integer[] getIdsJugadoresRelatedToEquipo(Jugador[] jugadoresArr, Equipo equipo) {
        Integer[] listJugadoresArr = new Integer[1];
        int i = 0;
        if (jugadoresArr != null && jugadoresArr[0] != null){
            for (Jugador jugador : jugadoresArr) {
                if (jugador.getEquipo() == equipo) {
                    // Si ya hay registrado algún id debemos aumentar en 1 el tamaño del arreglo
                    if (listJugadoresArr[listJugadoresArr.length - 1] != null) {
                        listJugadoresArr = Arrays.copyOf(listJugadoresArr, listJugadoresArr.length + 1);
                    }
                    // Asignamos el id
                    listJugadoresArr[i] =  jugador.getId();
                    i++;
                }
            }
        }

        return listJugadoresArr[0] == null ? null : listJugadoresArr;
    }
    
    public static void updateRelationshipWithEquipo(Jugador[] jugadoresArr, int idEquipo, Equipo upEquipo) {
        if (jugadoresArr != null && jugadoresArr[0] != null){
            for (int i = 0; i < jugadoresArr.length; i++) {
                if (jugadoresArr[i].getEquipo().getId() == idEquipo) {
                    jugadoresArr[i].setEquipo(upEquipo);
                }
            }
        }
    }
}
