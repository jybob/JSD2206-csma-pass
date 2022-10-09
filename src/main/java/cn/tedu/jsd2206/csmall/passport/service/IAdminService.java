package cn.tedu.jsd2206.csmall.passport.service;

import cn.tedu.jsd2206.csmall.passport.pojo.dto.AdminAddNewDTO;
import cn.tedu.jsd2206.csmall.passport.pojo.vo.AdminListItemVO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理管理员数据的业务接口
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Repository
@Primary
public interface IAdminService {

    /**
     * 添加管理员
     *
     * @param adminAddNewDTO 管理员数据
     */
    void addNew(AdminAddNewDTO adminAddNewDTO);

    /**
     * 查询管理员列表
     *
     * @return 管理员列表
     */
    List<AdminListItemVO> list();
    /**
     * 删除相册
     *
     * @param id 尝试删除的相册的id
     */
    void delete(Long id);

}
