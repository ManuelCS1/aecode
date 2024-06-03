package ai.aecode.aecode.repositories;

import ai.aecode.aecode.entities.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlanRepository extends JpaRepository<Plan,Integer> {
}
