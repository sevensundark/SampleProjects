package getMax1hOf10b;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Fast100 {
	
	public static void main(String[] args) {
		find();
	}
	public static void find( ) {//
		int number = 100000000;
		int maxnum = 1000000000;// 锞嬭矈鎽狅１锞楅嫍顙夛降
		int i = 0;
		int topnum = 100;// 锞堬健锞楅嫍願緞锝剁寲锞欙礁銉�
	 
		Date startTime = new Date();
		
		Random random = new Random();
		int[] top = new int[topnum];
		for (i = 0; i < topnum; i++) {
			top[i] = Math.abs(random.nextInt(maxnum));//锞夐澒锞冿編锝緥璨婃憼铮�
//			top[i] = getNum(i);
		}

		buildHeap(top, 0, top.length);// 锝癸焦锝斤建锞楅毌锝★蕉锞戯剑锝�top[0]锞庯姜锞楅毌锝★緮锝緥锞�
		for (i = topnum; i < number; i++) {

			int currentNumber2 = Math.abs(random.nextInt(maxnum));//锞夐澒锞冿編锝緥璨婃憼铮�
//			int currentNumber2 = getNum(i);
			// 锝搭媶锞�top[0]锞旑嚧锝伙交锝籧urrentNumber2  锞栵緲锝癸焦锞楅毌锝★蕉锞�
			if (top[0] < currentNumber2) {
				top[0] = currentNumber2;
				shift(top, 0, top.length, 0); // 锝癸焦锝斤建锞楅毌锝★蕉锞�top[0]锞庯姜锞楅毌锝★緮锝緥锞�
			}
		}
		System.out.println(Arrays.toString(top));
		sort(top);
		System.out.println(Arrays.toString(top));
		
		Date endTime = new Date();
		System.out.println("锞擄緝锞侊緥"+(endTime.getTime() - startTime.getTime())+"锝猴緛锞冦兓");
 
	}
	
	public static int getNum(int i){
		return i;
	}

 
	//锝癸焦锞斻兓锞咃緪顖侊１锞椼兓
	public static void buildHeap(int[] array, int from, int len) {
		int pos = (len - 1) / 2;
		for (int i = pos; i >= 0; i--) {
			shift(array, from, len, i);
		}
	}
 
	/**
	 * @param array top锞婏１锞椼兓
	 * @param from 锝匡姜锞婏郊
	 * @param len 锞婏１锞楅瓚锝わ蕉锞�
	 * @param pos 锝碉奖锞囷桨锝斤練锝电筏ndex
	 * */
	public static void shift(int[] array, int from, int len, int pos) {
		// 锝憋剑锝磋矀锞冿浇锞氾降缇烇緞锞栵降 
		int tmp = array[from + pos];

		int index = pos * 2 + 1;// 锝碉緝锝碉浇锝碉奖锞囷桨pos锝斤練锝电緸锞勶緱願帮練锝点兓
		while (index < len)//  锝磋磭锞氾緱願帮練锝点兓
		{
			if (index + 1 < len
					&& array[from + index] > array[from + index + 1])// 锞堥儮铷ヨ磭锞氾緭锞掞浇锞氾降銉�
			{
				// 锞堥儮铷э緬锝憋緹锝斤練锝电緢锞堬緱願わ緹锝斤練锝佃�锝★剑锝骄锞嶏胶锞嶏緭锞掞奖锞燂降锞勶奖锞堬浇锞�
				index += 1;
			}
			 
			if (tmp > array[from + index]) {
				array[from + pos] = array[from + index];
				pos = index;
				index = pos * 2 + 1;
			} else {
				break;
			}
		}
		// 锞楅潙锞曪緢锝讲锝匡緰锞冿交锝伙緧銉伙緩锝恒兓锝ｏ浆锝帮緫锞侊緳锞婏奖锝辫徑锝匡礁锝筹礁顧堕嫇願緞锝斤練锝点兓
		array[from + pos] = tmp;
	}
	
	public static void sort(int[] array){  
        for(int i = 0; i < array.length - 1; i++){  
            //锝碉奖锞囷桨锞栵降锝碉奖锞楊柡闅健锞栵降  
            int min = array[i];  
            for(int j = i+1; j < array.length; j++){  
                if(min>array[j]){  
                    //锞堥儮閲氼姸璐婏緪锝憋緢min锞栵降锝伙焦锞愶健锝碉緞锝撅緧锝斤交锝伙交  
                    min = array[j];  
                    array[j] = array[i];  
                    array[i] = min;  
                }  
            }  
        }  
    }


}
