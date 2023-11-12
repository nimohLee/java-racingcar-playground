package calculator;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCaculator {

    public static int calculate(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }

        String customDelimiter = getCustomDelimiter(s).orElse(",");
        s = getFinalExpression(s, customDelimiter);
        // 계산
        return Arrays.stream(
                        s.replaceAll("[;"+customDelimiter+"]",",").split(",")
                )
                .mapToInt(i -> {
                    int num = Integer.parseInt(i);
                    if (num < 0) {
                        throw new RuntimeException("음수입니다.");
                    }
                    return num;
                })
                .sum();
    }

    private static String getFinalExpression(String s, String customDelimiter) {
        if(checkIsCustomDelimiter(customDelimiter)) {
            return s;
        }
        return getCustomExpression(s).orElseThrow(()->{
            throw new IllegalArgumentException();});
    }

    private static boolean checkIsCustomDelimiter(String forCheckDelimiter) {
        return forCheckDelimiter.equals(",");
    }

    private static Optional<String> getCustomDelimiter(String s) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(s);
        if (m.find()) {
            return Optional.of(m.group(1));
        }
        return Optional.empty();
    }

    private static Optional<String> getCustomExpression(String s) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(s);
        if (m.find()) {
            return Optional.of(m.group(2));
        }
        return Optional.empty();
    }
}
