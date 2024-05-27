package ai.aecode.aecode.repositories;

import ai.aecode.aecode.entities.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPruebaRepository extends JpaRepository<Prueba,Integer>{
}
