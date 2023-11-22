package com.construction.systems.constech.profiles.interfaces.rest.transform;

import com.construction.systems.constech.profiles.domain.model.aggregates.Profile;
import com.construction.systems.constech.profiles.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile profile) {
        return new ProfileResource(profile.getId(), profile.getFullName(), profile.getEmailAddress(), profile.getStreetAddress());
    }
}
