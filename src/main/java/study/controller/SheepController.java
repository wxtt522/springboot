package study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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


    @RequestMapping("/")
    public String home(){
        return "fuck!";
    }
}