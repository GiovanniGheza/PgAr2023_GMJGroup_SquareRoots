package main;

public class MainSquareRoots {

	public static void main(String[] args) {
		Albero myTree = new Albero();
		
		myTree.generaCasualmente(3);
		
		System.out.println(myTree.toString());
		System.out.println(myTree.calcola());
	}
}