package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.model.entity.Video;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VideoMapper {
    List<Video> list();

    Video findDetailById(@Param("video_id") int videoId);
}
