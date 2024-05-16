package ai.aecode.aecode.repositories;

import ai.aecode.aecode.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfileRepository extends JpaRepository<Profile,Integer> {
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Profile p WHERE p.profile_email = :email")
    boolean existsByProfile_email(@Param("email") String email);

    @Query("SELECT p FROM Profile p WHERE  p.profile_email = :email")
    Profile findByUsernameOrEmail(@Param("email") String email);
}
