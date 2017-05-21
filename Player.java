package rsp5;

public class Player {
	//Field
	private int rsp = 0;

	//Constructor
	Player (){
	}

	//Setter, Getter
	public int getRsp() {
		return rsp;
	}

	public void setRsp() {
		this.rsp = new java.util.Random().nextInt(3);
	}

}
