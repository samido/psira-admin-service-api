package com.psira.dto;

import java.time.LocalDate;
import com.psira.entity.Post;

public class PostDTO {
    private String postName;
    private String jobDescription;
    private Post.BusinessUnit businessUnit;
    private ManagerDTO manager;
    private Integer experienceYears;
    private Post.Qualification qualification;
    private Boolean driversLicenseRequired;
    private LocalDate openingDate;
    private LocalDate closingDate;

    // Getters and Setters
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

    public Post.BusinessUnit getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(Post.BusinessUnit businessUnit) {
        this.businessUnit = businessUnit;
    }

    public ManagerDTO getManager() {
        return manager;
    }

    public void setManager(ManagerDTO manager) {
        this.manager = manager;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public Post.Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Post.Qualification qualification) {
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
