package com.epul.permispiste.domains;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "objectif", schema = "permispiste")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "numobjectif")
public class ObjectifEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMOBJECTIF", nullable = false)
    private Integer numObjectif;
    @Basic
    @Column(name = "LIBOBJECTIF", nullable = false, length = 25)
    private String libObjectif;

    @ManyToMany(mappedBy = "objectifs")
    private Set<ActionEntity> actions;

    @ManyToMany(mappedBy = "objectifs")
    private Set<MissionEntity> missions;

    public Integer getNumobjectif() {
        return numObjectif;
    }

    public void setNumobjectif(Integer numObjectif) {
        this.numObjectif = numObjectif;
    }

    public String getLibobjectif() {
        return libObjectif;
    }

    public void setLibobjectif(String libObjectif) {
        this.libObjectif = libObjectif;
    }

    public Set<ActionEntity> getActions() {
        return actions;
    }

    public void setActions(Set<ActionEntity> actions) {
        this.actions = actions;
    }

    public Set<MissionEntity> getMissions() {
        return missions;
    }

    public void setMissions(Set<MissionEntity> missions) {
        this.missions = missions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectifEntity that = (ObjectifEntity) o;
        return Objects.equals(numObjectif, that.numObjectif) && Objects.equals(libObjectif, that.libObjectif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numObjectif, libObjectif);
    }
}
