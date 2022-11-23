package com.tony.austin.support.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tony.austin.support.domain.SmsRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmsRecordMapper extends BaseMapper<SmsRecord> {
}
