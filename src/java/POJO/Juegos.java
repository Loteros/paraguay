package POJO;
// Generated 17-abr-2014 19:04:36 by Hibernate Tools 3.6.0



/**
 * Juegos generated by hbm2java
 */
public class Juegos  implements java.io.Serializable {


     private String idJuego;
     private String nombreJuego;
     private long precioApuesta;
     private int numeroApuestasMinimas;

    public Juegos() {
    }

    public Juegos(String idJuego, String nombreJuego, long precioApuesta, int numeroApuestasMinimas) {
       this.idJuego = idJuego;
       this.nombreJuego = nombreJuego;
       this.precioApuesta = precioApuesta;
       this.numeroApuestasMinimas = numeroApuestasMinimas;
    }
   
    public String getIdJuego() {
        return this.idJuego;
    }
    
    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }
    public String getNombreJuego() {
        return this.nombreJuego;
    }
    
    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }
    public long getPrecioApuesta() {
        return this.precioApuesta;
    }
    
    public void setPrecioApuesta(long precioApuesta) {
        this.precioApuesta = precioApuesta;
    }
    public int getNumeroApuestasMinimas() {
        return this.numeroApuestasMinimas;
    }
    
    public void setNumeroApuestasMinimas(int numeroApuestasMinimas) {
        this.numeroApuestasMinimas = numeroApuestasMinimas;
    }




}


