package cc.mrbird.febs.system.service;

import cc.mrbird.febs.system.entity.Dept;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class IDeptServiceTest {

    @Autowired
    private IDeptService deptService;


    @Test
    public void getDetpByParamTest() {
        Dept dept = deptService.getById(1L);
        Assert.assertThat(dept.getDeptName(),is("嘟嘟MD独立博客"));
        //Assert.assertThat(dept.getDeptName(),equalTo("sdfsdf"));
    }
}