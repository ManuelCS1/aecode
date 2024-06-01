package ai.aecode.aecode.services.ServTableScript;

import ai.aecode.aecode.entities.ProgLang;

import java.util.List;

public interface IProgLangService {
    public void insert(ProgLang progLang);
    List<ProgLang> list();
    public void delete(int id_progLang);
    public ProgLang listId(int id_progLang);
}
