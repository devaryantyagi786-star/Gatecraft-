
package com.Switchly.demo.Service;

import com.Switchly.demo.exception.NotFoundException;
import com.Switchly.demo.model.Organization;
import com.Switchly.demo.model.Project;
import com.Switchly.demo.Repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {

    private final OrganizationService organizationService;
    private final ProjectRepository projectRepository;

    public ProjectService(OrganizationService organizationService,
                          ProjectRepository projectRepository) {
        this.organizationService = organizationService;
        this.projectRepository = projectRepository;
    }

    public Project create(UUID organizationId, String name) {
        Organization organization = organizationService.getById(organizationId);

        Project project = new Project(
                UUID.randomUUID(),
                organization.getId(),
                name
        );

        return projectRepository.save(project);
    }

    public Project getById(UUID id) {
        return projectRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Project " + id + " not found"));
    }

    public List<Project> getAllForOrganization(UUID organizationId) {
        organizationService.getById(organizationId);

        return projectRepository.findByOrganizationId(organizationId);
    }
}
