package com.promanage.project.controller;

import com.promanage.project.dto.ProjectDto;
import com.promanage.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<ProjectDto> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping
    public ProjectDto createProject(@RequestBody ProjectDto dto) {
        return projectService.createProject(dto);
    }

    @PutMapping("/{id}")
    public ProjectDto updateProject(@PathVariable Long id, @RequestBody ProjectDto dto) {
        return projectService.updateProject(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
}