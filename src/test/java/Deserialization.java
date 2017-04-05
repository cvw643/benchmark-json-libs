import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.huangyuqiang.benchmark.Person;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

/**
 * @author YQ.Huang
 */
public class Deserialization {

    private ObjectMapper mapper = new ObjectMapper();
    private Gson gson = new Gson();
    private String target = "{\"name\": \"cvw643\", \"age\": 38}";
    private int times = 10000000;

    @Test
    public void benchmarkJacksonDeserialization() {
        System.out.println("Benchmark.benchmarkJacksonDeserialization");
        benchmark(() -> {
            try {
                mapper.readValue(target, Person.class);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }, times);
    }

    @Test
    public void benchmarkFastjsonDeserialization() {
        System.out.println("Benchmark.benchmarkFastjsonDeserialization");
        benchmark(() -> {
            JSON.parseObject(target, Person.class);
        }, times);
    }

    @Test
    public void benchmarkGsonDeserialization() {
        System.out.println("Benchmark.benchmarkGsonDeserialization");
        benchmark(() -> {
            gson.fromJson(target, Person.class);
        }, times);
    }

    private void benchmark(Runnable runnable, int times) {
        StopWatch watch = StopWatch.createStarted();
        for (int i = 0; i < times; i++)
            runnable.run();
        watch.stop();
        System.err.println(watch.toString());
    }

}
