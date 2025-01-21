package com.spds.admin.service;

import java.util.List;

import com.spds.admin.entity.Role;
import com.spds.admin.entity.UserInvitation;

/**
 * @author prakash
 * created 01 Jan 2024
 */

public interface UserInvitationService {
    public UserInvitation saveUserInvitation(UserInvitation userInvitation);

    public List<Role> getRoleByParentRoleId(Long id);

    UserInvitation updateStatus(Long id, String status);

    UserInvitation validateTokenAndFetchDetails(Long id, String token) throws Exception;

    List<UserInvitation> getAllUserInvitationByStatus(String status,Long userId);

    void approvedNewUserRegistration(Long userInvitationId);
}
