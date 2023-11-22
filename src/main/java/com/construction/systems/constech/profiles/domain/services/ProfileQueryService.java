package com.construction.systems.constech.profiles.domain.services;

import com.construction.systems.constech.profiles.domain.model.aggregates.Profile;
import com.construction.systems.constech.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.construction.systems.constech.profiles.domain.model.queries.GetProfileByIdQuery;

import java.util.Optional;

public interface ProfileQueryService {
    Optional<Profile> handle(GetProfileByEmailQuery query);
    Optional<Profile> handle(GetProfileByIdQuery query);
}
