import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

class ParserTest {
    @Test
    void stringInput() {
        Parser parser = Parser.of("1,2,3,4,5,6,7,8,9,10");
        Assert.assertEquals("Odd:5\tEven:5", parser.getResult());
    }

    @Test
    void arrayInput() {
        Parser parser = Parser.of(new int[]{1, 2, 3, 4, 10});
        Assert.assertEquals("Odd:2\tEven:3", parser.getResult());
    }

    @Test
    void listInput() {
        Parser parser = Parser.of(List.of(1, 5));
        Assert.assertEquals("Odd:2\tEven:0", parser.getResult());
    }
}
