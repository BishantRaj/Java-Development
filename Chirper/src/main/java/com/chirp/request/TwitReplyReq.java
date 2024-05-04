package com.chirp.request;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TwitReplyReq {
	
	private String content;
	private Long twitId;
	private LocalDateTime createdAt;
	private String image;
	

}
