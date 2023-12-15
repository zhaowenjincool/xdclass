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
public class VideoOrder {
    private Integer id;
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    private Integer state;
    @JsonProperty("total_fee")
    private Integer totalFee;
    @JsonProperty("video_id")
    private Integer videoId;
    @JsonProperty("video_title")
    private String videoTitle;
    @JsonProperty("video_img")
    private String videoImg;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    private LocalDateTime createTime;
}
