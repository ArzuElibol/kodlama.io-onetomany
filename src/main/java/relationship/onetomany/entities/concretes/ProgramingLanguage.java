package relationship.onetomany.entities.concretes;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "PrograminLanguage")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProgramingLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String name;

    @OneToMany  //(mappedBy = "programingLanguage")
    @JoinColumn(name = "PrograminLanguageId")
    Set<Technology> technologies;
    //private Technology technology; 
}
