package com.jsd.web;

import com.alibaba.fastjson.JSON;
import com.jsd.po.PagingPO;
import com.jsd.po.StudentPO;
import com.jsd.pojo.Classes;
import com.jsd.service.ClassesService;
import com.jsd.service.StudentService;
import com.jsd.pojo.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "学生接口")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassesService classesService;

    @ApiOperation(value = "查询所有学生" ,  notes="查询所有学生")
    @RequestMapping(value="/getallstudent",method=RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
   public String getAllStudent(@RequestBody PagingPO pagingPO){
        if(pagingPO.getTotalNum()<=0){
            return "分页显示每页的数量错误";
        }
        Integer totalNum=studentService.queryTotal();
        if(pagingPO.getStartNum()>totalNum-1){
            return "分页显示开始取数据值大于总记录数,总记录数为："+totalNum;
        }
        List<Student> list = studentService.getAllStudent(pagingPO);
       return JSON.toJSONString(list);
   }

    @ApiOperation(value = "查询用户根据id" ,  notes="查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "student_id", value = "学生id标识", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value="/querystudentbyid",method=RequestMethod.GET)
    public String queryStudentById(@RequestParam("student_id") Integer student_id){
        List<Integer> idList=studentService.queryAllStudentId();
        if(!idList.contains(student_id)){
            return "学生id不存在";
        }
        Student student=studentService.getStudentByid(student_id);
        return JSON.toJSONString(student);
    }

    @ApiOperation(value = "新增学生" ,  notes="新增学生")
    @RequestMapping(value="/addstudent",method=RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public String  addstudent(@RequestBody StudentPO studentPO){
        if(studentPO.getStudent_age()<0||studentPO.getStudent_age()>150){
            return "学生年龄输入错误";
        }
        List<Integer> idList=classesService.queryClassesId();
        if(!idList.contains(studentPO.getStudent_classesId())){
            return "输入班级id不存在";
        }
        List<Integer> siList=studentService.queryAllStudentId();
        if(siList.contains(studentPO.getStudent_id())){
            return "输入的学生id已存在";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentPO,student);
        int i= studentService.addStudent(student);
        if(i>0){
            return "添加成功";
        }else{
            return "添加失败";
        }
    }

    @ApiOperation(value = "修改学生信息" ,  notes="修改学生信息")
    @RequestMapping(value="/updateStudent",method=RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public String updateStudent(@RequestBody StudentPO studentPO){
        List<Integer> idList1=studentService.queryAllStudentId();
        if(!idList1.contains(studentPO.getStudent_id())){
            return "学生id不存在";
        }
        if(studentPO.getStudent_age()<=0||studentPO.getStudent_age()>150){
            return "学生年龄输入错误";
        }
        List<Integer> idList=classesService.queryClassesId();
        if(!idList.contains(studentPO.getStudent_classesId())){
            return "输入班级id不存在";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentPO,student);
        int i= studentService.updateStudent(student);
        if(i>0){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

    @ApiOperation(value = "删除学生" ,  notes="删除学生")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "student_id", value = "学生标识", required = true, paramType = "query", dataType = "Integer")
    })
    @RequestMapping(value="/deleteStudent",method= RequestMethod.DELETE)
    public String deleteStudent(@RequestParam("student_id") Integer student_id){
        List<Integer> idList=studentService.queryAllStudentId();
        if(idList.contains(student_id)){
            return "学生id不存在";
        }
       int i= studentService.deleteStudentByid(student_id);
       if(i>0){
           return "删除成功";
       }else{
           return "删除失败";
       }
    }
    @ApiOperation(value = "查询学生根据名字" ,  notes="查询学生")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "student_name", value = "学生名字标识", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value="/querystudentbyname",method=RequestMethod.GET)
    public String  queryStudentByName(@RequestParam("student_name") String student_name){
       if(student_name.isEmpty()){
           return "输入的学生名字为空";
       }
        String s="%"+student_name+"%";
        List<Student> list=studentService.queryStudentByName(s);
        return JSON.toJSONString(list);
    }

}
