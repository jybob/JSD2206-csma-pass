package cn.tedu.jsd2206.csmall.passport.controller;


import cn.tedu.jsd2206.csmall.passport.pojo.dto.AdminAddNewDTO;
import cn.tedu.jsd2206.csmall.passport.pojo.vo.AdminListItemVO;
import cn.tedu.jsd2206.csmall.passport.service.IAdminService;
import cn.tedu.jsd2206.csmall.passport.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "01. 管理员管理模块")
@RestController
@RequestMapping("/admins")
public class AdminController {


    @Autowired
    IAdminService adminService;

    public AdminController() {
        log.info("创建控制器类：AdminController");
    }

    // http://localhost:9081/admins/add-new?username=aa&phone=bb&email=cc
    @ApiOperation("添加管理员")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-new")
    public JsonResult addNew(AdminAddNewDTO adminAddNewDTO) {
        log.debug("开始处理【添加管理员】的请求，参数：{}", adminAddNewDTO);
        adminService.addNew(adminAddNewDTO);
        return JsonResult.ok();
    }
    @ApiOperation("删除管理员")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParam(name = "id", value = "管理员id", required = true, dataType = "long")
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult<Void> delete(@PathVariable Long id) {
        log.debug("开始处理【删除管理员】的请求，参数：{}", id);
        adminService.delete(id);
        return JsonResult.ok();
    }
    // http://localhost:9081/admins
    @ApiOperation("查询管理员列表")
    @ApiOperationSupport(order = 420)
    @GetMapping("")
    public JsonResult<List<AdminListItemVO>> list() {
        log.debug("开始处理【查询管理员列表】的请求");
        List<AdminListItemVO> list = adminService.list();
        return JsonResult.ok(list);
    }

}