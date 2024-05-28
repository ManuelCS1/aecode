package ai.aecode.aecode.dtos;

import jakarta.persistence.Column;

public class PruebaDTO {
    private String nombre;
    private String descripcion;
    private String prueba_multimedia;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrueba_multimedia() {
        return prueba_multimedia;
    }

    public void setPrueba_multimedia(String prueba_multimedia) {
        this.prueba_multimedia = prueba_multimedia;
    }
}
