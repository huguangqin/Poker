
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
public class PokerV2{
	public static void main(String[] args){
		//构建点数集合
		List<String> points = new ArrayList<>();
		Collections.addAll(points,"2","A","K","Q","J","10","9","8","7","6","5","4","3");
		//构建花色集合
		List<String> patterns = new ArrayList<>();
		Collections.addAll(patterns,"#","$","%","*");
		//构建牌面,并以1-54为key,存入map集合
		Map<Integer,String> poker = new HashMap<>();
		//定义牌序
		int arrangement = 1;
		poker.put(arrangement++,"RJack");
		poker.put(arrangement++,"BJack");
		for(String s : points){
			for(String sp : patterns){
				poker.put(arrangement++,sp+s);
			}
		}
		//取出所有key,构建key的集合
		Set<Integer> keySet = poker.keySet();
		//通过List构造方法,将Set集合,变为List集合,因为Collections只能对List操作
		List<Integer> arrangeList = new ArrayList<>(keySet);
		//打乱序号
		Collections.shuffle(arrangeList);
		//将序号发至各玩家
		List<Integer> banker = new ArrayList<>();
		List<Integer> player1 = new ArrayList<>();
		List<Integer> player2 = new ArrayList<>();
		List<Integer> player3 = new ArrayList<>();
		for(int i = 0; i < arrangeList.size(); i++){
			if(i >= 51){
				banker.add(arrangeList.get(i));
			}else{
				if(i%3 == 0){
					player1.add(arrangeList.get(i));
				}else if(i%3 == 1){
					player2.add(arrangeList.get(i));
				}else{
					player3.add(arrangeList.get(i));
				}
			}
		}//for
		//将各玩家手中的序号进行排序
		Collections.sort(banker);
		Collections.sort(player1);
		Collections.sort(player2);
		Collections.sort(player3);
		//将序号对换成牌面
		List<String> banker0 = new ArrayList<>();
		List<String> player10 = new ArrayList<>();
		List<String> player20 = new ArrayList<>();
		List<String> player30 = new ArrayList<>();
		
		for(int i = 0; i < 17; i++){
			player10.add(poker.get(player1.get(i)));
			player20.add(poker.get(player2.get(i)));
			player30.add(poker.get(player3.get(i)));
		}
		for(int i = 0; i< 3; i++){
			banker0.add(poker.get(banker.get(i)));
		}

		//看牌
		System.out.println("底牌:"+banker0.size()+banker0);
		System.out.println("玩家1:"+player1.size()+player10);
		System.out.println("玩家2:"+player2.size()+player20);
		System.out.println("玩家3:"+player3.size()+player30);
	}
}