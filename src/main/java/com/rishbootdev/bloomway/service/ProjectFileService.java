package com.rishbootdev.bloomway.service;

import com.rishbootdev.bloomway.dto.project.FileContentResponse;
import com.rishbootdev.bloomway.dto.project.FileNode;

import java.util.List;


public interface ProjectFileService {

    List<FileNode> getFileTree(Long projectId);

    FileContentResponse getFileContent(Long projectId, String path);

    void saveFile(Long projectId, String filePath, String fileContent);
}
