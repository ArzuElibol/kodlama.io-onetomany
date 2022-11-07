package relationship.onetomany.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import relationship.onetomany.entities.concretes.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
    
}
