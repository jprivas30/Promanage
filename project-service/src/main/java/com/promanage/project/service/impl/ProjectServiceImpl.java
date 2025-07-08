package com.promanage.project.service.impl;

import com.promanage.project.dto.ProjectDto;
import com.promanage.project.model.Project;
import com.promanage.project.repository.ProjectRepository;
import com.promanage.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository repository;

    @Override
    public List<ProjectDto> getAllProjects() {
        return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public ProjectDto createProject(ProjectDto dto) {
        Project p = new Project();
        p.setName(dto.getName());
        p.setDescription(dto.getDescription());
        p.setBudget(dto.getBudget());
        return mapToDto(repository.save(p));
    }

    @Override
    public ProjectDto updateProject(Long id, ProjectDto dto) {
        Project p = repository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
        p.setName(dto.getName());
        p.setDescription(dto.getDescription());
        p.setBudget(dto.getBudget());
        return mapToDto(repository.save(p));
    }

    @Override
    public void deleteProject(Long id) {
        repository.deleteById(id);
    }

    private ProjectDto mapToDto(Project p) {
        return new ProjectDto(p.getId(), p.getName(), p.getDescription(), p.getBudget());
    }
}