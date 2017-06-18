
/*三人约定，洗牌后，随机抽取一张"明牌"并夹在中间；然后依次抓牌，谁抓到这张便自动作为地主，并收取最后三张。
要求：请用程序实现这一过程，最后打印地主名，以及三个人的牌(要求排序)；
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class PokerV3{
	public static void main(String[] args){
		//构建List存储points
		List<String> points = new ArrayList<>();
		Collections.addAll(points,"❤","♠","❀","◇");
		//构建List存储patterns
		List<String> patterns = new ArrayList<>();
		Collections.addAll(patterns,"2","A","K","Q","J","10","9","8","7","6","5","4","3");
		//组合牌面,并按序号arrange 存入Map集合中
		Map<Integer,String> poker = new HashMap<>();
		int arrange = 1;
		poker.put(arrange++,"RJack");
		poker.put(arrange++,"BJack");
		for(String s : points){
			for(String sp : patterns){
				poker.put(arrange++,sp+s);
			}
		}

		//获取所有keySet,构建List--arrangeList
		Set<Integer> arrangeSet = poker.keySet();
		List<Integer> arrangeList = new ArrayList<>(arrangeSet);
		//乱序
		Collections.shuffle(arrangeList);

		//定义变量存储int ranNum为0-50中获取随机数
		Random r = new Random();
		int ranNum = r.nextInt(51);
		List<Integer> player1 = new ArrayList<>();
		List<Integer> player2 = new ArrayList<>();
		List<Integer> player3 = new ArrayList<>();
		List<Integer> player0 = new ArrayList<>();

		//操作角标,发序号,如果集合中包含ranNum:51-53给这个集合;0-50,三个人分
		for(int i = 0; i < arrangeList.size(); i++){
			if(i>=51){
				player0.add(arrangeList.get(i));
			}else if(i%3==0){
				player1.add(arrangeList.get(i));
			}else if(i%3==1){
				player2.add(arrangeList.get(i));
			}else{
				player3.add(arrangeList.get(i));
			}
		}

		//哪个玩家包含ranNum,则拿到底牌
		
		if(player1.contains(ranNum)){
			for(Integer i : player0){
				player1.add(i);
			}
		}
		if(player2.contains(ranNum)){
			for(Integer i : player0){
				player2.add(i);
			}
		}
		if(player3.contains(ranNum)){
			for(Integer i : player0){
				player3.add(i);
			}
		}
		//排序
		Collections.sort(player1);
		Collections.sort(player2);
		Collections.sort(player3);
		//对换牌面
		List<String> player10 = new ArrayList<>();
		List<String> player20 = new ArrayList<>();
		List<String> player30 = new ArrayList<>();
		for(int i = 0; i < player1.size(); i++){
			player10.add(poker.get(player1.get(i)));
		}
		for(int i = 0; i < player2.size(); i++){
			player20.add(poker.get(player2.get(i)));
		}
		for(int i = 0; i < player3.size(); i++){
			player30.add(poker.get(player3.get(i)));
		}
		//打印地主
		if(player1.size()>17){
			System.out.println("地主是player1");
		}
		if(player2.size()>17){
			System.out.println("地主是player2");
		}
		if(player3.size()>17){
			System.out.println("地主是player3");
		}

		//看牌
		System.out.println("player1:"+player1.size()+player10);
		System.out.println("player2:"+player2.size()+player20);
		System.out.println("player3:"+player3.size()+player30);
	}
}