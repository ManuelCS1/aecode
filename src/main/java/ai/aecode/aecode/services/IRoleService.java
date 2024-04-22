package ai.aecode.aecode.services;

import ai.aecode.aecode.entities.Role;

import java.util.List;

public interface IRoleService {
    public void insert(Role role);
    List<Role> list();
    public void delete(int id_role);
    public Role listId(int id_role);
}
