package com.spds.admin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spds.admin.entity.Role;
import com.spds.admin.entity.UserInvitation;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.query.Param;

/**
 * @author prakash
 * created 01 Jan 2024
 */
@Transactional
public interface UserInvitationRepository extends JpaRepository<UserInvitation, Long> {
    @Query(value = "select * from ua.role", nativeQuery = true)
    List<Role> findByParentRoleId(Long id);


    Optional<UserInvitation> findByEmailId(String emailId);

    @Query(value = "SELECT * FROM ua.user_invitation WHERE id = :id AND invitation_token = :token", nativeQuery = true)
    Optional<UserInvitation> findByIdAndToken(
            @Param("id") Long id,
            @Param("token") String token
    );

    List<UserInvitation> findAllByStatusAndCreatedByAndIsActiveTrueAndIsDeletedFalse(String status, Long createdBy);

    List<UserInvitation> findAllByCreatedByAndIsActiveTrueAndIsDeletedFalse( Long createdBy);

    Optional<UserInvitation> findByIdAndAndIsActiveTrueAndIsDeletedFalse(Long id);

}