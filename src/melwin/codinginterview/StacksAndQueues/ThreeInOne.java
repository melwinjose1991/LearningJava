package melwin.codinginterview.StacksAndQueues;

/*
 * Chapter  3   : Stacks and Queues
 * Question 3.1 : Three In One
 */
public class ThreeInOne {

	private static class ThreeStack {
		private int array[];
		private int stack_size;
		private int stack_top[];

		public ThreeStack(int size) {
			stack_size = size;
			array = new int[stack_size * 3];
			stack_top = new int[] { -1, stack_size-1, (stack_size * 2)-1, (stack_size * 3)-1 };
		}

		public boolean pushToStack(int stack_no, int element) {
			int next_index = stack_top[stack_no - 1] + 1;

			if (next_index >= (stack_size * stack_no)) {
				System.out.println("@pushToStack :: stack_no"+1+" :: overflow");
				return false;
			} else {
				stack_top[stack_no - 1]++;
				System.out.println("@pushToStack :: stack_no"+1+" :: new_top="+stack_top[stack_no-1]+" :: element="+element);
				array[stack_top[stack_no - 1]] = element;
				return true;
			}
		}

		public int popFromStack(int stack_no) {
			if (stack_top[stack_no - 1] < (stack_size * (stack_no - 1))) {
				System.out.println("@pushToStack :: stack_no"+1+" :: underflow");
				return -1;
			}else{
				int element = array[stack_top[stack_no-1]];
				stack_top[stack_no-1]--;
				System.out.println("@pushToStack :: stack_no"+1+" :: pop-ing="+element+" :: new_top="+stack_top[stack_no-1]);
				return element;
			}
		}
	}

	public static void main(String[] args) {
		ThreeStack three_stack = new ThreeStack(2);
		
		three_stack.pushToStack(2, 10);
		three_stack.pushToStack(2, 20);
		three_stack.pushToStack(2, 30);
		three_stack.popFromStack(2);
		three_stack.popFromStack(2);
		three_stack.popFromStack(2);
		three_stack.pushToStack(2, 30);
		three_stack.popFromStack(2);
	}

}
