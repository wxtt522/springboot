package study.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import study.entity.Sheep;
import study.service.SheepService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/8/17.
 */
@RestController
public class SheepController {
    @Resource
    private SheepService sheepService;

    @RequestMapping("/get")
    public List<Sheep> getByAge(int age) {
        return sheepService.getByAge(age);
    }

    @RequestMapping("/save")
    public void save(Sheep sheep){
        sheepService.saveSheep(sheep);
    }

    @RequestMapping("/getByXml")
    public List<Sheep> getByMapper(int age) {
        return sheepService.getxml(age);
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("getCode")
    public void getCode(String phoneNumber,HttpServletRequest request){
        int code= (int) ((Math.random()*9+1)*1000);
        /**手机发送验证码
         * 验证码存入session
         */
        HttpSession session = request.getSession();
        session.setAttribute("code",code);
    }

    @RequestMapping("register")
    public String  register(String userName,String password,String code,HttpServletRequest request){
        HttpSession session = request.getSession();
        Object sessionCode = session.getAttribute("code");
        if (sessionCode != null&&code.equals(sessionCode)) {
            /**添加账户，跳入登录页面，删除验证码*/
            session.removeAttribute("code");
            return "login";
        }
        /**否则返回注册页面，抛出错误*/
        return "register";
    }

    public String login(String userName,String password){
        /***/
        return "index";
    }


    /**@PathVariable
     * 接受数据方式
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable Long id, ModelMap map) {
//        map.addAttribute("user", userService.findById(id));
        map.addAttribute("action", "update");
        return "userForm";
    }

    /**转发的方式*/
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postUser(@ModelAttribute Sheep user) {
//        userService.insertByUser(user);
        return "redirect:/users/";
    }


//    @RequestMapping("/")
//    public String home(){
//        return "fuck!";
//    }
}