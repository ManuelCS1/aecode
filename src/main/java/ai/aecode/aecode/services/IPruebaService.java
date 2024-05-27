package ai.aecode.aecode.services;
import ai.aecode.aecode.entities.Prueba;

import java.util.List;

public interface IPruebaService {
    public void insert(Prueba prueba);
    List<Prueba> list();
    public void delete(int id_prueba);
    public Prueba listId(int id_prueba);
}
