package org.yann.mybatis3.handler;

public enum Color{
    RED("red"),
    YELLOW("yellow"),
    GREEN("green"),
    BLUE("blue");

    private String value;

    Color(String v) {
        this.value = v;
    }

    public String getValue() {
        return value;
    }

    public static Color get(String v) {
        if (v == null) {
            return null;
        }
        for (Color value : Color.values()) {
            if (v.equals(value.value)) {
                return value;
            }
        }
        throw new RuntimeException("undefined color type");
    }
}
