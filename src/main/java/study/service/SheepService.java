package study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.dao.SheepMapper;
import study.entity.Sheep;

import java.util.List;

/**
 * Created by Administrator on 2017/8/17.
 */
@Service
public class SheepService {
    @Autowired
    private SheepMapper sheepMapper;

    public List<Sheep> getByAge(int age) {
        return sheepMapper.getByAge(age);
    }
}