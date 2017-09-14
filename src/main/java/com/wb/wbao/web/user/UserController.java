package com.wb.wbao.web.user;

import com.wb.wbao.server.user.User;
import com.wb.wbao.server.user.UserMgr;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dell on 2017/7/2.
 * 控制器
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserMgr userMgr;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping(value = "/{id}")
    public User queryById(@PathVariable Long id){
        return userMgr.queryUserById(id);
    }

    @ApiOperation(value = "创建用户",notes = "根据用户名、密码、入学年份、用户姓名创建用户")
    @ApiImplicitParam(name = "user", value = "用户", required = true, dataType = "User")
    @PostMapping
    public List<User> createUser(@RequestBody User user){
        userMgr.createUser(user);
        logger.info("create a user");
        return userMgr.queryAll();
    }

    @ApiOperation(value = "查询用户", notes = "查询所有用户")
    @GetMapping
    public List<User> queryAllUsers() {
        return userMgr.queryAll();
    }

    @ApiOperation(value = "修改",notes = "根据用户名、密码、入学年份、用户姓名修改用户")
    @ApiImplicitParam(name = "user", value = "用户", required = true, dataType = "User")
    @PutMapping
    public List<User> modifyUser(@RequestBody User user){
        userMgr.modifyUser(user);
        return userMgr.queryAll();
    }

    @ApiOperation(value = "删除用户",notes = "根据id删除用户")
    @ApiImplicitParam(name = "idList", value = "用户id集合", required = true, dataType = "ArrayList")
    @DeleteMapping(value = {"/{idList}"})
    public List<User> removeUsers(@PathVariable List<Long> idList){

        userMgr.removeUsers(idList);

        return userMgr.queryAll();
    }
}