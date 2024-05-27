package ai.aecode.aecode.dtos;

public class PruebaDTO {
    private int id_prueba;
    private String prueba_name;
    private String prueba_description;
    private String prueba_multimedia;

    public int getId_prueba() {
        return id_prueba;
    }

    public void setId_prueba(int id_prueba) {
        this.id_prueba = id_prueba;
    }

    public String getPrueba_name() {
        return prueba_name;
    }

    public void setPrueba_name(String prueba_name) {
        this.prueba_name = prueba_name;
    }

    public String getPrueba_description() {
        return prueba_description;
    }

    public void setPrueba_description(String prueba_description) {
        this.prueba_description = prueba_description;
    }

    public String getPrueba_multimedia() {
        return prueba_multimedia;
    }

    public void setPrueba_multimedia(String prueba_multimedia) {
        this.prueba_multimedia = prueba_multimedia;
    }
}
