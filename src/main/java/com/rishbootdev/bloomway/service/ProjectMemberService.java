package com.rishbootdev.bloomway.service;


import com.rishbootdev.bloomway.dto.member.InviteMemberRequest;
import com.rishbootdev.bloomway.dto.member.MemberResponse;
import com.rishbootdev.bloomway.dto.member.UpdateMemberRoleRequest;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request);

    void removeProjectMember(Long projectId, Long memberId);
}
