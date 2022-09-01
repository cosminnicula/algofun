import ListNode from "./util/ListNode";

(() => {
  function mergeTwoLists(list1: ListNode | null, list2: ListNode | null): ListNode | null {
    // list3 is a dummy node to allow easier logic for an empty list
    let list3 = new ListNode();
    let current3 = list3;

    while (list1 && list2) {
      if (list1.val > list2.val) {
        current3.next = list2;
        list2 = list2.next;
      } else {
        current3.next = list1;
        list1 = list1.next;
      }

      current3 = current3.next;
    }

    if (list1) {
      current3.next = list1;
    } else if (list2) {
      current3.next = list2;
    }
    
    return list3.next;
  };

  const l1 = new ListNode(1);
  l1.next = new ListNode(2);
  l1.next.next = new ListNode(4);

  const l2 = new ListNode(1);
  l2.next = new ListNode(3);
  l2.next.next = new ListNode(4);

  const merged = mergeTwoLists(l1, l2);
  let head = merged;
  while (head) {
    console.log(head.val);
    head = head.next;
  }
})();