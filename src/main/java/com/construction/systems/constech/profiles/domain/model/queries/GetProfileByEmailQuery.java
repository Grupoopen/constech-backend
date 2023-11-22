package com.construction.systems.constech.profiles.domain.model.queries;

import com.construction.systems.constech.profiles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}
