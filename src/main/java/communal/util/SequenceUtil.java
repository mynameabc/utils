package communal.util;

/**
 * 序列生成器
 * @author Administrator
 *
 */
public class SequenceUtil {

	private int index = 0;
	
	public SequenceUtil(){}
	
	public SequenceUtil(int par_index) {
		this.index = par_index;
	}
	
	public synchronized int getNext() {
		
		return ++index;
	}
	
	public static void main(String[] args) {
		
		SequenceUtil su = new SequenceUtil();
		
		for (int index = 0; index < 10; index++) {
			System.out.println(su.getNext());
		}
	}
}
