package kodlamaIo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaIo.entities.Language;
@Repository
public interface LangugageRepository extends JpaRepository<Language, Integer>{
 
}
