package org.example.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Episode {
    private Integer id;
    private String title;
    private Integer num;
    private Integer ordered;
    @JsonProperty("play_url")
    private String playUrl;
    @JsonProperty("chapter_id")
    private Integer chapterId;
    private Integer free;
    @JsonProperty("video_id")
    private Integer videoId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    private LocalDateTime createTime;
}
