package com.rishbootdev.bloomway.mapper;



import com.rishbootdev.bloomway.dto.project.ProjectResponse;
import com.rishbootdev.bloomway.dto.project.ProjectSummaryResponse;
import com.rishbootdev.bloomway.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

    ProjectSummaryResponse toProjectSummaryResponse(Project project);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);

}

