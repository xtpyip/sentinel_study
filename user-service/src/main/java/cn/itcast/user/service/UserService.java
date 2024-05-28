package cn.itcast.user.service;

import cn.itcast.user.mapper.UserMapper;
import cn.itcast.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id) throws InterruptedException {
        if(id == 1){
            // 触发慢调用
            Thread.sleep(60);
        }else if(id == 2){
            throw new RuntimeException("故意拋出异常，触发异常比例熔断");
        }
        return userMapper.findById(id);
    }
}