package com.epul.permispiste.domains;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "apprenant", schema = "permispiste")
public class ApprenantEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMAPPRENANT", nullable = false)
    private Integer numApprenant;
    @Basic
    @Column(name = "NOMAPPRENANT", nullable = false, length = 25)
    private String nomApprenant;
    @Basic
    @Column(name = "PRENOMAPPRENANT", nullable = false, length = 25)
    private String prenomApprenant;

    @OneToMany(mappedBy = "apprenant")
    private Set<InscritEntity> inscriptions;

    public Set<InscritEntity> getInscriptions() {
        return inscriptions;
    }

    public Integer getNumapprenant() {
        return numApprenant;
    }

    public void setNumapprenant(Integer numApprenant) {
        this.numApprenant = numApprenant;
    }

    @Basic
    @Column(name = "NOMAPPRENANT")
    public String getNomapprenant() {
        return nomApprenant;
    }

    public void setNomapprenant(String nomApprenant) {
        this.nomApprenant = nomApprenant;
    }

    @Basic
    @Column(name = "PRENOMAPPRENANT")
    public String getPrenomapprenant() {
        return prenomApprenant;
    }

    public void setPrenomapprenant(String prenomApprenant) {
        this.prenomApprenant = prenomApprenant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApprenantEntity that = (ApprenantEntity) o;
        return Objects.equals(numApprenant, that.numApprenant) && Objects.equals(nomApprenant, that.nomApprenant) && Objects.equals(prenomApprenant, that.prenomApprenant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numApprenant, nomApprenant, prenomApprenant);
    }
}
