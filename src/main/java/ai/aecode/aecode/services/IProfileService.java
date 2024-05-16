package ai.aecode.aecode.services;

import ai.aecode.aecode.dtos.LoginDTO;
import ai.aecode.aecode.entities.Profile;

import java.util.List;

public interface IProfileService {
    public void insert(Profile profile);
    List<Profile> list();
    public void delete(int id_profile);
    public Profile listId(int id_profile);
    public void update(Profile profile);
    public Profile findByUsernameOrEmail(LoginDTO logindto);
}
