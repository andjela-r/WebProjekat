package vezbe.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Lokacija implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long duzina;

    private Long sirina;

    private String adresa;

    public Lokacija(Long id, Long duzina, Long sirina, String adresa) {
        this.id = id;
        this.duzina = duzina;
        this.sirina = sirina;
        this.adresa = adresa;
    }

    public Lokacija() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDuzina() {
        return duzina;
    }

    public void setDuzina(Long duzina) {
        this.duzina = duzina;
    }

    public Long getSirina() {
        return sirina;
    }

    public void setSirina(Long sirina) {
        this.sirina = sirina;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
