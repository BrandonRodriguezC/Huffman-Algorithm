import java.util.ArrayList;
import java.util.Collections;

public class Process {
	ArrayList<Node> list = new ArrayList<Node>();
	Info info;
	Print print=new Print();
	double  totales=0, comprimidos=0, nivel=-1;

	public void listInformation(char vec[]) {

		for (int i = 0; i < vec.length; i++) {
			info = new Info((int)vec[i], 1);
			if (!isthere((int)vec[i])) {
				list.add(new Node(info, null, null));
			}
		}
		totales=suma();
		
		tree(list);
		factorC(list.get(0));
		comprimidos= Math.ceil(comprimidos/8);
		int porcentaje=(int)Math.round(comprimidos * 100 /totales);
		preorder(list.get(0));
		System.out.println();
		System.out.println(porcentaje);
		
		
	}

	public void tree(ArrayList<Node> list) {
		
		while (list.size() > 1) {
			Collections.sort(list);
			Info info = new Info(256, list.get(0).getInfo().getNumber() + list.get(1).getInfo().getNumber());
			Node aux = new Node(info, list.get(0), list.get(1));
			list.add(aux);
			list.remove(0);
			list.remove(0);

		}
		
	}

	public void preorder(Node proot) {
		if (proot != null) {
			System.out.print( proot.getInfo().getNumber() + ":" + proot.getInfo().getLetter() + " ");

			if (proot.getLeft() != null) {
				preorder(proot.getLeft());
			}
			if (proot.getRight() != null) {
				preorder(proot.getRight());
			}
		}
	}

	public void factorC(Node proot) {
		if (proot != null) {
			nivel++;
			if (proot.getInfo().getLetter()!=256) {
			comprimidos+=proot.getInfo().getNumber()*nivel;
					}
			if (proot.getLeft() != null) {
				factorC(proot.getLeft());
			}
			if (proot.getRight() != null) {
				factorC(proot.getRight());
			}
			nivel--;
		}
	}
	
	public boolean isthere(int letter) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getInfo().getLetter()==letter) {
				list.get(i).getInfo().setNumber(list.get(i).getInfo().getNumber() + 1);
				return true;
			}
		}
		return false;
	}

	public void printListInfo() {
		String information = "";
		for (int h = 0; h < list.size(); h++) {
			information = information + list.get(h).getInfo().getLetter()  + "-"
					+ list.get(h).getInfo().getNumber() + "\n";
		}
		System.out.println(information);
	}
	
	public int search(int a) {
		for (int h = 0; h < list.size(); h++) {
		if (list.get(h).getInfo().getLetter()==a) {
			return h;}
		}
		return 0;
	}
	
	public int suma() {
		int a=0;
		for (int i = 0; i < list.size(); i++) {
			a+=list.get(i).getInfo().getNumber();
		}
		return a;
	}

}
