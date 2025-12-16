package com.rishbootdev.bloomway.service.impl;



import com.rishbootdev.bloomway.dto.project.FileContentResponse;
import com.rishbootdev.bloomway.dto.project.FileNode;
import com.rishbootdev.bloomway.service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public List<FileNode> getFileTree(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public FileContentResponse getFileContent(Long projectId, String path, Long userId) {
        return null;
    }
}
