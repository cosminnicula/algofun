import ListNode from "./util/ListNode";

(() => {
  function deleteDuplicates(head: ListNode | null): ListNode | null {
    let current = head;

    while (current) {
      while (current.next && current?.val === current?.next?.val) {
        const oldNext = current.next;

        current.next = current.next.next;

        oldNext.next = null;
      }


      current = current.next;
    }

    return head;
  };

  const list: ListNode = new ListNode(1);
  list.next = new ListNode(1);
  list.next.next = new ListNode(2);
  list.next.next.next = new ListNode(2);
  list.next.next.next.next = new ListNode(3);
  list.next.next.next.next.next = new ListNode(3);

  let head = deleteDuplicates(list);
  while (head) {
    console.log(head.val);
    head = head.next;
  }
})();
