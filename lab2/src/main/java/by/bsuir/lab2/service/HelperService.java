package by.bsuir.lab2.service;

public interface HelperService {
    String getMethodGetterName(String enumValue);

    Object methodCaller(String methodName, Object instance);
}
