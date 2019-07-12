
import java.util.Iterator;

public class WordCount {

    class OutputCollector<K, V> {
        public void collect(K key, V value) {

        }
    }

    public static class Map {
        public void map(String key, String value, OutputCollector<String, Integer> output) {
            String[] tokens = value.split(" ");
            for(String word : tokens) {
                output.collect(word, 1);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, Integer> output) {
            int sum = 0;
            while (values.hasNext()) {
                sum += values.next();
            }
            output.collect(key, sum);
        }
    }

    public static void main(String[] args) {

    }
}