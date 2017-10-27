package study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import study.entity.Sheep;
import study.service.SheepService;

import java.util.List;

/**
 * Created by Administrator on 2017/10/24.
 */
@Controller
public class LeafController {
    @Autowired
    SheepService sheepService;

    @RequestMapping("/thymeleaf")
    public String toLeaf(int age ,ModelMap map){
        List<Sheep> sheepList = sheepService.getByAge(age);
        map.addAttribute("sheepList", sheepList);
        return "thymeleaf";
    }
}
