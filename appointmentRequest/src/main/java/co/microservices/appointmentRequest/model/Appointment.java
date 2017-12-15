package co.microservices.appointmentRequest.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * Appointment Model
 * Created by rafaellopez on 12/14/17.
 */
public class Appointment implements Serializable {
    private String patientId;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private String appointmentDate;
    private String doctorId;

    public Appointment() {
    }

    public Appointment(String patientId, String appointmentDate, String doctorId) {
        this.patientId = patientId;
        this.appointmentDate = appointmentDate;
        this.doctorId = doctorId;
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
