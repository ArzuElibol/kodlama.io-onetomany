package relationship.onetomany.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyRequest {
    private String name;
    private int programingLanguageId;
}
