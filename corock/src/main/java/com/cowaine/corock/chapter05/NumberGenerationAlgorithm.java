package com.cowaine.corock.chapter05;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * The algorithm names in this section can be specified when generating an instance of {@link java.security.SecureRandom}.
 *
 * @see <a href="https://docs.oracle.com/en/java/javase/11/docs/specs/security/standard-names.html#securerandom-number-generation-algorithms">Java Security Standard Algorithm Names</a>
 */
@RequiredArgsConstructor
@Getter
public enum NumberGenerationAlgorithm {

    NATIVE_PRNG("NativePRNG"),
    NATIVE_PRNG_BLOCKING("NativePRNGBlocking"),
    NATIVE_PRNG_NON_BLOCKING("NativePRNGNonBlocking"),
    PKCS11("PKCS11"),
    DRBG("DRBG"),
    SHA1PRNG("SHA1PRNG"),
    WINDOWS_PRNG("Windows-PRNG");

    private final String algorithmName;

}
