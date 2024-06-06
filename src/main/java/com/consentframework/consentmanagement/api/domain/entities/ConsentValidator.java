package com.consentframework.consentmanagement.api.domain.entities;

import com.consentframework.consentmanagement.api.domain.exceptions.IllegalArgumentException;
import com.consentframework.consentmanagement.api.models.Consent;
import software.amazon.smithy.utils.StringUtils;

/**
 * Utility class for validating Consent objects before
 * pushing them to a backend repository.
 */
public final class ConsentValidator {
    public static final String SERVICE_ID_BLANK_MESSAGE = "serviceId must not be blank";
    public static final String USER_ID_BLANK_MESSAGE = "userId must not be blank";
    public static final String CONSENT_ID_BLANK_MESSAGE = "consentId must not be blank";
    public static final String CONSENT_VERSION_NULL_MESSAGE = "consentVersion must not be null";
    public static final String STATUS_NULL_MESSAGE = "status must not be null";

    private ConsentValidator() {}

    /**
     * Validate whether Consent satisfies model constraints.
     *
     * @param consent input consent data
     * @throws IllegalArgumentException exception thrown if consent violates model constraints
     */
    public static void validate(final Consent consent) throws IllegalArgumentException {
        if (StringUtils.isBlank(consent.getServiceId())) {
            throw new IllegalArgumentException(SERVICE_ID_BLANK_MESSAGE);
        }
        if (StringUtils.isBlank(consent.getUserId())) {
            throw new IllegalArgumentException(USER_ID_BLANK_MESSAGE);
        }
        if (StringUtils.isBlank(consent.getConsentId())) {
            throw new IllegalArgumentException(CONSENT_ID_BLANK_MESSAGE);
        }
        if (consent.getConsentVersion() == null) {
            throw new IllegalArgumentException(CONSENT_VERSION_NULL_MESSAGE);
        }
        if (consent.getStatus() == null) {
            throw new IllegalArgumentException(STATUS_NULL_MESSAGE);
        }
    }
}
