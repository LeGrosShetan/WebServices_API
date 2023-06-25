package com.epul.permispiste.dto;

import com.epul.permispiste.domains.ApprenantEntity;
import com.epul.permispiste.domains.InscritEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ApprenantDto {
    private int numApprenant;
    private String nomApprenant;
    private String prenomApprenant;
    private Set<JeuDto> inscriptions;

    public int getNumApprenant() {
        return numApprenant;
    }

    public void setNumApprenant(int numApprenant) {
        this.numApprenant = numApprenant;
    }

    public String getNomApprenant() {
        return nomApprenant;
    }

    public void setNomApprenant(String nomApprenant) {
        this.nomApprenant = nomApprenant;
    }

    public String getPrenomApprenant() {
        return prenomApprenant;
    }

    public void setPrenomApprenant(String prenomApprenant) {
        this.prenomApprenant = prenomApprenant;
    }

    public Set<JeuDto> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<JeuDto> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public ApprenantDto(int numApprenant, String nomApprenant, String prenomApprenant, Set<JeuDto> inscriptions) {
        this.numApprenant = numApprenant;
        this.nomApprenant = nomApprenant;
        this.prenomApprenant = prenomApprenant;
        this.inscriptions = inscriptions;
    }

    public ApprenantDto(ApprenantEntity apprenantEntity){
        this.numApprenant = apprenantEntity.getNumapprenant();
        this.nomApprenant = apprenantEntity.getNomapprenant();
        this.prenomApprenant = apprenantEntity.getPrenomapprenant();
        this.inscriptions = new HashSet<>();

        for(InscritEntity inscriptions : apprenantEntity.getInscriptions()){
            this.inscriptions.add(new JeuDto(inscriptions.getJeu()));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApprenantDto)) return false;
        ApprenantDto that = (ApprenantDto) o;
        return numApprenant == that.numApprenant && nomApprenant.equals(that.nomApprenant) && prenomApprenant.equals(that.prenomApprenant) && inscriptions.equals(that.inscriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numApprenant, nomApprenant, prenomApprenant, inscriptions);
    }
}
