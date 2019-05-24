package com.jsd.service.impl;

import com.jsd.po.PagingPO;
import com.jsd.service.ClassesService;
import com.jsd.service.StudentService;
import com.jsd.mapper.StudentMapper;
import com.jsd.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassesService classesService;

    @Override
    public List<Student> getAllStudent(PagingPO pagingPO) {
        return studentMapper.getAllStudent(pagingPO);
    }

    @Override
    public Integer addStudent(Student student) {
        student.setCreateTime(new Date());
        student.setUpdateTime(new Date());
        int i=studentMapper.addStudent(student);
        return  i;
    }

    @Override
    public Integer updateStudent(Student student) {
        boolean flag= true;
        int i =0;
        student.setUpdateTime(new Date());
        List<Integer> idList=classesService.queryClassesId();
        flag=idList.contains(student.getStudent_classesId());
        if(student.getStudent_age()<0||student.getStudent_age()>150){
            flag=false;
        }
        if(flag){
            i =studentMapper.updateStudent(student);
        }
        return i;
    }

    @Override
    public Student getStudentByid(Integer student_id) {

        return studentMapper.getStudentByid(student_id);
    }

    @Override
    public Integer  deleteStudentByid(Integer student_id) {
        int i=studentMapper.deleteStudent(student_id);
        return i;
    }

    @Override
    public Integer deleteStudentByClassesId(Integer Classes_id) {
        int i=studentMapper.deleteStudentByClassesId(Classes_id);
        return 0;
    }
    @Override
    public  List<Integer> queryAllStudentId() {
        return studentMapper.queryAllStudentId();
    }
    @Override
    public List<Student> queryStudentByName(String student_name){
        return studentMapper.queryStudentByName(student_name);
    }
    @Override
    public  Integer queryTotal(){
       return studentMapper.queryTotal();
    }
}
