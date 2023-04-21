// 이유진 (2016133)
// 2021-10-08
// Lab06 - 실습 3. 도시 위,경도 정보 저장

public class Location {
	private String name; //도시 이름
	private double lat, lon; //위도, 경도
	
	public Location(String name, double lat, double lon) {
		this.name = name;
		this.lat = lat;
		this.lon = lon;
	}
	
	public String getName() {//각각 변수들의 getters, setters
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	
}
