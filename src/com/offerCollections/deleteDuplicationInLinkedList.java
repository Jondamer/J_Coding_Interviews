package com.offerCollections;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3
 * 
 * ->4->4->5 处理后为 1->2->5。
 * 
 * @author zhengzhentao
 *
 */

public class deleteDuplicationInLinkedList {

	public deleteDuplicationInLinkedList() {
		// TODO Auto-generated constructor stub
	}

	public static ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
			return pHead;
		}
		if (pHead.val == pHead.next.val) { // 当前结点是重复结点
			ListNode pNode = pHead.next;
			while (pNode != null && pNode.val == pHead.val) {
				// 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
				pNode = pNode.next;
			}
			return deleteDuplication(pNode); // 从第一个与当前结点不同的结点开始递归
		} else { // 当前结点不是重复结点
			pHead.next = deleteDuplication(pHead.next); // 保留当前结点，从下一个结点开始递归
			return pHead;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode A = new ListNode(2);
		ListNode B = new ListNode(4);
		ListNode C = new ListNode(4);
		ListNode D = new ListNode(5);
		ListNode E = new ListNode(7);
		ListNode F = new ListNode(7);
		head.next = A;
		A.next = B;
		B.next = C;
		C.next = D;
		D.next = E;
		E.next = F;
		ListNode tempNode = deleteDuplication(head);
		// 遍历
		while (tempNode != null) {
			System.out.print(tempNode.val + "--->");
			tempNode = tempNode.next;
		}

	}

}
