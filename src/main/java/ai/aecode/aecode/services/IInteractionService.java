package ai.aecode.aecode.services;

import ai.aecode.aecode.entities.Interaction;
import ai.aecode.aecode.entities.Role;

import java.util.List;

public interface IInteractionService {

    public void insert(Interaction interaction);
    List<Interaction> list();
    public void delete(int id_interaction);
    public Interaction listId(int id_interaction);
}
