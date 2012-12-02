package za.co.house4hack.ushahidi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.provider.SyncStateContract.Constants;
import android.util.Log;

public class UshahidiConnection {
	private HttpClient client;
	   private HttpRequestBase method;
	   private URLConnection connection;

	   private UshahidiConnection(HttpRequestBase method) {
	      client = new DefaultHttpClient();
	      this.method = method;
	   }

	   public static UshahidiConnection instanceOfGETMethod(String uri) {
	      return new UshahidiConnection(new HttpGet(uri));
	   }

	   public static UshahidiConnection instanceOfPUTMethod(String uri) {
	      return new UshahidiConnection(new HttpPut(uri));
	   }

	   public static UshahidiConnection instanceOfJsonPUTMethod(String uri, String json) throws JSONException, UnsupportedEncodingException {
	      HttpRequestBase base = new HttpPut(uri);
	      base.addHeader("Content-Type", "application/json");
	      JSONObject jobj;
	      jobj = new JSONObject(json);
	      StringEntity e = new StringEntity(jobj.toString(), "utf-8");
	      base.addHeader(e.getContentEncoding());
	      ((HttpEntityEnclosingRequestBase) base).setEntity(e);
	      return new UshahidiConnection(base);
	   }

	   public static UshahidiConnection instanceOfJsonPOSTMethod(String uri, String json, List<NameValuePair> formData) throws Exception {
	      //HttpRequestBase base = new HttpPost(ServiceConstants.base_url + uri);//+ "?task=report");
		   HttpPost base = new HttpPost(ServiceConstants.base_url + uri);//+ "?task=report");
	      Log.i("URL", base.getURI().toString());
	      
	      
	      //base.addHeader("Content-Type", "application/json");
	      UrlEncodedFormEntity use = new UrlEncodedFormEntity(formData);
	      ((HttpEntityEnclosingRequestBase) base).setEntity(use);
	      
	  
	      
	      //Log.i("Parameters", base.getParams().getParameter("task").toString());
	      
	      //StringEntity e = new StringEntity(json, "utf-8");
	      //base.addHeader(se.getContentEncoding());
	      //base.addHeader(e.getContentEncoding());
	      //base.addHeader("Content-Length", String.valueOf(e.getContentLength()));
	      //((HttpEntityEnclosingRequestBase) base).setEntity(e);
	      return new UshahidiConnection(base);
	   }   
	   
	   //added method
	   /*public static String instanceOfJsonPOSTMethod(String uri, String json, List<NameValuePair> formData) throws Exception {
		   URL url = new URL(ServiceConstants.base_url + uri);
		   URLConnection connection = url.openConnection();
		   connection.setDoOutput(true);
		   connection.setDoInput(true);
		   connection.setRequestProperty("METHOD","POST");
		   HttpURLConnection httpConnection = (HttpURLConnection)connection;
		   
		   httpConnection.
		   
		   HttpRequestBase base = new HttpPost(ServiceConstants.base_url + uri + "?task=report");
		      Log.i("URL", base.getURI().toString());
		      
		      
		      base.addHeader("Content-Type", "application/json");
		      //StringEntity se = new StringEntity(new UrlEncodedFormEntity(formData).toString());
		      //((HttpEntityEnclosingRequestBase) base).setEntity(se);
		      
		      StringEntity e = new StringEntity(json, "utf-8");
		      //base.addHeader(se.getContentEncoding());
		      base.addHeader(e.getContentEncoding());
		      //base.addHeader("Content-Length", String.valueOf(e.getContentLength()));
		      ((HttpEntityEnclosingRequestBase) base).setEntity(e);
		      return new UshahidiConnection(base);
		   }*/
	   
	   public String getResponse() throws Exception {
	      String response = "";
	      HttpResponse res = client.execute(method);
	      HttpEntity entity = res.getEntity();
	      response = convertStreamToString(entity.getContent());
	      return res.getStatusLine() + " " + response;

	   }

	   private static String convertStreamToString(InputStream is) {
	      BufferedReader reader = new BufferedReader(new InputStreamReader(is), 8192);
	      StringBuilder sb = new StringBuilder();

	      String line = null;
	      try {
	         while ((line = reader.readLine()) != null) {
	            sb.append(line + "\n");
	         }
	      } catch (IOException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            is.close();
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	      }
	      return sb.toString();
	   }
}
