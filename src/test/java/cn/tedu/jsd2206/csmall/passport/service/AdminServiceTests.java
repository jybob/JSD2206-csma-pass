package cn.tedu.jsd2206.csmall.passport.service;

import cn.tedu.jsd2206.csmall.passport.ex.ServiceException;
import cn.tedu.jsd2206.csmall.passport.pojo.dto.AdminAddNewDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class AdminServiceTests {

    @Autowired
    IAdminService service;

    @Test
    void testAddNew() {
        AdminAddNewDTO adminAddNewDTO = new AdminAddNewDTO();
        adminAddNewDTO.setUsername("wangkejing9");
        adminAddNewDTO.setPassword("123456");
        adminAddNewDTO.setPhone("13800138009");
        adminAddNewDTO.setEmail("wangkejing9@baidu.com");
        adminAddNewDTO.setRoleIds(new Long[]{3L, 4L, 5L});
        try {
            service.addNew(adminAddNewDTO);
            log.debug("添加管理员成功！");
        } catch (ServiceException e) {
            log.debug("{}", e.getMessage());
        }
    }

    @Test
    void testList() {
        List<?> list = service.list();
        System.out.println("查询列表完成，列表中的数据的数量=" + list.size());
        for (Object item : list) {
            System.out.println(item);
        }
    }
    @Test
    void testDelete() {
        Long id = 18L;

        try {
            service.delete(id);
            System.out.println("删除管理员成功！");
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
    }

}
