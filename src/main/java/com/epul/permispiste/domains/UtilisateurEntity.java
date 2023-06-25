package com.epul.permispiste.domains;

import com.epul.permispiste.utilitaires.MonMotPassHash;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "utilisateur")
@NamedQuery(name = "UtilisateurEntity.rechercheNom",query = "select ut  from UtilisateurEntity  ut where ut.nomUtil = ?1")
public class UtilisateurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMUTIL", nullable = false)
    private int numUtil;

    @Basic
    @Column(name = "NOMUTIL", nullable = false, length = 100)
    private String nomUtil;

    @Basic
    @Column(name = "MOTDEPASSE", nullable = false, length = 100)
    private String motPasse;

    public void setNumUtil(int numUtil) {
        this.numUtil = numUtil;
    }

    public int getNumUtil() {
        return numUtil;
    }

    public String getNomUtil() {
        return nomUtil;
    }

    public void setNomUtil(String nomUtil) {
        this.nomUtil = nomUtil;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UtilisateurEntity)) return false;
        UtilisateurEntity that = (UtilisateurEntity) o;
        return numUtil == that.numUtil && nomUtil.equals(that.nomUtil) && motPasse.equals(that.motPasse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numUtil, nomUtil, motPasse);
    }
}
