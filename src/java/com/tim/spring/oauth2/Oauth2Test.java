package com.tim.spring.oauth2;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;


public class Oauth2Test
{

	public static void main(String[] args) throws Exception
	{
		//String token = getPasswordToken();
		//String token = getClientToken();
		String token = getCodeToken();
		System.out.println("token:" + token);
		//		String url = "http://localhost:8081/springMVC_model_0100/product/123?access_token=" + token;
		//		//String url = "http://localhost:8081/springMVC_model_0100/order/123?access_token=" + token;
		//		HttpClient client = new HttpClient(url, 11111, 11111);
		//		String result = client.sendGet3("utf-8");
		//		System.out.println(result);
		//
		//		System.out.println(URLEncoder.encode("http://localhost:8082/test0200/oauthCallbackServlet"));
	}

	private static String getCodeToken() throws Exception
	{
		String url = "http://localhost:8081/springMVC_model_0100/oauth/token";
		Map<String, String> map = new HashMap<String, String>();
		map.put("grant_type", "authorization_code");
		map.put("code", "lR0Q26");
		map.put("client_id", "mobile_1");
		map.put("redirect_uri", "http%3A%2F%2Flocalhost%3A8082%2Ftest0200%2FoauthCallbackServlet");
		HttpClient client = new HttpClient(url, 11111, 11111);
		client.sendMap(map, "utf-8");
		String resultString = client.getResult();
		JSONObject json = JSONObject.fromObject(resultString);
		System.out.println("authorization_code result:" + json.toString());
		return json.getString("access_token");
	}

	private static String getClientToken() throws Exception
	{
		String url = "http://localhost:8081/springMVC_model_0100/oauth/token";
		//String url = "http://localhost:8081/springMVC_model_0100/oauth/token?grant_type=password&scope=read&client_id=mobile_1&client_secret=secret_1&username=u1&password=1";
		Map<String, String> map = new HashMap<String, String>();
		map.put("grant_type", "client_credentials");
		map.put("scope", "read");
		map.put("client_id", "mobile_1");
		map.put("client_secret", "secret_1");
		//map.put("username", "tim-4");
		//map.put("password", "1");
		HttpClient client = new HttpClient(url, 11111, 11111);
		client.sendMap(map, "utf-8");
		//int result = client.send("", "utf-8");//post
		String resultString = client.getResult();
		JSONObject json = JSONObject.fromObject(resultString);
		//{"access_token":"10bbb3d4-b58b-4b67-b6e7-48d9a2c2d1b2","token_type":"bearer","refresh_token":"7f6fd390-528f-4cb4-a3b7-47bc32419091","expires_in":3599,"scope":"read"}]
		System.out.println("client_credentials result:" + json.toString());
		return json.getString("access_token");
	}

	private static String getPasswordToken() throws Exception
	{//[{"key":"grant_type","value":"password","description":""}]
		String url = "http://localhost:8081/springMVC_model_0100/oauth/token";
		//String url = "http://localhost:8081/springMVC_model_0100/oauth/token?grant_type=password&scope=read&client_id=mobile_1&client_secret=secret_1&username=u1&password=1";
		Map<String, String> map = new HashMap<String, String>();
		map.put("grant_type", "password");
		map.put("scope", "read");
		map.put("client_id", "mobile_1");
		map.put("client_secret", "secret_1");
		map.put("username", "tim-4");
		map.put("password", "1");
		HttpClient client = new HttpClient(url, 11111, 11111);
		client.sendMap(map, "utf-8");
		//int result = client.send("", "utf-8");//post
		String resultString = client.getResult();
		JSONObject json = JSONObject.fromObject(resultString);
		//{"access_token":"10bbb3d4-b58b-4b67-b6e7-48d9a2c2d1b2","token_type":"bearer","refresh_token":"7f6fd390-528f-4cb4-a3b7-47bc32419091","expires_in":3599,"scope":"read"}]

		return json.getString("access_token");
	}

}
