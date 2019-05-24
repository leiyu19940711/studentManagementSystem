package com.jsd.service;

import com.jsd.po.PagingPO;
import com.jsd.pojo.Classes;
import com.jsd.pojo.Student;

import java.util.List;

public interface ClassesService {
    /*
              author:leiyu
              方法名：getAllClasses
              作用：获取所有班级信息
           */
    public List<Classes> getAllClasses(PagingPO pagingPO);
    /*
                  author:leiyu
                  方法名：getClassesByid
                  作用：根据班级id获取班级信息
               */
    public  Classes getClassesByid(Integer classes_id);
    /*
                  author:leiyu
                  方法名：addClasses
                  作用：添加班级信息
               */
    public Integer  addClasses(Classes classes);
    /*
               author:leiyu
               方法名：updateClasses
               作用：修改班级信息
            */
    public Integer updateClasses(Classes classes);
    /*
               author:leiyu
               方法名：deleteClassesByid
               作用：根据班级id删除班级
            */
    public  Integer  deleteClassesByid(Integer classes_id);
    /*
            author:leiyu
            方法名：queryClassesId
            作用：查询所有班级id
         */
    public List<Integer>  queryClassesId();
    /*
          author:leiyu
          方法名：queryTotal
          作用：查询存在班级总记录数
       */
    public  Integer queryTotal();

}
