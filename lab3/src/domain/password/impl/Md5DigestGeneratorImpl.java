package domain.password.impl;

import javax.xml.bind.DatatypeConverter;

import domain.password.DigestGenerator;
import domain.password.PasswordDigestException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5DigestGeneratorImpl implements DigestGenerator {
    @Override
    public String generate(String password) throws PasswordDigestException {
        if (password == null) {
            throw new IllegalArgumentException("Password shouldn't be null");
        }

        try {
            return DatatypeConverter.printHexBinary(MessageDigest.getInstance("MD5").digest(password.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new PasswordDigestException("Error acquiring MD5 digest instance", e);
        }
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}
