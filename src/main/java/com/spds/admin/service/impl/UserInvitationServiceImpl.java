package com.spds.admin.service.impl;

import java.util.*;

import com.spds.admin.config.NotificationNewUserFeignClientConfig;
import com.spds.admin.constant.StatusType;
import com.spds.admin.dto.EmailData;
import com.spds.admin.entity.User;
import com.spds.admin.entity.UserAccessMapping;
import com.spds.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spds.admin.entity.Role;
import com.spds.admin.entity.UserInvitation;
import com.spds.admin.repository.UserInvitationRepository;
import com.spds.admin.repository.UserRepository;
import com.spds.admin.service.UserInvitationService;
/**
 * 
 *@author prakash
 *created 01 Jan 2025
 */
@Service
public class UserInvitationServiceImpl implements UserInvitationService{
	
	@Autowired
    private UserInvitationRepository userInvitationRepository;
	
	@Autowired
    private UserRepository userRepository;
	
    @Autowired
    private NotificationNewUserFeignClientConfig notificationNewUserFeignClientConfig;
    
    @Autowired
    private TokenServiceImpl tokenServiceImpl;

    @Autowired
    private UserService userService;

    public UserInvitation saveUserInvitation(UserInvitation userInvitation) {
    	if(!userRepository.findByEmail(userInvitation.getEmailId()).isEmpty()){
    		  //email exist in the user repository
    		throw new NullPointerException("New user registration invitation failed.!!!");
    		
    	} 
    		Optional<UserInvitation> user = userInvitationRepository.findByEmailId(userInvitation.getEmailId());
            
            // Check if the email is present
            if (user.isPresent()) {
                throw new NullPointerException("New user registration invitation failed.!!!");
            } 
               
    	String invitationToken=tokenServiceImpl.generateInvitationToken(userInvitation);
    	userInvitation.setInvitationToken(invitationToken);
        UserInvitation saveInvitation = userInvitationRepository.save(userInvitation);
        Map<String, String> body = new HashMap<>();
        body.put("name", saveInvitation.getFullName());
        body.put("emailId", saveInvitation.getEmailId());
        body.put("mobileNo", saveInvitation.getMobileNumber());
        body.put("state", saveInvitation.getStateId().toString());
        body.put("officeId", saveInvitation.getOfficeId().toString());
        body.put("remarks", saveInvitation.getRemarks());
//        body.put("designation",saveInvitation.getRoleId());
        //body.put("invitationToken",saveInvitation.getInvitationToken());

        if (saveInvitation != null) {
            EmailData emailData = EmailData.builder()
                    .toEmail(saveInvitation.getEmailId())
//                    .ccEmail("talib1010@yopmail.com")
//                    .bccEmail("talib1011@yopmail.com")
                    .body(body)
                    .subject("New user Invitation Request")
                    .contentType("text/html")
                    .veName("template.vm").build();
                notificationNewUserFeignClientConfig.invitationNewUser(emailData);
        } else {
            throw new NullPointerException("New user registration invitation failed.!!!");
        }

        return userInvitation;
    }
    
    
    	
    
    @Override
    public List<Role> getRoleByParentRoleId(Long id) {
        return userInvitationRepository.findByParentRoleId(id);
    }

    @Override
	public UserInvitation updateStatus(Long id, String status) {
        UserInvitation userInvitation = userInvitationRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User invitation not found. Please check and try again.!!"));
        if (userInvitation.getStatus().equalsIgnoreCase(status)) {
            throw new IllegalStateException("Same operation. Please check..!!!");
        }
        userInvitation.setStatus(status);
        UserInvitation invitationResponse = userInvitationRepository.save(userInvitation);
        return invitationResponse;
	}

    @Override
    public UserInvitation validateTokenAndFetchDetails(Long id, String token) throws Exception {
        // Validate the token first
        boolean isValid = tokenServiceImpl.validateToken(token);
        if (!isValid) {
            throw new Exception("Token validation failed. The token is invalid or expired.");
        }

        // Fetch UserInvitation using id, token, and status
        Optional<UserInvitation> byInvitationToken = userInvitationRepository.findByIdAndToken(id, token);
        if (byInvitationToken.isEmpty()) {
            throw new Exception("Token not found in the system or status is incorrect.");
        }

        // Return the fetched UserInvitation
        return byInvitationToken.get();
    }

    @Override
    public List<UserInvitation>  getAllUserInvitationByStatus(String status, Long createdBy) {
        List<UserInvitation> userInvitationList = new ArrayList<>();
                if(status != null)
                    userInvitationList = this.userInvitationRepository.findAllByStatusAndCreatedByAndIsActiveTrueAndIsDeletedFalse(status.toUpperCase(), createdBy);
                else
                    userInvitationList = this.userInvitationRepository.findAllByCreatedByAndIsActiveTrueAndIsDeletedFalse(createdBy);

        if (userInvitationList.isEmpty())
            throw new NullPointerException("No invitations available.");
        return userInvitationList;
    }

    @Override
    public void approvedNewUserRegistration(Long userInvitationId) {
        UserInvitation userInvitation = this.userInvitationRepository.findByIdAndAndIsActiveTrueAndIsDeletedFalse(userInvitationId).orElseThrow(() -> new NullPointerException("No user invitation available."));
        if (userInvitation.getStatus().equalsIgnoreCase(StatusType.APPROVED.toString())){
            throw new IllegalArgumentException("Action denied: The same operation has already been executed.");
        }
        User userDetails = userRepository.findByUserInvitationId(userInvitationId).orElseThrow(() -> new NullPointerException("User details not found."));
        userDetails.setActive(true);
        userDetails.setDeleted(false);
        userInvitation.setStatus(StatusType.APPROVED.toString());
        this.userInvitationRepository.save(userInvitation);

        List<UserAccessMapping> userAccessMapping = new ArrayList<>();
        UserAccessMapping mapping = new UserAccessMapping();
        mapping.setUserId(userDetails.getId());
        mapping.setRoleId(Long.valueOf(userDetails.getSelectedRole()));
        mapping.setOfficeId(Long.valueOf(userDetails.getSelectedOffice()));
        userAccessMapping.add(mapping);
        userService.assignRoleAndOffice(userAccessMapping);

    }


}
