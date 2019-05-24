package com.jsd.mapper;

import com.jsd.po.PagingPO;
import com.jsd.pojo.Student;

import java.util.List;

public interface StudentMapper {
    public List<Student> getAllStudent(PagingPO pagingPO);

    public Student getStudentByid(Integer student_id) ;

    public Integer  addStudent(Student student);

    public Integer updateStudent(Student student);

    public Integer  deleteStudent(Integer student_id);

    public Integer deleteStudentByClassesId(Integer student_classesid);

    public  List<Integer> queryAllStudentId();

    public List<Student> queryStudentByName(String student_name);

    public  Integer queryTotal();
}
