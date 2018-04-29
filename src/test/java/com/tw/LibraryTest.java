package com.tw;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    @Test
    public void testNormal() throws FileNotFoundException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        System.setIn(new FileInputStream("testInput"));
        String result = "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出\n" +
                "请输入你的选择（1～3）：\n" +
                "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n" +
                "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出\n" +
                "请输入你的选择（1～3）：\n" +
                "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n" +
                "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出\n" +
                "请输入你的选择（1～3）：\n" +
                "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n" +
                "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出\n" +
                "请输入你的选择（1～3）：\n" +
                "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n" +
                "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出\n" +
                "请输入你的选择（1～3）：\n" +
                "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n" +
                "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "张三|75.00|95.00|80.00|80.00|82.50|330.00\n" +
                "李四|85.00|80.00|70.00|90.00|81.25|325.00\n" +
                "王五|81.00|80.00|75.00|90.00|81.50|326.00\n" +
                "陈六|85.00|82.00|70.00|93.00|82.50|330.00\n" +
                "========================\n" +
                "全班总分平均数：327.75\n" +
                "全班总分中位数：328.00\n" +
                "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出\n" +
                "请输入你的选择（1～3）：\n";
        Library.main(null);
        String outStr = output.toString();
        assertEquals(result, outStr);
    }
    @Test
    public void testError() throws FileNotFoundException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        System.setIn(new FileInputStream("testErrorInput"));
        String out = "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出\n" +
                "请输入你的选择（1～3）：\n" +
                "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n" +
                "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出\n" +
                "请输入你的选择（1～3）：\n" +
                "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n" +
                "请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n" +
                "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出\n" +
                "请输入你的选择（1～3）：\n" +
                "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n" +
                "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出\n" +
                "请输入你的选择（1～3）：\n" +
                "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n" +
                "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出\n" +
                "请输入你的选择（1～3）：\n" +
                "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n" +
                "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n" +
                "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "张三|75.00|95.00|80.00|80.00|82.50|330.00\n" +
                "李四|85.00|80.00|70.00|90.00|81.25|325.00\n" +
                "王五|81.00|80.00|75.00|90.00|81.50|326.00\n" +
                "陈六|85.00|82.00|70.00|93.00|82.50|330.00\n" +
                "========================\n" +
                "全班总分平均数：327.75\n" +
                "全班总分中位数：328.00\n" +
                "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出\n" +
                "请输入你的选择（1～3）：\n";
        Library.main(null);
        assertEquals(out,output.toString());
    }
}
