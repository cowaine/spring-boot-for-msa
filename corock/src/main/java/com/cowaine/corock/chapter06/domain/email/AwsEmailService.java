package com.cowaine.corock.chapter06.domain.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("email")
@Slf4j
@Service
public class AwsEmailService implements EmailService {

    @Override
    public boolean sendEmail(EmailAddress emailAddress) {
        log.info("Send Email using AWS: {}", emailAddress.toString());
        return true;
    }

}
