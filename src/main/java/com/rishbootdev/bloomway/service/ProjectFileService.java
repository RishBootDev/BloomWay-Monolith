package com.rishbootdev.bloomway.service;

import com.rishbootdev.bloomway.dto.project.FileContentResponse;
import com.rishbootdev.bloomway.dto.project.FileNode;

import java.util.List;


public interface ProjectFileService {

    List<FileNode> getFileTree(Long projectId, Long userId);
    FileContentResponse getFileContent(Long projectId, String path, Long userId);
    void saveFile(Long projectId, String filePath, String fileContent);
}
