package com.example.savedata;

import com.google.gson.annotations.SerializedName;

public class LoginData{

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("login")
	private String login;

	@SerializedName("token")
	private String token;

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public String getLogin(){
		return login;
	}

	public String getToken(){
		return token;
	}
}