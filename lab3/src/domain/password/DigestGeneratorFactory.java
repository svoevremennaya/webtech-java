package domain.password;

import domain.password.impl.Md5DigestGeneratorImpl;

public class DigestGeneratorFactory {
    private final static DigestGenerator passwordDigestGenerator = new Md5DigestGeneratorImpl();

    public static DigestGenerator getPasswordDigestGenerator() {
        return passwordDigestGenerator;
    }

    private DigestGeneratorFactory() {
    }
}
