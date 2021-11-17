package by.bsuir.lab2.service.impl;

import by.bsuir.lab2.service.HelperService;

import java.lang.reflect.Method;

public class HelperServiceImpl implements HelperService {
    public String getMethodGetterName(String enumValue) {
        enumValue = enumValue.toLowerCase();
        String result = "get" + (char) (enumValue.charAt(0) - ('a' - 'A'));

        for (int i = 1; i < enumValue.length(); i++) {
            char c = enumValue.charAt(i);
            if (c == '_') {
                i++;
                result = result + (char) (enumValue.charAt(i) - ('a' - 'A'));
            } else {
                result = result + c;
            }
        }
        return result;
    }

    public Object methodCaller(String methodName, Object instance) {
        try {
            Method method = instance.getClass().getDeclaredMethod(methodName);
            return method.invoke(instance);
        } catch (Exception e) {
            try {
                Method method = instance.getClass().getSuperclass().getDeclaredMethod(methodName);
                return method.invoke(instance);
            } catch (Exception ex) {
                return null;
            }
        }
    }
}
