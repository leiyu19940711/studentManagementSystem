package com.jsd.service.impl;

import com.jsd.mapper.ClassesMapper;
import com.jsd.po.PagingPO;
import com.jsd.pojo.Classes;
import com.jsd.service.ClassesService;
import com.jsd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesMapper classesMapper;
    @Autowired
    private StudentService studentService;

    @Override
    public List<Classes> getAllClasses( PagingPO pagingPO) {
        return classesMapper.getAllClasses(pagingPO);
    }

    @Override
    public Classes getClassesByid(Integer classes_id) {
        return classesMapper.getClassesByid(classes_id);
    }

    @Override
    public Integer addClasses(Classes classes) {
        classes.setCreateTime(new Date());
        classes.setUpdateTime(new Date());
        return classesMapper.addClasses(classes);
    }

    @Override
    public Integer updateClasses(Classes classes) {
        classes.setUpdateTime(new Date());
        return classesMapper.updateClasses(classes);
    }

    @Override
    public Integer deleteClassesByid(Integer classes_id) {
        int i=classesMapper.deleteClasses(classes_id);
        if(i>0){
            studentService.deleteStudentByClassesId(classes_id);
        }
        return i;
    }

    @Override
    public List<Integer> queryClassesId() {
        return classesMapper.queryClassesId();
    }
    @Override
    public  Integer queryTotal(){
        return classesMapper.queryTotal();
    }
}
