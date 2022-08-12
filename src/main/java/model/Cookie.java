package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cookie {

    public static final String DELIMITER = "=";
    public static final int NAME_INDEX = 0;
    public static final int VALUE_INDEX = 1;
    private String name;
    private String value;
    private String path;

    public Cookie() {}

    public Cookie(String name, String value, String path) {
        this.name = name;
        this.value = value;
        this.path = path;
    }

    public Cookie(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static Map<String, Cookie> createCookie(HttpHeader header) {
        String cookie = header.getValue("Cookie");

        if (cookie == null || cookie.isEmpty()) {
            return new HashMap<>();
        }
        return Arrays.stream(cookie.split("; "))
                .map(item -> new Cookie(item.split("=")[0], item.split("=")[1]))
                .collect(Collectors.toMap(Cookie::getName, self -> self));
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

    @Override
    public String toString() {
        return "Cookie{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", path='" + path + '\'' +
                '}';
    }

    public boolean isEmpty() {
        return name == null || value == null;
    }
}
