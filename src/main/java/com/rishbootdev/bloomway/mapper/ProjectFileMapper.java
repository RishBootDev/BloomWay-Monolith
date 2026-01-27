package com.rishbootdev.bloomway.mapper;


import com.rishbootdev.bloomway.dto.project.FileNode;
import com.rishbootdev.bloomway.entity.ProjectFile;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectFileMapper {

    List<FileNode> toListOfFileNode(List<ProjectFile> projectFileList);
}
