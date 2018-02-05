package Ladder3.DataStructure_II;

/**
 * 
 * 122. Largest Rectangle in Histogram - Hard - Required

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.



Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

histogram

The largest rectangle is shown in the shaded area, which has area = 10 unit.


Example
Given height = [2,1,5,6,2,3],
return 10.

Tags: Stack Array

Related Problems 
Hard Maximal Rectangle 26 %
Hard Max Tree 33 %*/

public class LargestRectangleInHistogram {
	/**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
		if(height==null ||height.length==0){
			return 0;
		}
		Stack<Integer> st = new Stack<>();
		int max =0,len=height.length;
		for(int i=0; i<len;i++){
			int current = height[i];
			while(!st.isEmpty() && current<=height[st.peek()]){
				int index = st.pop();
				int  h = height[index];
				int w;
				if(st.isEmpty()){
					w = i+1-1;//the num of ele of current ele  - 1 current node
				}
				else{
					w = i-st.peek()-1;
				}
				max=Math.max(max, w*h);
			}
			st.push(i);
		}
		while(!st.isEmpty() ){
			int index = st.pop();
			int  h = height[index];
			int w;
			if(st.isEmpty()){
				w = len;
			}
			else{
				w = len-1-st.peek();
			}
			max=Math.max(max, w*h);
		}
		return max;
	}

}
