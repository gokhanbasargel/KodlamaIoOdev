package kodlamaIo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaIo.entities.Technology;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

}
