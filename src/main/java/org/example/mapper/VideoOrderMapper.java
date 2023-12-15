package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.model.entity.VideoOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoOrderMapper {
    int save(VideoOrder videoOrder);
}
