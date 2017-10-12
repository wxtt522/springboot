package study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import study.entity.Sheep;
import study.service.SheepService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/10/11.
 */
@Controller
public class testController {

    @Resource
    private SheepService sheepService;

    @RequestMapping("/")
    public ModelAndView sheeplist(){
        List<Sheep> sheepList =sheepService.getByAge(12);
        //真是搞笑，原来我一直用的就是modelandview，还满世界的找 modelandview 如何跳转
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("sheepList", sheepList);
        return modelAndView;
    }

    /**那再来一发 model的视图*/
}
