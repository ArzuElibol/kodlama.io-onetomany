package relationship.onetomany.entities.concretes;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ProgramingLanguage", fetch = FetchType.LAZY, targetEntity = Technology.class)
   // @OneToMany  //(mappedBy = "programingLanguage")
    @JoinColumn(name = "PrograminLanguageId")
    Set<Technology> technologies;
    //private Technology technology; 
}




	// cascadeType.ALL = language de yapilan bir degisiklik ona bagli teknolojileri de etkilesin
	
	// mappedBy = Technology sinifa baglidir. yani iliskinin asil sahibini Technology sinifi yapilir
	// mappedBy'in degerine Technology sinifindaki field adi verilir
	
	// fetchType.LAZY = language bagli teknolojilerin hepsi birden gelmesin yapilan istege gore gelsin
	
	// targetEntity = Technology sinifini isaret eder
