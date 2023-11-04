package com.cowaine.crupy.part6.domain.email.service;

import com.cowaine.crupy.part6.domain.email.EmailAddress;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!email")
public class DummyEmailService implements EmailService {

    @Override
    public boolean sendEmail(EmailAddress emailAddress) {
        System.out.println("Dummy Email : " + emailAddress.toString());
        return true;
    }
}
