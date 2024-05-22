package ai.aecode.aecode.repositories;

import ai.aecode.aecode.entities.Script;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IScriptRepository extends JpaRepository<Script,Integer> {
     @Query("SELECT s FROM Script s WHERE s.software.software_name = :softwareName")
    List<Script> findBySoftwareName(@Param("softwareName") String softwareName);

    @Query("SELECT s FROM Script s WHERE s.tag.tag_name = :tagName")
    List<Script> findByTagName(@Param("tagName") String tagName);

    @Query("SELECT s FROM Script s WHERE s.proglang.proglang_name = :progLangName")
    List<Script> findByProgLangName(@Param("progLangName") String progLangName);

    @Query("SELECT s FROM Script s JOIN s.software sw JOIN s.tag t JOIN s.proglang pl WHERE sw.software_name = :softwareName AND t.tag_name = :tagName AND pl.proglang_name = :progLangName")
    List<Script> findBySoftwareNameAndTagNameAndProgLangName(@Param("softwareName") String softwareName, @Param("tagName") String tagName, @Param("progLangName") String progLangName);

}
