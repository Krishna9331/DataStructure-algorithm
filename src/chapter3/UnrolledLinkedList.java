package chapter3;

/**
 * Created by mishrk3 on 4/13/2016.
 */
public class UnrolledLinkedList<E> {
	public static int MAX_NUM_NODES = 4;
	Block<E> blockHead;

	private static class Block<E> {
		Node<E> head;
		Block<E> next;
		int size;
	}

	private static class Node<E> {
		E item;
		Node<E> prev;

		public Node(E item, Node<E> prev) {
			this.item = item;
			this.prev = prev;
		}
	}

	private static class SearchVo<E> {
		Block<E> blk;
		Node<E> node;
	}

	public SearchVo<E> search(int position) {
		SearchVo<E> sVo = new SearchVo<>();
		//		find the block num for the given position of node.
		int j = (position + MAX_NUM_NODES - 1) / MAX_NUM_NODES;
		Block<E> block = blockHead;
		while (--j > 0) {
			block = block.next;
		}
		sVo.blk = block;
		Node<E> node = block.head;
		position = position % MAX_NUM_NODES;
		if (position == 0) {
			position = MAX_NUM_NODES;
		}
		position = block.size + 1 - position;
		while (position-- > 0) {
			node = node.prev;
		}
		sVo.node = node;
		return sVo;
	}

	void shift(Block<E> block) {

		Block<E> block1;
		Node<E> temp;
		while (block.size > MAX_NUM_NODES) {
			if (null == block.next) {
				block.next = new Block<E>();
				block1 = block.next;
				temp = block.head.prev;
				block.head.prev = block.head.prev.prev;
				block1.head = temp;
				temp.prev = temp;
				block.size--;
				block1.size++;
			} else {
				block1 = block.next;
				temp = block.head.prev;
				block.head.prev = block.head.prev.prev;
				temp.prev = block1.head.prev;
				block1.head.prev = temp;
				block1.head = temp;
				block.size--;
				block1.size++;
			}
			block = block1;
		}

	}

	public void add(int nodePos, E data) {
		Node<E> p, q;
		Block<E> r;
		if (null == blockHead) {
			blockHead = new Block<E>();
			blockHead.head = new Node<E>(data, null);
			blockHead.head.prev = blockHead.head;
			blockHead.size++;
		} else {
			if (nodePos == 0) {
				p = blockHead.head;
				q = p.prev;
				p.prev = new Node<E>(data, null);
				p.prev.prev = q;
				blockHead.head = p.prev;
				blockHead.size++;
				shift(blockHead);
			} else {
				SearchVo<E> vo = search(nodePos);
				r = vo.blk;
				p = vo.node;
				q = p;
				while (q.prev != p) {
					q = q.prev;
				}
				q.prev = new Node<E>(data, null);
				q.prev.prev = p;
				r.size++;
				shift(r);
			}
		}
	}

	E getNodeItemForPos(int pos) {
		SearchVo<E> vo = search(pos);
		return vo.node.item;
	}

	public void print(UnrolledLinkedList<E> list) {
		if (null == list.blockHead) {
			System.out.println("List is empty");
		} else {
			System.out.println("order of item is head then tail and the continue till we reach head");
			Block<E> blk = blockHead;
			do {
				Node<E> current = blk.head;
				do {
					System.out.print(current.item + " --> ");
					current = current.prev;
				} while (blk.head != current);
				blk = blk.next;
				System.out.println();
				System.out.println("Next block");
			} while (null != blk);
		}
	}

	public static void main(String[] args) {
		UnrolledLinkedList<Integer> ul = new UnrolledLinkedList<>();
		ul.add(0, 3);
		ul.add(1, 5);
		ul.add(1, 4);
		ul.add(0, 6);
		ul.add(1, 7);
		ul.add(0, 2);
		ul.add(7, 9);
		ul.add(6, 1);
		ul.add(4, 11);
		ul.print(ul);
	}

}
