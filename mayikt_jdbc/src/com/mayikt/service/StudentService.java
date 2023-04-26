package com.mayikt.service;

import com.mayikt.dao.StudentDao;
import com.mayikt.entity.StudentEntity;

import java.util.ArrayList;

public class StudentService {
    private StudentDao studentDao = new StudentDao();

    public ArrayList<StudentEntity> allStudent() {
        //通过业务逻辑层调用dao层代码
        ArrayList<StudentEntity> studententities = studentDao.allStudent();
        return studententities;
    }
    public StudentEntity getByIdStudent(Long stuId){
        return studentDao.getByIdStudent(stuId);
    }
    public int insertStudent(StudentEntity stu){
        return studentDao.insertStudent(stu);
    }
    public int updateStudent(StudentEntity stu){
        return studentDao.updateStudent(stu);
    }
    public int deleteStudent(Long id){
        return studentDao.deleteStudent(id);
    }
}
