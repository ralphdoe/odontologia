package co.microservices.appointmentScheduler.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Appointment Model
 * Created by rafaellopez on 12/14/17.
 */
@Entity
@Table(name = "appointment")
public class Appointment implements Serializable {
    @Id
    @GeneratedValue
    private long code;
    
    private String patientId;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private String appointmentDate;
    private String doctorId;

    public Appointment() {
    }

    public Appointment(long code, String patientId, String appointmentDate, String doctorId) {
        this.code = code;
        this.patientId = patientId;
        this.appointmentDate = appointmentDate;
        this.doctorId = doctorId;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
}
