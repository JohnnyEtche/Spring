package ar.edu.unnoba.primero.Modelo;

import javax.persistence.*;

@Entity
@Table(name="profile")

public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_profile;
    private String tipo;

    public long getId_profile() {
        return id_profile;
    }

    public void setId_profile(long id_profile) {
        this.id_profile = id_profile;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
