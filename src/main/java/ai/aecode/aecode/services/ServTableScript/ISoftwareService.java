package ai.aecode.aecode.services.ServTableScript;

import ai.aecode.aecode.entities.Software;

import java.util.List;

public interface ISoftwareService {
    public void insert(Software software);
    List<Software> list();
    public void delete(int id_software);
    public Software listId(int id_software);
}
