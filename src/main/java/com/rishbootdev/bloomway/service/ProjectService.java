package com.rishbootdev.bloomway.service;


import com.rishbootdev.bloomway.dto.project.ProjectRequest;
import com.rishbootdev.bloomway.dto.project.ProjectResponse;
import com.rishbootdev.bloomway.dto.project.ProjectSummaryResponse;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects();

    ProjectResponse getUserProjectById(Long id);

    ProjectResponse createProject(ProjectRequest request);

    ProjectResponse updateProject(Long id, ProjectRequest request);

    void softDelete(Long id);
}
