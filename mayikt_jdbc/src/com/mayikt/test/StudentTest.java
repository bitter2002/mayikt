package com.mayikt.test;

import com.mayikt.entity.StudentEntity;
import com.mayikt.service.StudentService;

import java.util.ArrayList;

public class StudentTest {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        ArrayList<StudentEntity> studentEntities = studentService.allStudent();
       for (StudentEntity stu : studentEntities){
           System.out.println(stu);
       }


//        StudentEntity student = studentService.getByIdStudent(8l);//Long类型
//        System.out.println(student);


//        StudentEntity studentEntity = new StudentEntity("罗尧中", 20, "南昌");
//        int result = studentService.insertStudent(studentEntity);
//        if(result>0){
//            System.out.println("数据插入成功");
//        }else {
//            System.out.println("数据插入成功");
//        }

        updateTestStudent();
        deleteStudentTest();
    }

    public static void updateTestStudent() {
        //1.查询原来学生信息
        StudentService studentService = new StudentService();
        Long stuId = 1l;
        StudentEntity studentEntity = studentService.getByIdStudent(stuId);
        if (studentEntity == null) {
            return;
        }
        //修改学生名称
        studentEntity.setName("罗尧中6");
        studentEntity.setAge(100);
        studentEntity.setAddress("吉安");
        int result = studentService.updateStudent(studentEntity);
        if (result>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }

    }
    public static void deleteStudentTest(){
        //1.删除学生信息
        Long id = 12l;
        //2.在删除之前,查询db中是否存在该条数据
        StudentService studentService = new StudentService();
        StudentEntity student = studentService.getByIdStudent(id);
        if (student == null){
            System.out.println("数据库中没有该数据,无法删除");
            return;
        }
        int result = studentService.deleteStudent(id);
        if (result>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }
}
