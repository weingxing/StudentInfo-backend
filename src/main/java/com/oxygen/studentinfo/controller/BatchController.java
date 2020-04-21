package com.oxygen.studentinfo.controller;

import com.oxygen.studentinfo.config.CommonConfig;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.*;
import com.oxygen.studentinfo.service.*;
import com.oxygen.studentinfo.util.ExcelReaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;


/**
 * 批量添加学生信息
 * @author oxygen
 * @since 2020/03/06
 */
@RestController
@RequestMapping("/page/api")
public class BatchController {

    @Autowired
    private FileService fileService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CollegeService collegeService;
    @Autowired
    private MajorService majorService;
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/batchAdd")
    public Response batchAdd(@RequestParam("file")MultipartFile file) throws Exception {
        // 保存文件并取得文件路径
        String path = (String)fileService.upload(file).getContent();
        // 读取Excel数据
        List<List<String>> lists = ExcelReaderUtil.readExcel(path);
        //解析插入到数据库
        Student student = new Student();
        assert lists != null;
        for (List<String> list : lists.subList(1, lists.size())) {
            Category category = categoryService.selectByName(list.get(3));
            Clazz clazz = clazzService.selectByName(list.get(5));
            Department department = departmentService.selectByName(list.get(7));
            Major major = majorService.selectByName(list.get(8));
            College college = collegeService.selectByName(list.get(9));

            student.setSno(list.get(0));
            student.setName(list.get(1));
            student.setSex(list.get(2));

            if (category == null) {
                Category record = new Category();
                record.setName(list.get(3));
                categoryService.add(record);
                category = categoryService.selectByName(list.get(3));
                student.setCategory(category.getId());
            } else
                student.setCategory(category.getId());

            student.setDescCategory(list.get(4));

            if (clazz == null) {
                Clazz record = new Clazz();
                record.setName(list.get(5));
                record.setGrade(list.get(6));
                clazzService.add(record);
                clazz = clazzService.selectByName(list.get(5));
                student.setClazz(clazz.getId());
            } else
                student.setClazz(clazz.getId());

            if (department == null) {
                Department record = new Department();
                record.setName(list.get(7));
                departmentService.add(record);
                department = departmentService.selectByName(list.get(7));
                student.setDepartment(department.getId());
            } else
                student.setDepartment(department.getId());

            if (major == null) {
                Major record = new Major();
                record.setName(list.get(8));
                majorService.add(record);
                major = majorService.selectByName(list.get(8));
                student.setMajor(major.getId());
            } else
                student.setMajor(major.getId());

            if (college == null) {
                College record = new College();
                record.setName(list.get(9));
                collegeService.add(record);
                college = collegeService.selectByName(list.get(9));
                student.setCollege(college.getId());
            } else
                student.setCollege(college.getId());

            student.setPhone(list.get(10));
            student.setIdcard(list.get(11));
            student.setAddress(list.get(12));
            student.setRemark(list.get(13));
            student.setPhoto(CommonConfig.domain + student.getSno() + ".jpg");

            studentService.add(student);
        }

        return new Response(new Date().toString(), 1, "添加成功", null);
    }

}
