package co.microservices.appointmentRequest.model;

import java.time.LocalDateTime;

/**
 * Appointment Model
 * Created by rafaellopez on 12/14/17.
 */
public class Appointment {
    private String patientId;
    private LocalDateTime appointmentDate;
    private String doctorId;

    public Appointment() {
    }

    public Appointment(String patientId, LocalDateTime appointmentDate, String doctorId) {
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

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
}
