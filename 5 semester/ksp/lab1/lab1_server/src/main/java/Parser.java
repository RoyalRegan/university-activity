import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser implements Result {
    private final String result;

    private Parser(final String numbers) {
        result = parse(numbers);
    }

    private Parser(final int[] numbers) {
        result = parse(Arrays.stream(numbers).boxed().map(integer -> Integer.toString(integer)).collect(Collectors.joining(",")));
    }

    private Parser(@NotNull final List<Integer> numbers) {
        result = parse(numbers.stream().map(integer -> Integer.toString(integer)).collect(Collectors.joining(",")));
    }

    @NotNull
    public static Parser of(@NotNull final String numbers) {
        return new Parser(numbers);
    }

    @NotNull
    public static Parser of(@NotNull final int[] numbers) {
        return new Parser(numbers);
    }

    @NotNull
    public static Parser of(@NotNull final List<Integer> numbers) {
        return new Parser(numbers);
    }

    private String parse(String str) {
        return Arrays.stream(str.trim().split("[, .;]"))
                .filter(s -> !s.isEmpty()).map(Integer::parseInt)
                .collect(Collectors.partitioningBy(s -> s % 2 == 0, Collectors.counting()))
                .entrySet().stream()
                .map(e -> e.getKey() ? "Even:" + e.getValue() : "Odd:" + e.getValue())
                .collect(Collectors.joining("\t"));
    }

    @Override
    @NotNull
    public String getResult() {
        return result;
    }
}

