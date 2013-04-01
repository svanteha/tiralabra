
/**
 *
 * @author svanteha
 */
public class MinHeap {

    private int size;
    private Node[] heap;
    private int max;

    public MinHeap(int maxSize) {
        max = maxSize;
        size = 0;
        heap = new Node[max];


    }

    public void insert(Node node) {

        if (isEmpty()) {
            size++;
            heap[size] = node;
        } else {
            size++;
            heap[size] = node;
            int current = size;

            while (heap[current].getValue() < heap[parent(current)].getValue()) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

    }

    public Node pop() {
        swap(1, size);
        size--;
        if (size != 0) {
            pushDown(1);
        }
        return heap[size + 1];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    private void pushDown(int pos) {
        int smallestChild;
        while (!isLeaf(pos)) {
            smallestChild = leftChild(pos);
            if ((smallestChild < size) && (heap[smallestChild].getValue() > heap[smallestChild + 1].getValue())) {
                smallestChild = smallestChild + 1;
            }
            if (heap[pos].getValue() <= heap[smallestChild].getValue()) {
                return;
            }
            swap(pos, smallestChild);
            pos = smallestChild;
        }
    }

    private void swap(int pos1, int pos2) {
        Node tmp;

        tmp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = tmp;

    }

    private int leftChild(int pos) {
        return 2 * pos;
    }

    private int rightChild(int pos) {
        return 2 * pos + 1;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private boolean isLeaf(int pos) {
        return ((pos > size / 2) && (pos <= size));
    }
}
