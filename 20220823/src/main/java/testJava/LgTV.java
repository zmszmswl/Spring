package testJava;

public class LgTV{
	
	private TV tv;
	
	//생성자에 의한 전달 방법 (자기자신으로 만듬)
	//public LgTV(TV tv) {
	//	this.tv = tv;
	//}
	

	
	public TV getTv() {
		return tv;
	}
	// setter에 의한 의존주입방법
	public void setTv(TV tv) {
		this.tv = tv;
	}
	
}
