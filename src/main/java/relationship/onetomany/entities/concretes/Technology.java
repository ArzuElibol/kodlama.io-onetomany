package relationship.onetomany.entities.concretes;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="Technology")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Technology {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private int id;

private String name;

@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
@JoinColumn(name="PrograminLanguageId")
private ProgramingLanguage programingLanguage;

}

//@JoinColumn(name = "language_id", foreignKey = @ForeignKey(name = "FK_language_id"), nullable = false)

	// Burada cascadeType.ALL yapmadik cunku bir teknolojide yapilan degisiklik
	// language etkilemesin diye. ornegin bir teknoloji silindiginde dilin
	// silinmemesi gerekir

	// fetchType.EAGER = istek bulundugunda cache(on bellek) teknolojiye ait tum
	// bilgilerin gelmesi

	// targetEntity = Language sinifini isaret eder

	// joinColumn ile Language sinifindaki kolonla eslestirilir.

	// @foreignKey yabancil anahtara isim verilir