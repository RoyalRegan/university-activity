package utils;

import com.google.gson.Gson;

public final class Checker {
    private static final Gson gson = new Gson();

    private Checker() {
    }

    public static boolean isJSONValid(String jsonInString) {
        try {
            gson.fromJson(jsonInString, Object.class);
            return true;
        } catch (com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }

    public static boolean isIdValid(String id) {
        try {
            Integer.parseInt(id);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
