package com.rishbootdev.bloomway.service;

import com.rishbootdev.bloomway.dto.deploy.DeployResponse;

public interface DeploymentService {

    DeployResponse deploy(Long projectId);
}
