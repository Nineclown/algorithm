import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class E {
    static ArrayList<Node> nodeList = new ArrayList<Node>();
    static int[][] answer = {};

    public class Node {
        private int data;
        private int x, level;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int data, int x, int y) {
            this.setData(data);
            this.setX(x);
            this.setLevel(y);
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setLevel(int y) {
            this.level = y;
        }

        public int getX() {
            return x;
        }

        public int getLevel() {
            return level;
        }
    }
    //출처: http://swalloow.tistory.com/34?category=667489 [MyCloud]


    public int[][] solution(int[][] nodeinfo) {

        Node root;
        int num = nodeinfo.length;

        //노드 생성
        Node[] node = new Node[num];
        for (int i = 0; i < num; i++) {
            node[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
            nodeList.add(node[i]);
        }

        //레벨 순으로 노드 정렬
        Collections.sort(nodeList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.getLevel() > o2.getLevel())
                    return -1;
                else if (o1.getLevel() == o2.getLevel()) {
                    if (o1.getX() < o2.getX())
                        return -1;
                    else return 1;
                } else
                    return 0;
            }
        });

        answer = new int[21][21];

        //for()
        // System.out.println(nodeList.get(i));
        //preorder(0);


        return answer;
    }

    static void preorder(int n) {
        if (nodeList.get(n) != null) {
            answer[0][n] = nodeList.get(n).getData();
        }
        preorder(2 * n + 1);
        preorder(2 * n + 2);
    }

    public static void main(String[] args) {
        E e = new E();
        int[][] node = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        int[][] answerE = e.solution(node);

        System.out.println(answerE);

    }

}
