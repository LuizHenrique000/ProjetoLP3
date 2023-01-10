package com.moviebook.model;

import lombok.Data;

@Data
public class Authentication {

	private String expires_at;
	private String request_token;
}
