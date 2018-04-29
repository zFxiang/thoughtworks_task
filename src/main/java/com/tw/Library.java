package com.tw;

import com.tw.model.Student;
import com.tw.service.StudentService;
import com.tw.util.InputUtil;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Library {

    private static StudentService studentService = StudentService.getInstant();;
    private static Scanner scanner;

    public static void main(String[] args) {
        try {
            scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. 添加学生\n" +
                        "2. 生成成绩单\n" +
                        "3. 退出\n" +
                        "请输入你的选择（1～3）：");
                if(!scanner.hasNextInt()){
                    return;
                }
                int inputNum = scanner.nextInt();
                switch (inputNum) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        print();
                        break;
                    case 3:
                        return;
                    default:
                }

            }
        } finally {
            if(scanner != null){
                scanner.close();
            }
        }
    }
    private static Pattern patternForAddStu = Pattern.compile("^.+, .+, (.+: \\d+){4}$");
    public static void addStudent() {
        System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
        scanner.nextLine();
        Student student = null;
        while (true) {
            String str = scanner.nextLine();
            student = InputUtil.parseStudent(str);
            if(student != null){
                break;
            }
            System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
        }
        studentService.save(student);
    }
    public static void print() {
        System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
        scanner.nextLine();
        List<String> nos;
        while (true) {
            String str = scanner.nextLine();
            nos = InputUtil.parseNos(str);
            if(nos != null){
                break;
            }
            System.out.println("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
        }
        studentService.printScore(nos);
    }
}
