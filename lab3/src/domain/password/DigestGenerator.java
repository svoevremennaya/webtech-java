package domain.password;

public interface DigestGenerator {
    String generate(String password) throws PasswordDigestException;
}
