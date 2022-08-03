package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Cookie {

    public static final String DELIMITER = "=";
    public static final int NAME_INDEX = 0;
    public static final int VALUE_INDEX = 1;
    private String name;
    private String value;
    private String path;

    public Cookie(String name, String value, String path) {
        this.name = name;
        this.value = value;
        this.path = path;
    }

    public Cookie(String cookie, String path) {
        if (cookie == null || cookie.isEmpty()) {
            return;
        }
        this.name = cookie.split(DELIMITER)[NAME_INDEX];
        this.value = cookie.split(DELIMITER)[VALUE_INDEX];
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getPath() {
        return path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cookie cookie = (Cookie) o;
        return Objects.equals(name, cookie.name) && Objects.equals(value, cookie.value) && path.matches(cookie.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value, path);
    }
}