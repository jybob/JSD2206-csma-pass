package cn.tedu.jsd2206.csmall.passport.mapper;

import cn.tedu.jsd2206.csmall.passport.pojo.entity.AdminRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRoleMapper {
    int insertBatch(List<AdminRole> adminRoleList);
}
