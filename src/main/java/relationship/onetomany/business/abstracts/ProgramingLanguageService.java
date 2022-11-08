package relationship.onetomany.business.abstracts;

import java.util.List;

import relationship.onetomany.business.requests.ProgramingLanguageRequest;
import relationship.onetomany.business.responses.PrograminLanguageResponse;
import relationship.onetomany.entities.concretes.ProgramingLanguage;

public interface ProgramingLanguageService {
    List<PrograminLanguageResponse> getAll();

    void add(ProgramingLanguageRequest createProgramingLanguageRequest);

    void update(ProgramingLanguageRequest updateProgramingLanguageRequest, int id);

    void delete(int id);

    ProgramingLanguage getById(int id);
    
    // List<TechnologyResponse> findTechnologyWithLanguageId( int id);  

}
