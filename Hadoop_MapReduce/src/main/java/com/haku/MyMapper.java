package com.haku;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * 泛型
 * KeyIn  每行数据首字符的偏移量的值
 * ValueIn 一行文本数据
 * KeyOut map应用输出的key的类型   map --> reduce
 * ValueOut map应用输出的value的类型
 */
public class MyMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    /**
     * @param key     keyIn
     * @param value   valueIn
     * @param context 上下文对象，类型映射后的结果通过该对象输出
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //将传入的一行字符串拆分
        String[] str = value.toString().split(" ");
        for (String s : str) {
            // k 1
            //将所有拆分后的字符串都记录下来
            context.write(new Text(s), new IntWritable(1));
        }
    }
}
