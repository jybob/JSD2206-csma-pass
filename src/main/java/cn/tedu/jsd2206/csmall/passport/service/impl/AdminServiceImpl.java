package cn.tedu.jsd2206.csmall.passport.service.impl;




import cn.tedu.jsd2206.csmall.passport.ex.ServiceException;
import cn.tedu.jsd2206.csmall.passport.mapper.AdminMapper;
import cn.tedu.jsd2206.csmall.passport.mapper.AdminRoleMapper;
import cn.tedu.jsd2206.csmall.passport.pojo.dto.AdminAddNewDTO;
import cn.tedu.jsd2206.csmall.passport.pojo.entity.Admin;
import cn.tedu.jsd2206.csmall.passport.pojo.entity.AdminRole;
import cn.tedu.jsd2206.csmall.passport.pojo.vo.AdminListItemVO;
import cn.tedu.jsd2206.csmall.passport.pojo.vo.AdminStandardVO;
import cn.tedu.jsd2206.csmall.passport.service.IAdminService;
import cn.tedu.jsd2206.csmall.passport.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理管理员数据的业务实现类
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Slf4j
@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    AdminRoleMapper adminRoleMapper;

    public AdminServiceImpl() {
        log.info("创建业务实现类：AdminServiceImpl");
    }

    @Override
    public void addNew(AdminAddNewDTO adminAddNewDTO) {
        log.debug("开始处理【添加管理员】的业务，参数：{}", adminAddNewDTO);
        log.debug("即将检查用户名是否被占用……");
        {
            // 从参数对象中获取username
            String username = adminAddNewDTO.getUsername();
            // 调用adminMapper的countByUsername()方法执行统计查询
            int count = adminMapper.countByUsername(username);
            // 判断统计结果是否不等于0
            if (count != 0) {
                // 是：抛出异常
                String message = "添加管理员失败，用户名【" + username + "】已经被占用！";
                log.debug(message);
                throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
            }
        }

        log.debug("即将检查手机号码是否被占用……");
        {
            // 从参数对象中获取手机号码
            String phone = adminAddNewDTO.getPhone();
            // 调用adminMapper的countByPhone()方法执行统计查询
            int count = adminMapper.countByPhone(phone);
            // 判断统计结果是否不等于0
            if (count != 0) {
                // 是：抛出异常
                String message = "添加管理员失败，手机号码【" + phone + "】已经被占用！";
                log.debug(message);
                throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
            }
        }

        log.debug("即将检查电子邮箱是否被占用……");
        {
            // 从参数对象中获取电子邮箱
            String email = adminAddNewDTO.getEmail();
            // 调用adminMapper的countByEmail()方法执行统计查询
            int count = adminMapper.countByEmail(email);
            // 判断统计结果是否不等于0
            if (count != 0) {
                // 是：抛出异常
                String message = "添加管理员失败，电子邮箱【" + email + "】已经被占用！";
                log.debug(message);
                throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
            }
        }

        // 创建Admin对象
        Admin admin = new Admin();
        // 通过BeanUtils.copyProperties()方法将参数对象的各属性值复制到Admin对象中
        BeanUtils.copyProperties(adminAddNewDTO, admin);
        // TODO 从Admin对象中取出密码，进行加密处理，并将密文封装回Admin对象中
        // 补全Admin对象中的属性值：loginCount >>> 0
        admin.setLoginCount(0);
        // 调用adminMapper的insert()方法插入数据
        log.debug("即将插入管理员数据，参数：{}", admin);
        adminMapper.insert(admin);
        Long[] roleIds = adminAddNewDTO.getRoleIds();
        List<AdminRole> adminRoleList = new ArrayList<>();
        for (int i = 0; i < roleIds.length; i++) {
            AdminRole adminRole = new AdminRole();
            adminRole.setAdminId(admin.getId());
            adminRole.setRoleId(roleIds[i]);
            adminRoleList.add(adminRole);
        }
        adminRoleMapper.insertBatch(adminRoleList);
    }

    @Override
    public List<AdminListItemVO> list() {
        log.debug("开始处理【查询管理员列表】的业务");
        return adminMapper.list();
    }

    @Override
    public void delete(Long id) {
        log.debug("开始处理【删除管理员】的业务，参数：{}", id);
        // 调用Mapper对象的getDetailsById()方法执行查询
        AdminStandardVO queryResult = adminMapper.getStandardById(id);
        // 判断查询结果是否为null
        if (queryResult == null) {
            // 是：无此id对应的数据，抛出异常
            String message = "删除管理员失败，尝试访问的数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        // 调用Mapper对象的deleteById()方法执行删除
        log.debug("即将删除管理员数据……");
        adminMapper.deleteById(id);
        log.debug("删除管理员完成！");
    }
}
