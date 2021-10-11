package com.rfb.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * A RfbEventAttendance.
 */
@Entity
@Table(name = "rfb_event_attendance")
public class RfbEventAttendance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "attendance_date")
    private LocalDate attendanceDate;

    @ManyToOne
    @JsonIgnoreProperties(value = { "rfbEventAttendances", "rfbLocation" }, allowSetters = true)
    private RfbEvent rfbEvent;

    @ManyToOne
    @JsonIgnoreProperties(value = { "homeLocation", "rfbEventAttendances" }, allowSetters = true)
    private RfbUser rfbUser;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public RfbEventAttendance id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getAttendanceDate() {
        return this.attendanceDate;
    }

    public RfbEventAttendance attendanceDate(LocalDate attendanceDate) {
        this.setAttendanceDate(attendanceDate);
        return this;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public RfbEvent getRfbEvent() {
        return this.rfbEvent;
    }

    public void setRfbEvent(RfbEvent rfbEvent) {
        this.rfbEvent = rfbEvent;
    }

    public RfbEventAttendance rfbEvent(RfbEvent rfbEvent) {
        this.setRfbEvent(rfbEvent);
        return this;
    }

    public RfbUser getRfbUser() {
        return this.rfbUser;
    }

    public void setRfbUser(RfbUser rfbUser) {
        this.rfbUser = rfbUser;
    }

    public RfbEventAttendance rfbUser(RfbUser rfbUser) {
        this.setRfbUser(rfbUser);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RfbEventAttendance)) {
            return false;
        }
        return id != null && id.equals(((RfbEventAttendance) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RfbEventAttendance{" +
            "id=" + getId() +
            ", attendanceDate='" + getAttendanceDate() + "'" +
            "}";
    }
}
