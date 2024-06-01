package ai.aecode.aecode.repositories;

import ai.aecode.aecode.entities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISpecialityRepository extends JpaRepository<Speciality, Integer> {
}
