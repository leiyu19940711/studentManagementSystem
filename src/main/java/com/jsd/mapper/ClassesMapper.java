package com.jsd.mapper;

import com.jsd.po.PagingPO;
import com.jsd.pojo.Classes;


import java.util.List;

public interface ClassesMapper {
    public List<Classes> getAllClasses(PagingPO pagingPO);

    public Classes getClassesByid(Integer classes_id) ;

    public Integer  addClasses(Classes classes);

    public Integer updateClasses(Classes classes);

    public Integer  deleteClasses(Integer student_id);

    public List<Integer> queryClassesId();
    public  Integer queryTotal();


}
