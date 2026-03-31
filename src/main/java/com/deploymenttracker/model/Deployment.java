package com.deploymenttracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

@Entity
public class Deployment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;
    private String imageName;
    private String imageTag;
    private String deployedBy;
    private String deploymentMethod;
    private String environment;
    private LocalDateTime deployedAt;

    // Automatically set deployedAt before persisting
    @PrePersist
    protected void onCreate() {
        this.deployedAt = LocalDateTime.now();
    }

    // No-arg constructor
    public Deployment() {
    }

    // All-arg constructor (excluding id and deployedAt — managed automatically)
    public Deployment(String serviceName, String imageName, String imageTag,
                      String deployedBy, String deploymentMethod, String environment) {
        this.serviceName = serviceName;
        this.imageName = imageName;
        this.imageTag = imageTag;
        this.deployedBy = deployedBy;
        this.deploymentMethod = deploymentMethod;
        this.environment = environment;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageTag() {
        return imageTag;
    }

    public void setImageTag(String imageTag) {
        this.imageTag = imageTag;
    }

    public String getDeployedBy() {
        return deployedBy;
    }

    public void setDeployedBy(String deployedBy) {
        this.deployedBy = deployedBy;
    }

    public String getDeploymentMethod() {
        return deploymentMethod;
    }

    public void setDeploymentMethod(String deploymentMethod) {
        this.deploymentMethod = deploymentMethod;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public LocalDateTime getDeployedAt() {
        return deployedAt;
    }

    public void setDeployedAt(LocalDateTime deployedAt) {
        this.deployedAt = deployedAt;
    }
}

