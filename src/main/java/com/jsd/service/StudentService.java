package com.jsd.service;

import com.jsd.po.PagingPO;
import com.jsd.pojo.Student;

import java.util.List;
public interface StudentService {
    /*
        author:leiyu
        方法名：getAllStudent
        作用：分页查询所有的学生
     */
    public List<Student> getAllStudent(PagingPO pagingPO);
    /*
            author:leiyu
            方法名：getStudentByid
            作用：根据学生id查询学生
         */
    public  Student getStudentByid(Integer student_id);
    /*
            author:leiyu
            方法名：addStudent
            作用：添加学生
         */
    public Integer  addStudent(Student student);
    /*
            author:leiyu
            方法名：updateStudent
            作用：修改学生
         */
    public Integer updateStudent(Student student);
    /*
            author:leiyu
            方法名：deleteStudentByid
            作用：根据学生id删除学生
         */
    public  Integer  deleteStudentByid(Integer student_id);
    /*
            author:leiyu
            方法名：deleteStudentByClassesId
            作用：删除班级时联动删除班级下所有学生
         */
    public  Integer deleteStudentByClassesId(Integer Classes_id);
    /*
            author:leiyu
            方法名：queryAllStudentId
            作用：查询所有学生id
         */
    public  List<Integer> queryAllStudentId();

    /*
        author:leiyu
        方法名：queryStudentByName
        作用：根据名字查询学生
     */
    public List<Student> queryStudentByName(String student_name);
    /*
        author:leiyu
        方法名：queryTotal
        作用：查询存在学生总记录数
     */
     public  Integer queryTotal();
}

