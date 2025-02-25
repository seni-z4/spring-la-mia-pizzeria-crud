package pizzeria.it.pizzamvc.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pizza")
public class Pizza {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank(message = "inserici il nome")
  private String nome;

  @NotBlank(message = "inserici il descrizione")
  private String descrizione;

  @NotBlank(message = "inserici il path")
  private String url;

  @NotNull(message = "inserici il prezzo")
  private Integer prezzo;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Integer getPrezzo() {
    return prezzo;
  }

  public void setPrezzo(Integer prezzo) {
    this.prezzo = prezzo;
  }

  @Override
  public String toString() {
    return "Pizza [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", url=" + url + ", prezzo=" + prezzo
        + "]";
  }

}
