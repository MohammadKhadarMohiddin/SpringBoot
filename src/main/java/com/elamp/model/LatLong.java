package com.elamp.model;

import java.util.HashMap;
import java.util.Map;

public class LatLong {

private Double latitude;
private Double longitude;
private String accuracy;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Double getLatitude() {
return latitude;
}

public void setLatitude(Double latitude) {
this.latitude = latitude;
}

public Double getLongitude() {
return longitude;
}

public void setLongitude(Double longitude) {
this.longitude = longitude;
}

public String getAccuracy() {
return accuracy;
}

public void setAccuracy(String accuracy) {
this.accuracy = accuracy;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}