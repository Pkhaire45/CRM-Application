package com.example.crm_backend.controller;


import com.example.crm_backend.entity.Project;
import com.example.crm_backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{projectId}")
    public Project getProjectById(@PathVariable Long projectId) {
        return projectService.getProjectById(projectId);
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    @PutMapping("/{projectId}")
    public Project updateProject(@PathVariable Long projectId, @RequestBody Project project) {
        Project existingProject = projectService.getProjectById(projectId);
        existingProject.setProjectName(project.getProjectName());
        existingProject.setDescription(project.getDescription());
        existingProject.setUser(project.getUser());
        return projectService.saveProject(existingProject);
    }

    @DeleteMapping("/{projectId}")
    public void deleteProject(@PathVariable Long projectId) {
        projectService.deleteProject(projectId);
    }

    // Add more endpoints as needed
}
