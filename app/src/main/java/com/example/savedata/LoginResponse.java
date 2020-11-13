package com.example.savedata;

import com.google.gson.annotations.SerializedName;

public class LoginResponse{

	@SerializedName("data")
	private LoginData data;

	@SerializedName("success")
	private boolean success;

	public LoginData getData(){
		return data;
	}

	public boolean isSuccess(){
		return success;
	}
}