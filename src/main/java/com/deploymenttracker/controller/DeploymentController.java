package com.deploymenttracker.controller;

import com.deploymenttracker.model.Deployment;
import com.deploymenttracker.service.DeploymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deployments")
public class DeploymentController {

    private final DeploymentService deploymentService;

    public DeploymentController(DeploymentService deploymentService) {
        this.deploymentService = deploymentService;
    }

    /**
     * GET /deployments/health
     * Health check endpoint.
     */
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Deployment Tracker Running");
    }

    /**
     * GET /deployments/list
     * Returns all deployment records.
     */
    @GetMapping("/list")
    public ResponseEntity<List<Deployment>> getAllDeployments() {
        return ResponseEntity.ok(deploymentService.getAllDeployments());
    }

    /**
     * POST /deployments/add
     * Saves a new deployment record.
     */
    @PostMapping("/add")
    public ResponseEntity<Deployment> addDeployment(@RequestBody Deployment deployment) {
        Deployment saved = deploymentService.saveDeployment(deployment);
        return ResponseEntity.ok(saved);
    }
}

