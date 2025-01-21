package com.spds.admin.service.impl;

import com.spds.admin.constant.StatusType;
import com.spds.admin.entity.User;
import com.spds.admin.entity.UserInvitation;
import com.spds.admin.repository.NewRegistrationRepository;
import com.spds.admin.repository.UserInvitationRepository;
import com.spds.admin.service.NewRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author prakash
 * created 02 Jan 2025
 */
@Service
public class NewRegistrationServiceImpl implements NewRegistrationService {


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private NewRegistrationRepository newRegistrationRepository;

    @Autowired
    private UserInvitationRepository userInvitationRepository;

    @Override
    public User createUpdate(User user, Long id) {
        // TODO Auto-generated method stub

//		Optional<UserInvitation> byId = userInvitationRepository.findById(id);
//		UserInvitation invitation = byId.get();
//		user.setSelectedOffice(String.valueOf(invitation.getOfficeId()));
//		user.setSelectedRole();

        Optional<UserInvitation> byId = userInvitationRepository.findById(id);

        // Check if the invitation exists
        if (byId.isEmpty()) {
            throw new IllegalArgumentException("User invitation not found for the given ID.");
        }

        UserInvitation invitation = byId.get();

        // Set the selected office and role from the invitation
        user.setSelectedOffice(String.valueOf(invitation.getOfficeId()));
        user.setSelectedRole(String.valueOf(invitation.getRoleId()));
        user.setActive(false);
        user.setDeleted(false);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserInvitationId(id);

        User registeredUser = newRegistrationRepository.save(user);
        invitation.setStatus(StatusType.PENDING_APPROVAL.toString());
        userInvitationRepository.save(invitation);
        return registeredUser;
    }


}
