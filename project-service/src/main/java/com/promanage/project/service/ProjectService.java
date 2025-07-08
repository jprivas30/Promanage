package com.promanage.project.service;

import com.promanage.project.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    List<ProjectDto> getAllProjects();
    ProjectDto createProject(ProjectDto dto);
    ProjectDto updateProject(Long id, ProjectDto dto);
    void deleteProject(Long id);
}