package com.tzxylao.collect;

import org.apache.commons.collections4.MapUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 收集器
 * Created by laoliangliang on 18/9/4.
 */
public class CollectDemo {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("小明3", 12, 0, 93),
                new Student("小明2", 11, 1, 98),
                new Student("小明5", 14, 1, 44),
                new Student("小明4", 13, 0, 22),
                new Student("小明1", 10, 1, 99),
                new Student("小明6", 12, 0, 47)
        );

        //所有学生的年龄列表
        List<Integer> ages = students.stream().map(s -> s.getAge()).collect(Collectors.toList());
        Set<Integer> ages2 = students.stream().map(s -> s.getAge()).collect(Collectors.toCollection(TreeSet::new));
        System.out.println("所有学生的年龄："+ages);
        System.out.println("所有学生的年龄："+ages2);

        //统计汇总信息
        IntSummaryStatistics ageSummary = students.stream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println("年龄汇总信息："+ageSummary);

        //分块
        Map<Boolean, List<Student>> collect = students.stream().collect(Collectors.partitioningBy(s -> s.getGrade() == 1));
        System.out.println("男女学生列表"+collect);
        MapUtils.verbosePrint(System.out,"男女学生列表",collect);


        //分组
        Map<Double, List<Student>> collect1 = students.stream().collect(Collectors.groupingBy(Student::getGrade));
        MapUtils.verbosePrint(System.out,"男女学生列表",collect1);

        //得到每个性别学生的个数
        Map<Double, Long> collect2 = students.stream().collect(Collectors.groupingBy(Student::getGrade,Collectors.counting()));
        MapUtils.verbosePrint(System.out,"男女学生列表",collect2);

    }
}

class Student {
    private String name;

    private int age;

    private double grade;

    private int gender;

    public Student(String name, int age, double grade, int gender) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", gender=" + gender +
                '}';
    }
}