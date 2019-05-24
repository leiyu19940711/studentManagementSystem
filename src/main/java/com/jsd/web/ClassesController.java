package com.jsd.web;

import com.alibaba.fastjson.JSON;
import com.jsd.po.ClassesPO;
import com.jsd.po.PagingPO;
import com.jsd.pojo.Classes;
import com.jsd.pojo.Student;
import com.jsd.service.ClassesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(description = "班级接口")
@RestController
public class ClassesController {
    @Autowired
    private ClassesService classesService;
    @ApiOperation(value = "查询所有班级" ,  notes="查询所有班级")
    @RequestMapping(value="/queryallclasses",method=RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String queryAllStudent(@RequestBody PagingPO pagingPO){
        if(pagingPO.getTotalNum()<=0){
            return "分页显示每页的数量错误";
        }
        Integer totalNum=classesService.queryTotal();
        if(pagingPO.getStartNum()>totalNum-1){
            return "分页显示开始取数据值大于总记录数,总记录数为："+totalNum;
        }
        List<Classes> list = classesService.getAllClasses(pagingPO);
        return JSON.toJSONString(list);
    }
    @ApiOperation(value = "查询所有班级id" ,  notes="查询所有班级id")
    @GetMapping("/queryClassesId")
    @ResponseBody
    public String queryClassesId(){
        List<Integer> list = classesService.queryClassesId();
        return JSON.toJSONString(list);
    }


    @ApiOperation(value = "查询班级根据班级id" ,  notes="查询班级")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "classes_id", value = "班级id标识", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value="/queryclassesbyid",method=RequestMethod.GET)
    public String queryClassesById(@RequestParam("classes_id") Integer classes_id){
        List<Integer> list = classesService.queryClassesId();
        if(!list.contains(classes_id)){
            return "输入的班级id不存在";
        }
        Classes classes=classesService.getClassesByid(classes_id);
        return JSON.toJSONString(classes);
    }

    @ApiOperation(value = "新增班级" ,  notes="新增班级")
    @RequestMapping(value="/addclasses",method=RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public String  addClasses(@RequestBody ClassesPO classesPO){
        List<Integer> list = classesService.queryClassesId();
        if(list.contains(classesPO.getClasses_id())){
            return "输入的班级id已存在";
        }
        Classes classes=new Classes();
        BeanUtils.copyProperties(classesPO,classes);
        int i= classesService.addClasses(classes);
        if(i>0){
            return "添加成功";
        }else{
            return "添加失败";
        }
    }

    @ApiOperation(value = "修改班级信息" ,  notes="修改班级信息")
    @RequestMapping(value="/updateclasses",method=RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public String updateStudent(@RequestBody ClassesPO classesPO){
        List<Integer> list = classesService.queryClassesId();
        if(!list.contains(classesPO.getClasses_id())){
            return "输入的班级id不存在";
        }
        Classes classes=new Classes();
        BeanUtils.copyProperties(classesPO,classes);
        int i= classesService.updateClasses(classes);
        if(i>0){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

    @ApiOperation(value = "删除班级" ,  notes="删除班级")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "classes_id", value = "班级标识", required = true, paramType = "query", dataType = "Long")
    })
    @RequestMapping(value="/deleteclasses",method= RequestMethod.DELETE)
    public String deleteUser(@RequestParam("classes_id") Integer classes_id){
        List<Integer> list = classesService.queryClassesId();
        if(!list.contains(classes_id)){
            return "输入的班级id不存在";
        }
        int i= classesService.deleteClassesByid(classes_id);
        if(i>0){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }

}
