package ai.aecode.aecode.repositories;

import ai.aecode.aecode.entities.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInteractionRepository extends JpaRepository<Interaction,Integer> {
}
