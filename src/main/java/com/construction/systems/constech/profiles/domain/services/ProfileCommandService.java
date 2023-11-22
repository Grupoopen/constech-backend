package com.construction.systems.constech.profiles.domain.services;

import com.construction.systems.constech.profiles.domain.model.commands.CreateProfileCommand;

public interface ProfileCommandService {
    Long handle(CreateProfileCommand command);
}
