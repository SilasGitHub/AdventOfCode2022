package solutions.day4;

import solutions.Puzzle;
import org.apache.commons.lang3.Range;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Puzzle1 extends Puzzle {
    @Override
    protected void solve() throws IOException {
        String line;
        long count = 0;
        while ((line = reader.readLine()) != null) {
            List<Range<Integer>> ranges = Arrays.stream(line.split(",")).map(part -> {
                List<Integer> ids = Arrays.stream(part.split("-")).map(Integer::parseInt).toList();
                return Range.between(ids.get(0), ids.get(1));
            }).toList();
            if (ranges.get(0).containsRange(ranges.get(1)) || ranges.get(1).containsRange(ranges.get(0))) count++;
        }
        System.out.println(count);
    }
}
