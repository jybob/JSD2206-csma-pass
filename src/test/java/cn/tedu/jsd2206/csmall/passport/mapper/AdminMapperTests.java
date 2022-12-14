package cn.tedu.jsd2206.csmall.passport.mapper;


import cn.tedu.jsd2206.csmall.passport.pojo.entity.Admin;
import cn.tedu.jsd2206.csmall.passport.pojo.vo.AdminStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class AdminMapperTests {

    @Autowired
    cn.tedu.jsd2206.csmall.passport.mapper.AdminMapper mapper;

    @Test
    void testInsert() {
        Admin admin = new Admin();
        admin.setUsername("wangkejing");
        admin.setPassword("123456");
        admin.setPhone("13800138001");
        admin.setEmail("wangkejing@baidu.com");

        log.debug("插入数据之前，参数：{}", admin);
        int rows = mapper.insert(admin);
        log.debug("插入数据完成，受影响的行数：{}", rows);
        log.debug("插入数据之后，参数：{}", admin);
    }

    @Test
    void testCountByUsername() {
        String username = "wangkejing";
        int count = mapper.countByUsername(username);
        log.debug("根据用户名【{}】统计管理员账号的数量：{}", username, count);
    }

    @Test
    void testCountByPhone() {
        String phone = "13800138001";
        int count = mapper.countByPhone(phone);
        log.debug("根据手机号码【{}】统计管理员账号的数量：{}", phone, count);
    }

    @Test
    void testCountByEmail() {
        String email = "wangkejing@baidu.com";
        int count = mapper.countByEmail(email);
        log.debug("根据电子邮箱【{}】统计管理员账号的数量：{}", email, count);
    }

    @Test
    void testList() {
        List<?> list = mapper.list();
        System.out.println("查询列表完成，列表中的数据的数量=" + list.size());
        for (Object item : list) {
            System.out.println(item);
        }
    }
    @Test
    void testGetStandardById() {
        Object a= mapper.getStandardById(8l);
        System.out.println(a);
    }
    @Test
    void testDeleteById() {
        Long id = 8L;
        int rows = mapper.deleteById(id);
        System.out.println("删除数据完成，受影响的行数=" + rows);
    }
}
