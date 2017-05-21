package rsp5;
import java.util.ArrayList;

public class Referee {
	//Field
	private int num; //シミュレーション回数
	private int total; //総人数

	private ArrayList <Integer> group = new ArrayList<Integer>(); ////じゃんけんのグループ用の配列
	private int win = 0; //勝者人数
	private int lose = 0; //敗者人数

	private int count[] = {0,0}; //じゃんけん１回が終了するまでの回数
	private int total_count = 0; //じゃんけんの総回数

	private int r; private int s; private int p; //rock scissors paper

	//Constructor シミュレーション回数と人数を指定
	public Referee (int num, int total){
		this.num = num;
		this.total = total;
		this.win = total;
		group.add(win);
		group.add(lose);
	}

	//Setter, Getter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public ArrayList<Integer> getGroup() {
		return group;
	}

	public void setGroup() {
		this.group.add(this.total);
		this.group.add(0);
	}

	public int getWin() {
		return this.win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return this.lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}


	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int[] count) {
		this.total_count += Math.max(count[0], count[1]);
	}

	public int[] getCount() {
		return count;
	}

	public void setCount(int i) {
		this.count[i] += 1;
	}

	//Method
	//初期化
		//RSPの初期化
		public void clearRsp(){
			this.r = 0; this.s = 0; this.p = 0;
		}
		//カウントの初期化
		public void clearCount(){
		this.count[0] = 0;
		this.count[1] = 0;
	}

	//じゃんけん
		//RSPの人数を数える
		public void countRsp(int rsp){
			switch (rsp){
			case 0:
				this.r++; break;
			case 1:
				this.s++; break;
			case 2:
				this.p++; break;
			}
		}

		//勝敗人数かあいこを返す
		public boolean judge(int j){
			if ((this.r == 0 ^ this.s == 0 ^ this.p == 0) ||
					(this.r == 0 && this.s == 0 && this.p == 0)){
				if (this.r == 0) {
					// r==0なら、win=s, lose=p
					this.win = this.s; this.lose = this.p;
				} else if (this.s == 0) {
					// s==0なら、win=p, lose=r
					this.win = this.p; this.lose = this.r;
				} else {
					// p==0なら、win=r, lose=s
					this.win = this.r; this.lose = this.s;
				}
				return false;
			}
			return true;
		}

		public void add(){
			this.group.add(this.win);
			this.group.add(this.lose);
		}

		public void remove(){
			this.group.remove(1);
			this.group.remove(0);
		}

	//シミュレーション
		//平均値を出力
		public double calcAvg(int total_number, int number){
			return (double)total_number / (double)number;
		}

}
