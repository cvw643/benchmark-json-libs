# 主流JSON库性能测试

## 结论

- Gson最慢，差1倍多
- Jackson和Fastjson性能差别不大

## 反序列化（10000000次）

- Benchmark.benchmarkGsonDeserialization
00:00:08.352

- Benchmark.benchmarkJacksonDeserialization
00:00:03.180

- Benchmark.benchmarkFastjsonDeserialization
00:00:04.384

## 序列化（10000000次）

- Benchmark.benchmarkFastjsonSerialization
00:00:02.514

- Benchmark.benchmarkJacksonSerialization
00:00:02.547

- Benchmark.benchmarkGsonSerialization
00:00:05.067
