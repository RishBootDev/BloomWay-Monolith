package com.rishbootdev.bloomway.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.repository.query.FluentQuery;

import java.time.Instant;

@Getter
@Setter
@Builder
public class ProjectFile {

    private Long id;

    private Project project;

    private String path;

    private String minioObjectKey;

    private Instant createdAt;

    private Instant updatedAt;

    private User createdBy;

    private User updatedBy;

}
