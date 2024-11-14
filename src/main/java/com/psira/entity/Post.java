package com.psira.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "post_name", nullable = false)
    private String postName;

    @Column(name = "job_description", nullable = false)
    private String jobDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "business_unit", nullable = false)
    private BusinessUnit businessUnit;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manager_id", referencedColumnName = "manager_id", nullable = false)
    private Manager manager;

    @Column(name = "experience_years", nullable = false)
    private Integer experienceYears;

    @Enumerated(EnumType.STRING)
    @Column(name = "qualification", nullable = false)
    private Qualification qualification;

    @Column(name = "drivers_license_required", nullable = false)
    private Boolean driversLicenseRequired;

    @Column(name = "opening_date", nullable = false)
    private LocalDate openingDate;

    @Column(name = "closing_date", nullable = false)
    private LocalDate closingDate;

    // Enum for Business Unit
    public enum BusinessUnit {
        ICT, HUMAN_CAPITAL, LAW_ENFORCEMENT, FINANCE
    }

    // Enum for Qualification with helper methods
    public enum Qualification {
        DIPLOMA, DEGREE, HONORS, MASTERS, PHD;

        public static Qualification fromString(String name) {
            return Qualification.valueOf(name.toUpperCase());
        }

        public static Qualification fromDatabaseString(String name) {
            if (name == null) {
                throw new IllegalArgumentException("Qualification cannot be null");
            }
            switch (name.toUpperCase()) {
                case "DIPLOMA":
                    return DIPLOMA;
                case "DEGREE":
                    return DEGREE;
                case "HONORS":
                    return HONORS;
                case "MASTERS":
                    return MASTERS;
                case "PHD":
                    return PHD;
                default:
                    throw new IllegalArgumentException("No enum constant for value: " + name);
            }
        }
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public BusinessUnit getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(BusinessUnit businessUnit) {
        this.businessUnit = businessUnit;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public Boolean getDriversLicenseRequired() {
        return driversLicenseRequired;
    }

    public void setDriversLicenseRequired(Boolean driversLicenseRequired) {
        this.driversLicenseRequired = driversLicenseRequired;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }
}
