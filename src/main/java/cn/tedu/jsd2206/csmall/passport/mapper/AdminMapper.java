package cn.tedu.jsd2206.csmall.passport.mapper;

import cn.tedu.jsd2206.csmall.passport.pojo.entity.Admin;
import cn.tedu.jsd2206.csmall.passport.pojo.vo.AdminListItemVO;
import cn.tedu.jsd2206.csmall.passport.pojo.vo.AdminStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理管理员数据的Mapper接口
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Repository
public interface AdminMapper {
    /**
     * 插入管理员数据
     *
     * @param admin 管理员数据
     * @return 受影响的行数
     */
    int insert(Admin admin);

    /**
     * 根据id删除管理员数据
     *
     * @param id 管理员id
     * @return 受影响的行数
     */
    int deleteById(Long id);

    /**
     * 根据用户名统计管理员的数量
     *
     * @param username 用户名
     * @return 匹配用户名的管理员的数据
     */
    int countByUsername(String username);

    /**
     * 根据手机号码统计管理员的数量
     *
     * @param phone 手机号码
     * @return 匹配手机号码的管理员的数据
     */
    int countByPhone(String phone);

    /**
     * 根据电子邮箱统计管理员的数量
     *
     * @param email 电子邮箱
     * @return 匹配电子邮箱的管理员的数据
     */
    int countByEmail(String email);

    /**
     * 根据id查询管理员详情
     *
     * @param id 管理员id
     * @return 匹配的管理员详情，如果没有匹配的数据，则返回null
     */
    AdminStandardVO getStandardById(Long id);

    /**
     * 查询管理员列表
     *
     * @return 管理员列表
     */
    List<AdminListItemVO> list();

}
