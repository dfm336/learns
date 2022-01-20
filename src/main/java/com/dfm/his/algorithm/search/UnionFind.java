package com.dfm.his.algorithm.search;

/**
 * 
 * 某省调查城镇交通状况，得到现有城镇道路统计表，表中列出了每条道路直接连通的城镇。省政府“畅通工程”的目标是使全省任何两个城镇间都可以实现交通（但不一定有直接的道路相连，只要互相间接通过道路可达即可）。问最少还需要建设多少条道路？ 
 

Input
测试输入包含若干测试用例。每个测试用例的第1行给出两个正整数，分别是城镇数目N ( < 1000 )和道路数目M；随后的M行对应M条道路，每行给出一对正整数，分别是该条道路直接连通的两个城镇的编号。为简单起见，城镇从1到N编号。 
注意:两个城市之间可以有多条道路相通,也就是说
3 3
1 2
1 2
2 1
这种输入也是合法的
当N为0时，输入结束，该用例不被处理。

Output
对每个测试用例，在1行里输出最少还需要建设的道路数目。 
 * @author Administrator
 *
 */
public class UnionFind {
	private int[] data;//数据存储
	private int[] heavy;//记录每个 跟的 子节点数 重量
	private int group;//记录 一共有多少根节点 
	private int size;//记录 并查集 元素个数
	public UnionFind(int size) {
		this.size=size;
		this.group = size;
		data = new int[size];
		heavy = new int[size];
		for(int i=0;i<size;i++) {
			data[i]= i;
			heavy[i] = 1;
		}
	}
	//找到该element的根节点
	public int find(int element) {
		while(element != data[element]) {
			data[element] = data[data[element]];
			element = data[element];
		}
		return element;
	}
	public boolean isTheSameRoot(int first,int second) {
		return find(first)==find(second);
	}
	public void union(int first,int second) {
		int firstRoot = find(first);
		int secondRoot = find(second);
		if(firstRoot == secondRoot)return;
		if(heavy[firstRoot] >= heavy[secondRoot]) {
			data[secondRoot] = firstRoot;
			heavy[firstRoot] += heavy[secondRoot];
		}else {
			data[firstRoot] = secondRoot;
			heavy[secondRoot] += heavy[firstRoot];
		}
		this.group--;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] m = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
		int circleNum = solution.findCircleNum(m);
		System.out.println(circleNum);

		int n = m.length;
		UnionFind unionFind = new UnionFind(m.length);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(m[i][j] == 1)unionFind.union(i,j);
			}
		}
		System.out.println(unionFind.group);
	}

}
class Solution {

	public  int[] data;
	public int findCircleNum(int[][] m) {
		int n = m.length;
		data = new int[n];
		for(int i=0;i<n;i++)data[i]=i;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(m[i][j] == 1)union(i,j);
			}
		}
		int count = 0;
		for(int i=0;i<n;i++){
			count = (data[i]  == i) ? count+1 : count;
		}
		return count;
	}
//     public bool isTheSame(int first,int second,int[] data){
//         return find(first)==find(second);
//     }

	public int find(int element){
		while(data[element] != element){
			element = data[element];
		}
		return element;
	}

	public void union(int first,int second){
		int r1 = find(first);
		int r2 = find(second);

		if( r1 == r2)return ;
		if(r1 < r2){
			data[r2] = r1;
		}else data[r1] = r2;
	}
}