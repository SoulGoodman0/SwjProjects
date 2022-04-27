package cn.bdqn.controller;

import cn.bdqn.pojo.PageBean;
import cn.bdqn.pojo.User;
import cn.bdqn.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/findUserByName")
    public String findUserByName(@RequestParam(name = "queryname",defaultValue = "",required = false) String queryname,
                                 @RequestParam(name = "currPageNo",defaultValue = "1",required = false) Integer currPageNo,Model model){
        System.out.println("这是Controller输出查询条件测试!!!   "+queryname);
        System.out.println("这是Controller输出当前页测试!!!   "+currPageNo);
        PageBean<User> pageBean = userService.findUserByName(queryname,currPageNo,5);
        model.addAttribute("list",pageBean);
        model.addAttribute("queryname",queryname);
        return "list";
    }


    @RequestMapping("/toAdd")
    public String toAdd(User user){
        return "add";
    }

    @RequestMapping("/add")
    public String add(User user){
        userService.add(user);
        return "redirect:findUserByName";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam Integer id){
        userService.delete(id);
        return "redirect:findUserByName";
    }

    @RequestMapping("/toupdate")
    public String toupdate(@RequestParam Integer id,Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "update";
    }

    @RequestMapping("/update")
    public String update(User user){
        userService.update(user);
        return "redirect:findUserByName";
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }



}
