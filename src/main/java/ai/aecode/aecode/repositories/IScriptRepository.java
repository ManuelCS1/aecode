package ai.aecode.aecode.repositories;

import ai.aecode.aecode.entities.Script;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScriptRepository extends JpaRepository<Script,Integer> {
}
