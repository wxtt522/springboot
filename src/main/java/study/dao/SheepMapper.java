package study.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import study.entity.Sheep;

import java.util.List;

/**
 * Created by Administrator on 2017/8/17.
 */
    public interface SheepMapper {
    @Insert("insert into sheep(name,age,sex) values(#{name},#{age},#{sex}) ")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")   //id自增长
    public void save(Sheep sheep);

    @Delete("delete *from sheep where id =#{id}")
    public void delete(int id);

    @Select("select *from sheep")
    public List<Sheep> findAll();

    @Select("select *from sheep where age = #{age}")
    public List<Sheep> getByAge(int age);


}