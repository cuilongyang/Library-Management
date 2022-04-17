package com.csb.ssmp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csb.ssmp.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author cuilongyang
 * @version 1.0
 * @date 2022/04/16
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {


}
