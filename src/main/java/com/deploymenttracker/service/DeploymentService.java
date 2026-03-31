package com.deploymenttracker.service;

import com.deploymenttracker.model.Deployment;
import com.deploymenttracker.repository.DeploymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeploymentService {

    private final DeploymentRepository deploymentRepository;

    public DeploymentService(DeploymentRepository deploymentRepository) {
        this.deploymentRepository = deploymentRepository;
    }

    /**
     * Saves a Deployment object to the database.
     *
     * @param deployment the deployment to save
     * @return the saved Deployment with generated id and deployedAt set
     */
    public Deployment saveDeployment(Deployment deployment) {
        return deploymentRepository.save(deployment);
    }

    /**
     * Retrieves all Deployment records from the database.
     *
     * @return list of all Deployment objects
     */
    public List<Deployment> getAllDeployments() {
        return deploymentRepository.findAll();
    }
}

