package study.dao;

import org.apache.ibatis.annotations.*;
import study.entity.Sheep;

import java.util.List;

/**
 * Created by Administrator on 2017/8/17.
 */
public interface SheepMapper {
    @Insert("insert into sheep(name,age,sex) values(#{name},#{age},#{sex}) ")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
        //id自增长
    void save(Sheep sheep);

    @Delete("delete *from sheep where id =#{id}")
    void delete(int id);

    List<Sheep> findByXml(@Param("age") int age);

    @Select("select *from sheep where age = #{age}")
    List<Sheep> getByAge(int age);



}