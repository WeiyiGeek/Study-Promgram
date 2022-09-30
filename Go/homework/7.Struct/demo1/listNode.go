package main

import "fmt"

// 链表结构体
type ListNode struct {
	val  int
	Next *ListNode
}

// 反转链表函数
func reverseList(head *ListNode) *ListNode {
	var pre *ListNode
	cur := head
	for cur != nil {
		tmp := cur.Next // 把下一个节点存放到临时变量中
		cur.Next = pre  // 首节点赋予下一指向节点（首次Nil）
		pre = cur       // 将当前节点（首次val为1的地址）赋予pre
		cur = tmp       // 将上面临时变量地址（首次val为2的地址）赋予cur
	}
	return pre // 返回反转链表
}

func main() {
	// 1.实例化链表
	head := &ListNode{
		val: 1,
		Next: &ListNode{
			val: 2,
			Next: &ListNode{
				val: 3,
				Next: &ListNode{
					val: 4,
					Next: &ListNode{
						val:  5,
						Next: nil,
					},
				},
			},
		},
	}

	// 链表实例化对象副本拷贝
	header := head
	fmt.Println("反转前首地址:", header)
	for header != nil {
		fmt.Printf("%v->", header.val)
		header = header.Next
		if header == nil {
			fmt.Printf("Nil\n")
		}
	}

	// 2.调用反转链表
	res := reverseList(head)
	fmt.Println("反转后首地址:", res)
	for res != nil {
		fmt.Printf("%v->", res.val)
		res = res.Next
		if res == nil {
			fmt.Printf("Nil\n")
		}
	}
}
