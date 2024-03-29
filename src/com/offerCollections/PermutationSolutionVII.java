package com.offerCollections;

import java.util.ArrayList;
import java.util.TreeSet;

public class PermutationSolutionVII {

	public PermutationSolutionVII() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> Permutation(String str) {
		ArrayList<String> result = new ArrayList<String>();// 根据返回类型需要
		if (str == null || str.length() == 0) {
			return result;
		}
		char[] chars = str.toCharArray();
		TreeSet<String> res = new TreeSet<String>(); // 用于排序输出
		getResult(chars, 0, str.length() - 1, res);
		result.addAll(res);// 添加到ArrayList
		return result;
	}

	public void getResult(char[] chars, int start, int end, TreeSet<String> res) {

		if (start == end) {
			res.add(String.valueOf(chars));
		} else {
			for (int i = start; i <= end; i++) {
				swap(chars, start, i);// 换一位
				getResult(chars, start + 1, end, res);// 递归
				swap(chars, start, i);// 换回来，保证下次换位是正确的
			}
		}
	}

	public void swap(char[] chars, int a, int b) {
		if (a == b) {// 因为会出现原位置与原位置交换，直接空即可

		} else {
			char temp = chars[a];
			chars[a] = chars[b];
			chars[b] = temp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSolutionVII ps = new PermutationSolutionVII();
		String str = "abc";
		ArrayList<String> al = ps.Permutation(str);
		for (String string : al) {
			System.out.println(string);
		}
	}

}
