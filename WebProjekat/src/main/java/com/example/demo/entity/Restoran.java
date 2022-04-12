package vezbe.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Restoran implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String tip;

    @OneToOne
    @JoinColumn(name = "lokacija_id")
    private vezbe.demo.model.Lokacija lokacija;

    @ManyToMany
    @JoinColumn(name = "artikli_id")
    private vezbe.demo.model.Artikli artikli;

    public vezbe.demo.model.Lokacija getLokacija() {
        return lokacija;
    }

    public Restoran() {
    }

    public Restoran(Long id, String naziv, String tip, vezbe.demo.model.Lokacija restoran) {
        this.id = id;
        this.naziv = naziv;
        this.tip = tip;
        this.restoran = restoran;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public vezbe.demo.model.Lokacija getRestoran() {
        return restoran;
    }

    public void setRestoran(vezbe.demo.model.Lokacija restoran) {
        this.restoran = restoran;
    }

}

