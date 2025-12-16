package com.rishbootdev.bloomway.service;


import com.rishbootdev.bloomway.dto.project.ProjectRequest;
import com.rishbootdev.bloomway.dto.project.ProjectResponse;
import com.rishbootdev.bloomway.dto.project.ProjectSummaryResponse;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects(Long userId);

    ProjectResponse getUserProjectById(Long id, Long userId);

    ProjectResponse createProject(ProjectRequest request, Long userId);

    ProjectResponse updateProject(Long id, ProjectRequest request, Long userId);

    void softDelete(Long id, Long userId);
}
