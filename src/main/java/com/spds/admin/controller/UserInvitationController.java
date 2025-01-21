package com.spds.admin.controller;

import java.util.List;
import java.util.Map;

import com.spds.admin.constant.StatusType;
import com.spds.admin.dto.GenericResponse;
import com.spds.admin.dto.UserPrincipal;
import com.spds.admin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.spds.admin.entity.BranchMaster;
import com.spds.admin.entity.Role;
import com.spds.admin.entity.UserInvitation;
import com.spds.admin.service.UserInvitationService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

/**
 * @author prakash
 * created 01 Jan 2025
 */
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class UserInvitationController {

    @Autowired
    private UserInvitationService userInvitationService;


    @PostMapping("/user-invitation/create")
    public ResponseEntity<GenericResponse<UserInvitation>> createUserInvitation(@Valid @RequestBody UserInvitation userInvitation) throws Exception {
        //userInvitation.setStatus("pending");
    	try {
    		UserInvitation createdMapping = userInvitationService.saveUserInvitation(userInvitation); 
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details saved successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in saving details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in saving details-"+e.getMessage(), null, null));
        }
    	//UserInvitation savedInvitation = userInvitationService.saveUserInvitation(userInvitation);
        //return ResponseEntity.ok(savedInvitation);
    }

    @GetMapping("/user-invitation/get-roles")
    ResponseEntity<GenericResponse<List<Role>>> getRoles(@RequestParam Long id) {
    	try {
    		List<Role> createdMapping = userInvitationService.getRoleByParentRoleId(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in fetching details for id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-"+e.getMessage(), null, null));
        }  
    	//return new ResponseEntity<List<Role>>(userInvitationService.getRoleByParentRoleId(id), HttpStatus.OK);
    }

    @PatchMapping("/user-invitation/status/{id}")
    ResponseEntity<GenericResponse<UserInvitation>> updateStatus(@PathVariable Long id, @RequestParam(required = true) String status) {
        List<StatusType> statusList = List.of(StatusType.CANCEL, StatusType.PENDING, StatusType.PENDING_APPROVAL, StatusType.REJECT, StatusType.SUSPEND, StatusType.WITHDRAW);
        try {
            if (!statusList.toString().contains(status))
                throw new IllegalStateException("Error: This action is not permitted. Please verify your input and try again.");
            UserInvitation userInvitation = this.userInvitationService.updateStatus(id, status.toString());
            GenericResponse<UserInvitation> response = new GenericResponse<>(
                    false,
                    "",
                    "Update successfully",
                    userInvitation
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            GenericResponse<UserInvitation> response = new GenericResponse<>(
                    true,
                    e.getMessage(),
                    "",
                    null
            );
            log.error("User invitation update failed-"+ id);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/validate-token")
    public ResponseEntity<GenericResponse<?>> validateTokenAndFetchUserDetails(
            @RequestParam Long id,
            @RequestParam String token) {
        try {
            // Validate the token and fetch user details
            UserInvitation userInvitation = userInvitationService.validateTokenAndFetchDetails(id, token);

            // Prepare response data
            var responseData = Map.of(
                    "id", userInvitation.getId(),
                    "name", userInvitation.getFullName(),
                    "officeId", userInvitation.getOfficeId()
            );

            // Return a success response
            return ResponseEntity.ok(
                    new GenericResponse<>(false, null, "Validation successful", responseData)
            );
        } catch (Exception e) {
            // Return an error response
            return ResponseEntity.badRequest().body(
                    new GenericResponse<>(true, e.getMessage(), null, null)
            );
        }
    }


    @GetMapping("/user-invitations/filter-by-status")
        public ResponseEntity<GenericResponse<List<UserInvitation>>> getAllUserInvitationByStatus(@AuthenticationPrincipal UserPrincipal user , @RequestParam(required = false) String status ){
        try {
            List<UserInvitation> allUserInvitation = this.userInvitationService.getAllUserInvitationByStatus(status,user.getUserId() );
            GenericResponse<List<UserInvitation>> response = new GenericResponse<>(
                    false,
                    "",
                    "User invitation details fetched successfully",
                    allUserInvitation
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            GenericResponse<List<UserInvitation>> response = new GenericResponse<>(
                    true,
                    e.getMessage(),
                    "",
                    null
            );
            log.error("Error in fetching user invitation details-"+ status, e.getMessage(), e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/user-invitations/approved/new-registration")
    public ResponseEntity<GenericResponse<String>> approvedNewUserRegistration(@RequestParam Long invitationId){
        try {
            this.userInvitationService.approvedNewUserRegistration(invitationId);
            GenericResponse<String> response = new GenericResponse<>(
                    false,
                    null,
                    "Approved successfully.",
                    null
            );
            return ResponseEntity.ok(response);
        }catch (Exception e){
            GenericResponse<String> response = new GenericResponse<>(
                    true,
                    e.getMessage(),
                    null,
                    null
            );
            log.error("Error: Approval could not be completed. Check the details and try again-" + invitationId , e);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
