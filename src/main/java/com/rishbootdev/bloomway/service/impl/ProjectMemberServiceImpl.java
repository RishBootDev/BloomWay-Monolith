package com.rishbootdev.bloomway.service.impl;

import com.rishbootdev.bloomway.dto.member.InviteMemberRequest;
import com.rishbootdev.bloomway.dto.member.MemberResponse;
import com.rishbootdev.bloomway.dto.member.UpdateMemberRoleRequest;
import com.rishbootdev.bloomway.entity.Project;
import com.rishbootdev.bloomway.entity.ProjectMember;
import com.rishbootdev.bloomway.entity.ProjectMemberId;
import com.rishbootdev.bloomway.entity.User;
import com.rishbootdev.bloomway.exceptions.ResourceNotFoundException;
import com.rishbootdev.bloomway.mapper.ProjectMemberMapper;
import com.rishbootdev.bloomway.repository.ProjectMemberRepository;
import com.rishbootdev.bloomway.repository.ProjectRepository;
import com.rishbootdev.bloomway.repository.UserRepository;
import com.rishbootdev.bloomway.security.AuthUtil;
import com.rishbootdev.bloomway.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectRepository projectRepository;
    private final ProjectMemberMapper projectMemberMapper;
    private final UserRepository userRepository;
    private final AuthUtil authUtil;

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId) {

        Long userId= authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);

        return projectMemberRepository.findByIdProjectId(projectId)
                        .stream()
                        .map(projectMemberMapper::toProjectMemberResponseFromMember)
                        .toList();
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request) {
        long userId=authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);

        User invitee=userRepository.findUserByNameIs(request.username()).orElseThrow(()->new RuntimeException(" Not found User"));

        if(invitee.getId().equals(userId)) {
            throw new RuntimeException("Cannot invite yourself");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, invitee.getId());

        if(projectMemberRepository.existsById(projectMemberId)) {
            throw new RuntimeException("Cannot invite once again");
        }

        ProjectMember member = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();

        projectMemberRepository.save(member);

        return projectMemberMapper.toProjectMemberResponseFromMember(member);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request) {
        Long userId= authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();

        projectMember.setProjectRole(request.role());

        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        if(!projectMemberRepository.existsById(projectMemberId)) {
            throw new RuntimeException("Member not found in project");
        }
        projectMemberRepository.deleteById(projectMemberId);
    }

    public Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.findAccessibleProjectById(projectId, userId).orElseThrow(
                ()-> new ResourceNotFoundException("Project ",projectId.toString()));
    }
}
