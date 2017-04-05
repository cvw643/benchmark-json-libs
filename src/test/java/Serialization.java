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
public class Serialization {

    private ObjectMapper mapper = new ObjectMapper();
    private Gson gson = new Gson();
    private Person target = new Person("cvw643", 38);
    private int times = 10000000;

    @Test
    public void benchmarkJacksonSerialization() {
        System.out.println("Benchmark.benchmarkJacksonSerialization");
        benchmark(() -> {
            try {
                mapper.writeValueAsString(target);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }, times);
    }

    @Test
    public void benchmarkFastjsonSerialization() {
        System.out.println("Benchmark.benchmarkFastjsonSerialization");
        benchmark(() -> {
            JSON.toJSONString(target);
        }, times);
    }

    @Test
    public void benchmarkGsonSerialization() {
        System.out.println("Benchmark.benchmarkGsonSerialization");
        benchmark(() -> {
            gson.toJson(target);
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
