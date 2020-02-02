/**
 * Copyright (C), 2020-2020, code_fusheng
 * FileName: IndexHandler
 * Author:   25610
 * Date:     2020/2/1 21:37
 * Description:
 * History:
 * <author>        <time>      <version>       <desc>
 * 作者姓名       修改时间       版本号         描述
 */
package xyz.fusheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.fusheng.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexHandler {

    @GetMapping("/index")
    public String index(Model model){
        System.out.println("index....");
        List<Student> list = new ArrayList<>();
        list.add(new Student(1L,"fusheng",22));
        list.add(new Student(2L,"zhanghao",21));
        list.add(new Student(3L,"gonglin",20));
        model.addAttribute("list",list);
        return "index";
    }
}
