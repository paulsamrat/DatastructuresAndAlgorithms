package deep.copy;

public class Test {
	private enum testenum{
		test1;
	}
	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			throw new NullPointerException();
		}catch(Exception e){
			
		}finally{
			System.out.println("finally");
		}
		
		System.out.println("done");
	}

}
