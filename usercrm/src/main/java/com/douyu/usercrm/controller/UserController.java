package com.douyu.usercrm.controller;

import com.douyu.usercrm.entity.User;
import com.douyu.usercrm.service.UserService;
import com.douyu.usercrm.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    //生成验证码的方法
    @RequestMapping("getImage")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        //生成验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        //将验证码放入session
        session.setAttribute("code", securityCode);
        //生成图片
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        //输出图片
        ServletOutputStream os = response.getOutputStream();
        //调用工具类
        ImageIO.write(image, "png", os);
    }

    // 开发用户注册功能
    @PostMapping("register")
    public String register(User user, String code, HttpSession session) {
        System.out.println("user=" + user.toString());
        if (session.getAttribute("code").toString().equalsIgnoreCase(code)) {
            userService.save(user);
            return "redirect:/index.jsp";
        } else {
            System.out.println("验证码不通过");
            return "redirect:/resource/register.jsp";
        }
    }

    // 开发用户登录
    @RequestMapping("login")
    public String login(String username, String password, HttpSession session) {
        User user = userService.login(username, password);
        // 判断 user 为空，用户名密码错误
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/emp/findAll";//查询员工所有信息
        } else {
            System.out.println("不存在该员工");
            return "redirect:/index.jsp";
        }
    }

    // 开发用户信息修改
    @RequestMapping("edit")
    public String edit(User user, String id, HttpServletRequest request) {
        User curUser = userService.findUserById(id);
//        HttpSession session = request.getSession();
//        User curUser = (User) session.getAttribute("user");
        curUser.setUsername(user.getUsername());
        curUser.setNickname(user.getNickname());
        curUser.setPassword(user.getPassword());
        curUser.setTel(user.getTel());
        curUser.setSex(user.getSex());
        userService.update(curUser);
        return "redirect:/index.jsp";
    }

    // 开发用户找回密码
    @RequestMapping("findPassword")
    public String findPassword(String tel, String password) {
        // 查询所有用户的信息，用电话号码作为唯一表示来匹配
        List<User> allUser = userService.findAll();

        // 如果匹配到了则证明用户存在，并修改密码。否则用户不存在
        for (User user : allUser) {
            if (user.getTel().equals(tel)) {
                user.setPassword(password);
                userService.update(user);
                break;
            } else {
                System.out.println("该用户不存在");
            }
        }

        return "redirect:/index.jsp";
    }
}
