package com.haku;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

/**
 * 初始化MR程序
 * MRAPPMaster
 */
public class InitMR {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //1. 初始化MR任务对象
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration, "word Count");
        FileInputFormat.addInputPath(job, new Path("E:/wordcount.txt"));
        FileOutputFormat.setOutputPath(job, new Path("E:/result"));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
        //设置MR的启动入口
        job.setJarByClass(InitMR.class);
        //2. 设置数据的输入类型和输出的类型  1个Block ---> 1个Map  1GB数据 ---> 8个map任务
        // inputFormat 决定了如何切割数据集 如何读取切割后的数据
        // outputFormat 如何输出计算结果
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        //3. 设置数据集的来源和计算结果的输出目的地
       /* TextInputFormat.addInputPath(job,new Path("hdfs://hadoop:9000/wordcount.txt"));
        // 计算结果存放目录必须不存在
        TextOutputFormat.setOutputPath(job,new Path("hdfs://hadoop:9000/result"));*/

        //4. 设置keyOut valueOut数据类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        //5. 其它
        // 设置初始化MR程序的Map任务的实现类和Reduce任务的实现类
        job.setMapperClass(MyMapper.class);
        job.setReducerClass(MyReduce.class);
        //6. 提交MR程序
        job.waitForCompletion(true);
    }
}
