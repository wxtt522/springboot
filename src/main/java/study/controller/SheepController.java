package study.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import study.entity.Sheep;
import study.service.SheepService;

import javax.annotation.Resource;
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