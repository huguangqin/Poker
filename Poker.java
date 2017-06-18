/*模拟斗地主发牌案例
思路:
1.通过4种花色+13个点数+2个鬼,构建一副朴克牌;
2.每次发牌均需打乱牌序;
3.加上底牌,共计4个玩家;
4.底牌3张,每个玩家17张;

【扑克牌英语词汇】
deck:一副牌
poker:扑克牌；

the red joker:大王；
the black joker:小王；

point:点数
ace:尖儿；
king:k 
queen:q 
jack:j
face cards: 花牌（J、Q、K）；

pattern:花色
spade:黑桃；
heart:红心；
club:梅花；
diamond:方块；

shuffle:洗牌；
deal:分牌

banker:庄家
player:玩家
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Poker{
	public static void main(String[] args){
		//1.构建朴克牌
		List<String> poker = new ArrayList<>();
		//1.1集合存储点数point
		List<String> point = new ArrayList<>();
		point.add("J");
		point.add("Q");
		point.add("K");
		point.add("A");
		for(int i = 2; i <= 10;i++ ){
			point.add(i+"");
		}
		//1.2存储花色pattern
		List<String> pattern = new ArrayList<>();
		pattern.add("@");	//代表黑桃spade
		pattern.add("$");	//代表红心heart
		pattern.add("&");	//代表梅花club
		pattern.add("*");	//代表方片diamond
		//1.3构建牌card
		for(String p : point){
			for(String pa : pattern){
				String card = p + pa;
				poker.add(card);
			}
		}
		poker.add("redJack");
		poker.add("blackJack");


		//2.洗牌 shuffle
		Collections.shuffle(poker);

		//3.玩家取牌集合
		List<String> banker = new ArrayList<>();
		List<String> player1 = new ArrayList<>();
		List<String> player2 = new ArrayList<>();
		List<String> player3 = new ArrayList<>();

		//4.发牌 deal
		for(int i = 0; i < poker.size(); i++){
			if(i >= 51){
				banker.add(poker.get(i));
			}else if(i % 3 == 0){		//如果把 else去掉,总数为54,在3家发
				player1.add(poker.get(i));
			}else if(i % 3 == 1){
				player2.add(poker.get(i));
			}else{
				player3.add(poker.get(i));	//玩家1上边的else去掉,再把玩家3把else去掉,为54张;如果保留else,仅把{}去掉,为18张,不影响
			}
			
		}

		//5.看牌
		System.out.println("底牌:"+banker.size()+"张\t"+banker+"\t");
		System.out.println("玩家1:"+player1.size()+"张\t"+player1+"\t");
		System.out.println("玩家2:"+player2.size()+"张\t"+player2+"\t");
		System.out.println("玩家3:"+player3.size()+"张\t"+player3+"\t");



	}
}