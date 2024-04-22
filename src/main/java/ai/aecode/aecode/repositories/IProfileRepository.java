package ai.aecode.aecode.repositories;

import ai.aecode.aecode.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfileRepository extends JpaRepository<Profile,Integer> {
}
