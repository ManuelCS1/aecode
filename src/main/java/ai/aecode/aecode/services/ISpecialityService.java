package ai.aecode.aecode.services;

import ai.aecode.aecode.entities.Speciality;

import java.util.List;

public interface ISpecialityService {
    public void insert(Speciality speciality);
    List<Speciality> list();
    public void delete(int id_speciality);
    public Speciality listId(int id_speciality);
}
