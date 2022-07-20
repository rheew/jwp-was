package model;

import java.util.Arrays;

public enum HttpMethod {
    GET, POST;

    public static HttpMethod getType(String method) {
        return Arrays.stream(HttpMethod.values())
                .filter(type -> type.equals(HttpMethod.valueOf(method)))
                .findFirst()
                .orElseThrow(UnSupportMethodType::new);
    }
}
