package relationship.onetomany.business.abstracts;

import java.util.List;


import relationship.onetomany.business.requests.TechnologyRequest;
import relationship.onetomany.business.responses.TechnologyResponse;

public interface TechnologyService {

    List<TechnologyResponse> getAll();

    void add(TechnologyRequest createTechnologyRequest);

    void update(TechnologyRequest updateTechnologyRequest, int id);

    void delete(int id);
  

}
