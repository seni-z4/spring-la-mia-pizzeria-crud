package pizzeria.it.pizzamvc.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "offer")
public class Offer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank(message = "the date cannt be in the futer")
  @PastOrPresent
  private Date dataDiInizio;

  @NotBlank(message = "the date cannt be in the past")
  @PastOrPresent
  private Date dataDiFine;

  @NotBlank(message = "insert the offer title")
  private String titolo;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getDataDiInizio() {
    return dataDiInizio;
  }

  public void setDataDiInizio(Date dataDiInizio) {
    this.dataDiInizio = dataDiInizio;
  }

  public Date getDataDiFine() {
    return dataDiFine;
  }

  public void setDataDiFine(Date dataDiFine) {
    this.dataDiFine = dataDiFine;
  }

  public String getTitolo() {
    return titolo;
  }

  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }

  @Override
  public String toString() {
    return "Offer [id=" + id + ", dataDiInizio=" + dataDiInizio + ", dataDiFine=" + dataDiFine + ", titolo=" + titolo
        + "]";
  }

}
