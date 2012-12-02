package za.co.house4hack.ushahidi;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class Report {
	//report variables
	private String incident_title;
	private String incident_description;
	private String incident_date;
	private String incident_hour;
	private String incident_minute;
	private String incident_ampm;
	private String incident_category;
	private String latitude;
	private String longitude;
	private String location_name;
	private String person_first;
	private String person_last;
	private String person_email;
	private String incident_photo;
	private String incident_video;
	private String incident_news;
	
	/**
	 * @return the incident_title
	 */
	public String getIncident_title() {
		return incident_title;
	}
	/**
	 * @param incident_title the incident_title to set
	 */
	public void setIncident_title(String incident_title) {
		this.incident_title = incident_title;
	}
	/**
	 * @return the incident_description
	 */
	public String getIncident_description() {
		return incident_description;
	}
	/**
	 * @param incident_description the incident_description to set
	 */
	public void setIncident_description(String incident_description) {
		this.incident_description = incident_description;
	}
	/**
	 * @return the incident_date
	 */
	public String getIncident_date() {
		return incident_date;
	}
	/**
	 * @param incident_date the incident_date to set
	 */
	public void setIncident_date(String incident_date) {
		this.incident_date = incident_date;
	}
	/**
	 * @return the incident_hour
	 */
	public String getIncident_hour() {
		return incident_hour;
	}
	/**
	 * @param incident_hour the incident_hour to set
	 */
	public void setIncident_hour(String incident_hour) {
		this.incident_hour = incident_hour;
	}
	/**
	 * @return the incident_minute
	 */
	public String getIncident_minute() {
		return incident_minute;
	}
	/**
	 * @param incident_minute the incident_minute to set
	 */
	public void setIncident_minute(String incident_minute) {
		this.incident_minute = incident_minute;
	}
	/**
	 * @return the incident_ampm
	 */
	public String getIncident_ampm() {
		return incident_ampm;
	}
	/**
	 * @param incident_ampm the incident_ampm to set
	 */
	public void setIncident_ampm(String incident_ampm) {
		this.incident_ampm = incident_ampm;
	}
	/**
	 * @return the incident_category
	 */
	public String getIncident_category() {
		return incident_category;
	}
	/**
	 * @param incident_category the incident_category to set
	 */
	public void setIncident_category(String incident_category) {
		this.incident_category = incident_category;
	}
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @param latitute the latitude to set
	 */
	public void setLatitude(String latitute) {
		this.latitude = latitute;
	}
	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the location_name
	 */
	public String getLocation_name() {
		return location_name;
	}
	/**
	 * @param location_name the location_name to set
	 */
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
	/**
	 * @return the person_first
	 */
	public String getPerson_first() {
		return person_first;
	}
	/**
	 * @param person_first the person_first to set
	 */
	public void setPerson_first(String person_first) {
		this.person_first = person_first;
	}
	/**
	 * @return the person_last
	 */
	public String getPerson_last() {
		return person_last;
	}
	/**
	 * @param person_last the person_last to set
	 */
	public void setPerson_last(String person_last) {
		this.person_last = person_last;
	}
	/**
	 * @return the person_email
	 */
	public String getPerson_email() {
		return person_email;
	}
	/**
	 * @param person_email the person_email to set
	 */
	public void setPerson_email(String person_email) {
		this.person_email = person_email;
	}
	/**
	 * @return the incident_photo
	 */
	public String getIncident_photo() {
		return incident_photo;
	}
	/**
	 * @param incident_photo the incident_photo to set
	 */
	public void setIncident_photo(String incident_photo) {
		this.incident_photo = incident_photo;
	}
	/**
	 * @return the incident_video
	 */
	public String getIncident_video() {
		return incident_video;
	}
	/**
	 * @param incident_video the incident_video to set
	 */
	public void setIncident_video(String incident_video) {
		this.incident_video = incident_video;
	}
	/**
	 * @return the incident_news
	 */
	public String getIncident_news() {
		return incident_news;
	}
	/**
	 * @param incident_news the incident_news to set
	 */
	public void setIncident_news(String incident_news) {
		this.incident_news = incident_news;
	}
	
	public String toJsonString() {
	      JSONObject obj = new JSONObject();
	      try {
	    	  obj.put("task", "report");
	    	  //obj.put("resp", "json");
	         obj.put("incident_title", getIncident_title());
	         obj.put("incident_description", getIncident_description());
	         obj.put("incident_date", getIncident_date());
	         obj.put("incident_hour", getIncident_hour());
	         obj.put("incident_minute", getIncident_minute());
	         obj.put("incident_ampm", getIncident_ampm());
	         obj.put("incident_category", getIncident_category());
	         obj.put("latitude", getLatitude());
	         obj.put("longitude", getLongitude());
	         obj.put("location_name", getLocation_name());
	         obj.put("person_first", getPerson_first());
	         obj.put("person_last", getPerson_last());
	         obj.put("person_email", getPerson_email());
	         obj.put("incident_photo", getIncident_photo());
	         obj.put("incident_video", getIncident_video());
	         obj.put("incident_news", getIncident_news());
	      } catch (JSONException e) {
	         throw new IllegalStateException(e);
	      }
	      return obj.toString();
	   }
	
	public List<NameValuePair> toFormData()
	{
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	      try {
	    	  nameValuePairs.add(new BasicNameValuePair("task", "report"));
	    	  nameValuePairs.add(new BasicNameValuePair("incident_title", getIncident_title()));
	    	  nameValuePairs.add(new BasicNameValuePair("incident_description", getIncident_description()));
	    	  nameValuePairs.add(new BasicNameValuePair("incident_date", getIncident_date()));
	    	  nameValuePairs.add(new BasicNameValuePair("incident_hour", getIncident_hour()));
	    	  nameValuePairs.add(new BasicNameValuePair("incident_minute", getIncident_minute()));
	    	  nameValuePairs.add(new BasicNameValuePair("incident_ampm", getIncident_ampm()));
	    	  nameValuePairs.add(new BasicNameValuePair("incident_category", getIncident_category()));
	    	  nameValuePairs.add(new BasicNameValuePair("latitude", getLatitude()));
	    	  nameValuePairs.add(new BasicNameValuePair("longitude", getLongitude()));
	    	  nameValuePairs.add(new BasicNameValuePair("location_name", getLocation_name()));
	    	  nameValuePairs.add(new BasicNameValuePair("person_first", getPerson_first()));
	    	  nameValuePairs.add(new BasicNameValuePair("person_last", getPerson_last()));
	    	  nameValuePairs.add(new BasicNameValuePair("person_email", getPerson_email()));
	    	  nameValuePairs.add(new BasicNameValuePair("incident_photo", getIncident_photo()));
	    	  nameValuePairs.add(new BasicNameValuePair("incident_video", getIncident_video()));
	    	  nameValuePairs.add(new BasicNameValuePair("incident_news", getIncident_news()));
	    	  
	      } catch (Exception e) {
	         throw new IllegalStateException(e);
	      }
	      return nameValuePairs;
	}
	
}
