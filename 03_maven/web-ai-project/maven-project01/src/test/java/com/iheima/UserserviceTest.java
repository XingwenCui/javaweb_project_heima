package com.iheima;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
 test class
 Junit的单元测试主要测试方法，可以一键运行所有的测试方法。
 1. 在pom.xml中引入JUnit的依赖
 2. 在test/java目录下，创建测试类，并编写对应的测试方法，并在方法上声明Test注解
 3. 命名规范：XxxxTest。Junit单元测试的方法，必须声明为public void
 */
public class UserserviceTest {

    @Test
    public void testGetAge(){
        UserService userService = new UserService();
        Integer age = userService.getAge("100000200010011011");
        System.out.println(age);
    }

    @Test
    public void testGetGender(){
        UserService userService = new UserService();
        String gender = userService.getGender("100000200010011011");
        System.out.println(gender);
    }

    /*
    Assert
     */
    @Test
    public void testGenderWithAssert() {
        UserService userService = new UserService();
        String gender = userService.getGender("100000200010011011");
        Assertions.assertEquals("男", gender,"性别获取错误");
    }


    @Test
    public void testGenderWithAssert2() {
        UserService userService = new UserService();
        // 断言
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            userService.getGender(null);
        });
    }

    /**
     * 参数化测试，依次传参
     */
    @DisplayName("测试用户性别")
    @ParameterizedTest
    @ValueSource(strings = {"100000200010011011", "100000200010011031"})
    public void testGetGender3(String idCard) {
        UserService userService = new UserService();
        String gender = userService.getGender(idCard);
        Assertions.assertEquals("男", gender);
    }


}
