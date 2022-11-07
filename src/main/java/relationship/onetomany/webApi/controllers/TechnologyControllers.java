package relationship.onetomany.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import relationship.onetomany.business.abstracts.TechnologyService;
import relationship.onetomany.business.requests.TechnologyRequest;
import relationship.onetomany.business.responses.TechnologyResponse;

@RestController
@RequestMapping("/api/technology")
public class TechnologyControllers {
    private TechnologyService technologyService;

    public TechnologyControllers(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping("/getAll")
    public List<TechnologyResponse> getAll() {
        return technologyService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody() TechnologyRequest technologyRequest) {
        this.technologyService.add(technologyRequest);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody TechnologyRequest technologyRequest, @PathVariable int id) throws Exception {
        technologyService.update(technologyRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        technologyService.delete(id);
    }

    // @GetMapping("/getTechnologies/{id}")
    // public List<TechnologyResponse> findTechnologyWithLanguageId(int id) {
    //     return technologyService.findTechnologyWithLanguageId(id);
    // }

}
