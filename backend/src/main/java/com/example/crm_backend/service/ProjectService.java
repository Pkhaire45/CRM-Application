package com.example.crm_backend.service;
import com.example.crm_backend.entity.Project;
import com.example.crm_backend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}

