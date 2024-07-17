package pizzera.model;

import org.aspectj.bridge.Message;
import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "toscainio")
public class PizzaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "il nome e obbligatorio")
	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@NotBlank(message = "il descrizione e obbligatorio")
	@Column(name = "descrizione", nullable = false)
	private String descrizione;

	@NotBlank(message = "il fotourl e obbligatorio")
	@Column(name = "fotoUrl", nullable = true)
	private String fotoUrl;

	@NotNull(message = "pezzo e obbligatorio")
	@Column(name = "prezzo", nullable = false)
	private double prezzo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

}
