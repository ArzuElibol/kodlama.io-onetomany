package relationship.onetomany.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import relationship.onetomany.business.abstracts.ProgramingLanguageService;
import relationship.onetomany.business.abstracts.TechnologyService;
import relationship.onetomany.business.requests.TechnologyRequest;
import relationship.onetomany.business.responses.TechnologyResponse;
import relationship.onetomany.dataAccess.abstracts.TechnologyRepository;
import relationship.onetomany.entities.concretes.ProgramingLanguage;
import relationship.onetomany.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

    private TechnologyRepository technologyRepository;
    private ProgramingLanguageService programingLanguageService;

    public TechnologyManager(TechnologyRepository technologyRepository,ProgramingLanguageService programingLanguageService) {  
        this.technologyRepository = technologyRepository;
        this.programingLanguageService=programingLanguageService;
    }

    @Override
    public List<TechnologyResponse> getAll() {
        List<Technology> technologies = technologyRepository.findAll();
        List<TechnologyResponse> TechnologyResponses = new ArrayList<TechnologyResponse>();

        for (Technology technology : technologies) {
            TechnologyResponse resposeItem = new TechnologyResponse();
            resposeItem.setId(technology.getId());
            resposeItem.setName(technology.getName());
            resposeItem.setProgramingLanguageId(technology.getProgramingLanguage().getId());
        
            TechnologyResponses.add(resposeItem);
        }
        return TechnologyResponses;
    }

    @Override
    public void add(TechnologyRequest createTechnologyRequest) {
        Technology technology = new Technology();
        ProgramingLanguage programingLanguage = programingLanguageService.getById(createTechnologyRequest.getProgramingLanguageId());
        technology.setName(createTechnologyRequest.getName());
        technology.setProgramingLanguage(programingLanguage);
        this.technologyRepository.save(technology);
    }

    @Override
    public void update(TechnologyRequest updateTechnologyRequest, int id) {
        Technology updateTechnology=technologyRepository.getReferenceById(id);
        ProgramingLanguage programingLanguage = programingLanguageService.getById(updateTechnologyRequest.getProgramingLanguageId());
       updateTechnology.setName(updateTechnologyRequest.getName());
       updateTechnology.setProgramingLanguage(programingLanguage);
       technologyRepository.save(updateTechnology);
    }

    @Override
    public void delete(int id) {
       technologyRepository.deleteById(id);

    }


}
