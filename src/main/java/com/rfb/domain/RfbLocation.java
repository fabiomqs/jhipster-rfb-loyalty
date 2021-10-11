package com.rfb.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A RfbLocation.
 */
@Entity
@Table(name = "rfb_location")
public class RfbLocation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "location_name")
    private String locationName;

    @Column(name = "run_day_of_week")
    private Integer runDayOfWeek;

    @OneToMany(mappedBy = "rfbLocation")
    @JsonIgnoreProperties(value = { "rfbEventAttendances", "rfbLocation" }, allowSetters = true)
    private Set<RfbEvent> rvbEvents = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public RfbLocation id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public RfbLocation locationName(String locationName) {
        this.setLocationName(locationName);
        return this;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Integer getRunDayOfWeek() {
        return this.runDayOfWeek;
    }

    public RfbLocation runDayOfWeek(Integer runDayOfWeek) {
        this.setRunDayOfWeek(runDayOfWeek);
        return this;
    }

    public void setRunDayOfWeek(Integer runDayOfWeek) {
        this.runDayOfWeek = runDayOfWeek;
    }

    public Set<RfbEvent> getRvbEvents() {
        return this.rvbEvents;
    }

    public void setRvbEvents(Set<RfbEvent> rfbEvents) {
        if (this.rvbEvents != null) {
            this.rvbEvents.forEach(i -> i.setRfbLocation(null));
        }
        if (rfbEvents != null) {
            rfbEvents.forEach(i -> i.setRfbLocation(this));
        }
        this.rvbEvents = rfbEvents;
    }

    public RfbLocation rvbEvents(Set<RfbEvent> rfbEvents) {
        this.setRvbEvents(rfbEvents);
        return this;
    }

    public RfbLocation addRvbEvent(RfbEvent rfbEvent) {
        this.rvbEvents.add(rfbEvent);
        rfbEvent.setRfbLocation(this);
        return this;
    }

    public RfbLocation removeRvbEvent(RfbEvent rfbEvent) {
        this.rvbEvents.remove(rfbEvent);
        rfbEvent.setRfbLocation(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RfbLocation)) {
            return false;
        }
        return id != null && id.equals(((RfbLocation) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RfbLocation{" +
            "id=" + getId() +
            ", locationName='" + getLocationName() + "'" +
            ", runDayOfWeek=" + getRunDayOfWeek() +
            "}";
    }
}
