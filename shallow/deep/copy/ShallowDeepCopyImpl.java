package deep.copy;

public class ShallowDeepCopyImpl implements Cloneable{

	private int version ;
	private ShallowDeepCopyTest  shallowDeepCopyTest;
	
	
	public ShallowDeepCopyImpl()
	{
		this.version = 1;
		this.shallowDeepCopyTest = new ShallowDeepCopyTest();
	}
	protected void func(){System.out.println("ShallowDeepCopyImpl");}
	protected Object clone()
	{
		try {
			//Shallow Copy.
			return super.clone();
			//Deep Copy.
			//return new ShallowDeepCopyImpl();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
		//return new ShallowDeepCopyImpl();
	}
	
	public ShallowDeepCopyTest getShallowDeepCopyTest() {
		return shallowDeepCopyTest;
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		// Original Object
		ShallowDeepCopyImpl object = new ShallowDeepCopyImpl();
		System.out.println(" Version " + object.version + "  Reference Class Name " + object.getShallowDeepCopyTest().getClassName());
		
		//Shallow Copy
		ShallowDeepCopyImpl clonedObject = (ShallowDeepCopyImpl)object.clone();
		System.out.println(" Cloned Version " + object.version + "  Cloned Reference Class Name " + clonedObject.getShallowDeepCopyTest().getClassName());
		
		
		//Updating the Parent object.
		object.version =2;
		object.getShallowDeepCopyTest().setClassName(ShallowDeepCopyTest.class.getName().concat("Changed"));
		
		System.out.println(" After Updation");
		System.out.println(" Version " + object.version + "  Reference Class Name " + object.getShallowDeepCopyTest().getClassName());
		System.out.println(" Cloned Version " + clonedObject.version + "  Cloned Reference Class Name " + clonedObject.getShallowDeepCopyTest().getClassName());

		

	}

}
