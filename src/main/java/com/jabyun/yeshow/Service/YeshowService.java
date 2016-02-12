package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.jabyun.yeshow.Util.DuplicateException;

public abstract class YeshowService {
	
	public abstract ArrayList<Object> execute(JSONObject dataObject) throws SQLException ,DuplicateException;
}
