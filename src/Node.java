
public class Node implements Comparable <Node> {
Info info;
Node left, right;

	public Node(Info info, Node left, Node right) {
	this.info = info;
	this.left = left;
	this.right = right;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int compareTo(Node o)
	{ if (Integer.compare(getInfo().getNumber(), o.getInfo().getNumber()) == 0)
	return Integer.compare(getInfo().getLetter(), o.getInfo().getLetter()); else
	return Integer.compare(getInfo().getNumber(), o.getInfo().getNumber());
	}
}
