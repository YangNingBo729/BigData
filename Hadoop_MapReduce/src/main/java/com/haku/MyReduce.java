package com.haku;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * keyIn  map的KeyOut
 * valueIn map的valueOut
 * KeyOut  reduce应用的输出key的类型
 * ValueOut reduce应用输出的value的类型
 */
public class MyReduce extends Reducer<Text, IntWritable, Text, IntWritable> {
    /**
     * @param key     map应用程序输出的key   Welcome
     * @param values  [1,1,1]  key相同 value自动加入集合中
     * @param context 上下文对象，统计后的结果通过该对象输出
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        // 累积
        int sum = 0;
        for (IntWritable value : values) {
            sum += value.get();
        }
        context.write(key, new IntWritable(sum));

    }
}
