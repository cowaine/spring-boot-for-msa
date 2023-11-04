package com.cowaine.corock.chapter06.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!production")
@Component
public class MailSender {
}
