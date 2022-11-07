package relationship.onetomany.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import relationship.onetomany.entities.concretes.ProgramingLanguage;

public interface ProgramingLanguageRepository extends JpaRepository<ProgramingLanguage,Integer> {
    
}
