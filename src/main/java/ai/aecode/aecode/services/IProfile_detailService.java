package ai.aecode.aecode.services;

import ai.aecode.aecode.entities.Profile_detail;

import java.util.List;

public interface IProfile_detailService {
    public void insert(Profile_detail profile_detail);
    List<Profile_detail> list();
    public void delete(int id_ProfileDetail);
    public Profile_detail listId(int id_ProfileDetail);
}
