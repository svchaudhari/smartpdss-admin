package com.spds.admin.config;

import com.spds.admin.dto.EmailData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "spds-notify", url = "${invitation.email.send}")
//@Service
public interface NotificationNewUserFeignClientConfig {

    @PostMapping("/api/v1/emailSend")
    String invitationNewUser(@RequestBody EmailData emailData);
}
