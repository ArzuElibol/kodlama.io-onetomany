package relationship.onetomany.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import relationship.onetomany.business.abstracts.ProgramingLanguageService;
import relationship.onetomany.business.requests.ProgramingLanguageRequest;
import relationship.onetomany.business.responses.PrograminLanguageResponse;

@RestController
@RequestMapping("/api/languages")
public class PrograminLanguageControllers {
 
    private ProgramingLanguageService programingLanguageService;

    public PrograminLanguageControllers(ProgramingLanguageService programingLanguageService) {
        this.programingLanguageService = programingLanguageService;
    }

    @GetMapping("/getAll")
    public List<PrograminLanguageResponse> getAll() {
        return programingLanguageService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody() ProgramingLanguageRequest programingLanguageRequest) {
        this.programingLanguageService.add(programingLanguageRequest);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody() ProgramingLanguageRequest programingLanguageRequest, @PathVariable int id) {
        this.programingLanguageService.update(programingLanguageRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
this.programingLanguageService.delete(id);
    }

}
