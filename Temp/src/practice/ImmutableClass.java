package practice;

import java.io.Serializable;

class A implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	private  String add;

	public A(String add) {
		super();
		this.add = add;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	@Override
	protected Object clone()  {
		A a = new A(new String(this.add)); // create new obj
		// copy/ recursive clone
		return a;
	}

}

public final class ImmutableClass {

	private final String name1;
	private final String name2;
	private A a;

	public ImmutableClass(String name1, String name2, A a) {
		super();
		this.name1 = name1;
		this.name2 = name2;
		this.a = (A) a.clone();
	}

	public String getName1() {
		return name1;
	}

	public String getName2() {
		return name2;
	}

	public A getA() {
		A other = null;
		other = (A) this.a.clone();
		return other;
	}

	/*
	 * private static <T> T cloneObj(T inObj) { T other = null;
	 * ByteArrayOutputStream bout = new ByteArrayOutputStream();
	 * 
	 * try { ObjectOutputStream oos = new ObjectOutputStream(bout);
	 * oos.writeObject(inObj);
	 * 
	 * ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
	 * 
	 * ObjectInputStream oin = new ObjectInputStream(bin); other = (T)
	 * oin.readObject(); } catch (IOException | ClassNotFoundException e) {
	 * e.printStackTrace(); } return other; }
	 */

	public static void main(String[] args) {
		A a = new A("AA");
		ImmutableClass im = new ImmutableClass("Chin", "Sara", a);
		a.setAdd("EEE");
		a.setAdd("CCC");
		A a2 = im.getA();
		a2.setAdd("BBB");

		System.out.println(im.getA().getAdd());
	}

}
