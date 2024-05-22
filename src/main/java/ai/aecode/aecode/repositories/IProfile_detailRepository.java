package ai.aecode.aecode.repositories;

import ai.aecode.aecode.entities.Profile_detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfile_detailRepository extends JpaRepository<Profile_detail,Integer> {
}
