# lesson-3 Spring Boot 整合 Thymeleaf

***Spring Boot 配置 Thymeleaf 整合 HTML***

**Thymeleaf 模板是面向 Web 和独立环境的 Java 模板引擎，能够处理 HTML、XML、JavaScript、CSS等。**

* 1、创建简单 Maven 工程
![image](137E763C072B41189C67C80918E01C31)

* 2、pom.xml 中添加相关依赖，spring-boot-starter-thymeleaf 为 Spring Boot 整合 Thymeleaf 模板的依赖
```xml
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.4.RELEASE</version>
    </parent>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.10</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>
```

* 3、在 resources 路径下创建 application.yml
```yml
spring:
  thymeleaf:
    prefix: classpath:/templates/     #模版路径
    suffix: .html                     #模版后缀
    servlet:
      content-type: text/html         #设置Content-type
    encoding: UTF-8                   #编码方式
    mode: HTML5                       #校验HTML5格式
    cache: false
```
***这里的配置和使用 JSP 类似，通过前缀后后缀完成视图解析，同时可以设置 HTML 页面的其他属性、编码方式等***

***PS ：此处的内容若是缩进不当，会造成无妨访问templates文件资源***

* 4、创建实体对象类 Student类 
```java
package xyz.fusheng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private long id;
    private String name;
    private int age;
}

```


* 5、创建 控制类 IndexHandler 业务方法，向客户端返回视图和业务数据。
```java
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
```
* 5、在 resources/templates 路径下创建 index.html
```html
<!DOCTYPE html>
<html xmlns:th="www.thymeleaf.org"></html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>学生ID</th>
            <th>学生姓名</th>
            <th>学生年龄</th>
        </tr>
        <tr th:each="student:${list}" >
            <td th:text="${student.id}"></td>
            <td th:text="${student.name}"></td>
            <td th:text="${student.age}"></td>
        </tr>
    </table>
</body>
</html>
```

***项目结构：***
![image](442F59C5056D455685A54720E7774D79)
***项目结果：***
![image](C8A7F6C8F33643CF8A9F99F8B71A5661)
