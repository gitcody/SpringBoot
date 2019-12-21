package com.zhangwei.springboot.mapper;

import com.zhangwei.springboot.entities.Provider;
import org.apache.ibatis.annotations.*;

/**
 * @Auther: ZhangWei
 * @Date: 2019/12/2 21:01
 * @Description:
 */

public interface ProviderMapper {
    @Select("select * from provider where pid=#{pid}")
    Provider getProviderById(Integer pid);

    @Options(useGeneratedKeys = true, keyProperty = "pid")
    @Insert("insert into provider(providerName) values(#{providerName})")
    int addProvider(Provider provider);

    @Delete("delete from provider where pid=#{pid}")
    int deleteProvider(Provider provider);

    @Update("update provider set providerName=#{providerName} where pid=#{pid}")
    int updateProvider(Provider provider);
}
