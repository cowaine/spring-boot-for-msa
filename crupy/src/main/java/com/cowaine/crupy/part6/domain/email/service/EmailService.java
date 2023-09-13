package com.cowaine.crupy.part6.domain.email.service;

import com.cowaine.crupy.part6.domain.email.EmailAddress;

public interface EmailService {

    boolean sendEmail(EmailAddress emailAddress);
}
