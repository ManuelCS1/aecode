package ai.aecode.aecode.repositories;

import ai.aecode.aecode.entities.Commentforo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentforoRepository extends JpaRepository<Commentforo, Integer> {
}
