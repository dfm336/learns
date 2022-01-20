package com.dfm.his.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] nums= {-1,2,1,-4};
		int target = 1;
		System.out.println(solution(nums,target));
	}

	public static int solution(int[]nums,int target){
		if(nums.length == 3)return nums[0]+nums[1]+nums[2];
		Arrays.sort(nums);
		int ans = nums[0]+nums[1]+nums[2];
		for(int i=0;i<nums.length;i++){
			int start = i+1;
			int end = nums.length-1;
			//双指针 减少循环次数.
			while (start < end){
				int sum = nums[i]+nums[start]+nums[end];
				if(target == sum)return sum;
				if(Math.abs(sum-target) < Math.abs(ans - target)){
					ans = sum;
				}
				if(sum  > target){
					end--;
				}else {// sum < target 不会出现==. 已经return
					start++;
				}
			}
		}
		return ans;
	}


	private static int sumClosest(int[] nums, int target) {
		if(nums.length==3)return nums[0]+nums[1]+nums[2];
		List<Integer> abs = new ArrayList<Integer>();
		int[][] ans = new int[1000][1000];
		int[] count = new int[1000];
		for(int i=0;i<nums.length;i++) {
			int absNum = Math.abs(target-nums[i]);
			ans[absNum][count[absNum]++] = nums[i];
			abs.add((Integer)absNum);
			System.out.print(nums[i]+"\t");
		}
		System.out.println();
		Collections.sort(abs);
		for (Integer t : abs) {
			System.out.print(t+"\t");
		}
		System.out.println();
		Integer sum =0;
		//abs.get(abs.size());
		int t=0;//计数 为3退出
		int k=0;
		for(int i=0;i<= abs.get(abs.size()-1);i++) {
			i=abs.get(k++);
			for(int j=0;j<count[i];j++) {
				sum+=ans[i][j];
				System.out.print(ans[i][j]+"\t");
				t++;
				if(t==3)return sum;
				
			}
			System.out.println();
		}
		
		return 0;
	}

}
