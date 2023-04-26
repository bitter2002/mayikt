package com.mayikt.test;

import com.mayikt.entity.StudentEntity;
import com.mayikt.service.StudentService;

import java.util.ArrayList;
import java.util.Scanner;

public class IndexTest {
    private static StudentService studentService = new StudentService();

    public static void main(String[] args) {
        mainMenu();
    }

    /*
     * 1.需要定义主菜单程序入口
     * */
    public static void mainMenu() {
        while (true) {
            //提示语
            System.out.println("欢迎来到学生管理系统");
            System.out.println("1.查询所有学生信息");
            System.out.println("2.根据学生id查询学生信息");
            System.out.println("3.新增学生信息");
            System.out.println("4.根据学生id修改学生信息");
            System.out.println("5.根据学生id删除学生id");
            System.out.println("请选择对应的序号:");
            //2.接收用户输入的序号
            Scanner scanner = new Scanner(System.in);
            int result = scanner.nextInt();
            //3.在根据用户选择的序号判断
            switch (result) {
                case 1:
                    showAllStudent();
                    break;
                case 2:
                    findByIdStudent();
                    break;
                case 3:
                    insertStudent();
                    break;
                case 4:
                    updateStudent();
                case 5:
                    delIdStudent();
                    break;
            }
        }
    }

    //查询所有学生信息
    public static void showAllStudent() {
        System.out.println("查询到的所有学生信息");
        studentService = new StudentService();
        ArrayList<StudentEntity> studentEntities = studentService.allStudent();
        for (StudentEntity stu : studentEntities) {
            System.out.println(stu);
        }
    }

    //根据学生id查询学生信息
    public static void findByIdStudent() {
        System.out.println("根据学生id查询学生信息:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生id:");
        Long stuId = scanner.nextLong();
        studentService = new StudentService();
        //根据用户id查询学生信息,有可能查询不到
        StudentEntity student = studentService.getByIdStudent(stuId);
        if (student == null) {//查询不到
            System.out.println("该学生id" + student + "不存在");
            return;
        }
        System.out.println("查询到的学生信息:" + student);
    }

    //根据学生id删除学生信息
    public static void delIdStudent() {
        System.out.println("根据学生id删除学生信息:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生id:");
        Long stuId = scanner.nextLong();
        studentService = new StudentService();
        int result = studentService.deleteStudent(stuId);
        if (result > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    //新增学生信息
    public static void insertStudent() {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入学生id");
//        Long stuId = scanner.nextLong();
        System.out.println("请输入学生名称");
        String name = scanner.nextLine();
        System.out.println("请输入学生年龄");
        Integer age = scanner.nextInt();
        scanner.nextLine();//
        System.out.println("请输入学生地址");
        String address = scanner.nextLine();
        StudentEntity studentEntity = new StudentEntity(name, age, address);
        int result = studentService.insertStudent(studentEntity);
        if (result>0){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }
    //根据学生id修改学生信息
    public static void updateStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要修改的学生id");
        Long stuId = scanner.nextLong();
        //根据学生id查询学生信息
        StudentEntity student = studentService.getByIdStudent(stuId);
        if (student == null){
            System.out.println("没有查询到该学生id所对应的学生信息");
            return;
        }
        scanner.nextLine();
        System.out.println("请输入学生名称");
        String name = scanner.nextLine();
        System.out.println("请输入学生年龄");
        Integer age = scanner.nextInt();
        scanner.nextLine();//
        System.out.println("请输入学生地址");
        String address = scanner.nextLine();
        StudentEntity studentEntity = new StudentEntity(stuId,name, age, address);
        int result = studentService.updateStudent(studentEntity);
        if (result>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }
}
