package relationship.onetomany.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import relationship.onetomany.business.abstracts.ProgramingLanguageService;
import relationship.onetomany.business.requests.ProgramingLanguageRequest;
import relationship.onetomany.business.responses.PrograminLanguageResponse;
import relationship.onetomany.dataAccess.abstracts.ProgramingLanguageRepository;
import relationship.onetomany.entities.concretes.ProgramingLanguage;


@Service
public class ProgramingLanguageManager implements ProgramingLanguageService {

    private ProgramingLanguageRepository programingLanguageRepository;
    // private TechnologyRepository technologyRepository;

    public ProgramingLanguageManager(ProgramingLanguageRepository programingLanguageRepository) { //,TechnologyRepository technologyRepository
        this.programingLanguageRepository = programingLanguageRepository;
        // this.technologyRepository = technologyRepository;
    }

    @Override
    public List<PrograminLanguageResponse> getAll() {
        List<ProgramingLanguage> programingLanguages = programingLanguageRepository.findAll();
        List<PrograminLanguageResponse> programinLanguageResponses = new ArrayList<PrograminLanguageResponse>();

        for (ProgramingLanguage programingLanguage : programingLanguages) {
            PrograminLanguageResponse responseItem = new PrograminLanguageResponse();
            responseItem.setId(programingLanguage.getId());
            responseItem.setName(programingLanguage.getName());
            programinLanguageResponses.add(responseItem);
        }
        return programinLanguageResponses;
    }

    @Override
    public void add(ProgramingLanguageRequest createProgramingLanguageRequest) {
        ProgramingLanguage programingLanguage = new ProgramingLanguage();
        programingLanguage.setName(createProgramingLanguageRequest.getName());
        programingLanguageRepository.save(programingLanguage);
    }

    @Override
    public void update(ProgramingLanguageRequest updateProgramingLanguageRequest, int id) {
        ProgramingLanguage updateProgramingLanguage = programingLanguageRepository.getReferenceById(id);
        updateProgramingLanguage.setName(updateProgramingLanguageRequest.getName());
        programingLanguageRepository.save(updateProgramingLanguage);

    }

    @Override
    public ProgramingLanguage getById(int id) {
        return programingLanguageRepository.getReferenceById(id);
    }

    // @Override
    // public List<TechnologyResponse> findTechnologyWithLanguageId(int id) {
    //     List<Technology> technology = technologyRepository.findAll();
    //     List<TechnologyResponse> technologyResponses = new ArrayList<TechnologyResponse>();
    //     for (Technology technology2 : technology) {
    //         TechnologyResponse responseItem = new TechnologyResponse();
    //         responseItem.setProgramingLanguageId(technology2.getProgramingLanguage().getId());
    //         responseItem.setId(technology2.getId());

    //         if (responseItem.getProgramingLanguageId() == (id)) {
    //             technologyResponses.add(responseItem);
    //         }
    //     }
    //     return technologyResponses;
    // }

    @Override
    public void delete(int id) {

        // List<TechnologyResponse> technologyResponses =this.findTechnologyWithLanguageId(id);
        // for (TechnologyResponse technologyResponse : technologyResponses) {
        // technologyRepository.deleteById(technologyResponse.getId());
        // }
        programingLanguageRepository.deleteById(id);

    }



}
