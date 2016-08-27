package com.yope.web;

import com.yope.domain.User;
import java.util.*;
import com.yope.domain.UserRepository;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;


/**
 * @author yope
 * @version 1.0.0
 * @date 16/08/27 02:34.
 * @github https://github.com/amazeyope
 */
@RestController
@RequestMapping(value = "/user")     // 通过这里配置使下面的映射都在/user下，可去除
public class UserController {

    @Resource
    private UserRepository userRepository;

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        userRepository.delete(id);
        return "success";
    }

    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @RequestMapping(value = "/putUser/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable("id") Long id, @RequestBody User user) {
        user.setId(id);
        userRepository.save(user);
        return "success";
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的用户名来获取用户详细信息")
    @RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
    public User findByName(@PathVariable String name) {
        return userRepository.findUser(name);
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/postUser", method = RequestMethod.POST)
    public User postUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = {"/getUserList"}, method = RequestMethod.GET)
    public List<User> getUserList() {
        List<User> usersList = userRepository.findAll();
        return usersList;
    }
}