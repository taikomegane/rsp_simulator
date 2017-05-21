package rsp5;

public class Main {

	public static void main(String[] args) {
		//Refereeインスンタンスを生成
		Referee r = new Referee(1000,5);
		//Playerインスタンスを５つ生成
		Player[] pl = new Player[5];
		for(int i = 0; i < pl.length; i++){
			pl[i] = new Player();
		}

		//num回シミュレーションを回す
		for (int i = 0; i < r.getNum(); i++){
			//人数を戻す
			r.setGroup();

			//全員に順位がつくまで
			do {
				//回数の初期化
				r.clearCount();

				//前回の勝ちと負けでそれぞれじゃんけんをする=２周回す
				for (int j = 0; j < 2; j++){
					if (r.getGroup().get(j) < 2){
						continue; //人数が２人未満→スキップ
					} else { //人数が２人以上→勝敗つくまでじゃんけん
						do {
							//じゃんけんの準備
							r.clearRsp(); //rspの初期化
							r.setCount(j); //カウントを１増やす

							//じゃんけん
							for (int k = 0; k < r.getGroup().get(j); k++){
								pl[k].setRsp(); //じゃんけんの手を決める
								r.countRsp(pl[k].getRsp()); //人数を数える

							}
						} while (r.judge(j)); //継続判定

						r.add(); //勝敗人数を配列に追加
					}
				}
				r.setTotal_count(r.getCount()); //総回数を更新
				r.remove(); //終了した組を配列から削除

			} while (r.getGroup().size() != 0); //全員に順位がつく
			//System.out.println(r.getTotal_count() + "回で終わり！");
		}
		System.out.println("平均"+r.calcAvg(r.getTotal_count(), r.getNum())+"回です");

	}
}
