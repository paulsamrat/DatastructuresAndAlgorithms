package com.practise.design.pattern.structural;
interface IShape{
	public void draw();
}
class Circle implements IShape{

	public void draw() {
		System.out.println("Shape: Circle");		
	}	
}
class Rectangle implements IShape{

	public void draw() {
		System.out.println("Shape: Rectangle");		
	}	
}

abstract class  ShapeDecorator implements IShape{
	public IShape decoratedShape;
	public ShapeDecorator(IShape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}
	 public void draw(){
	      decoratedShape.draw();
	   }
}
class RedShapeDecorator extends ShapeDecorator{

	public RedShapeDecorator(IShape decoratedShape) {
		super(decoratedShape);
		// TODO Auto-generated constructor stub
	}
	@Override
	   public void draw() {
	      decoratedShape.draw();	       
	      setRedBorder(decoratedShape);
	   }

	   private void setRedBorder(IShape decoratedShape){
	      System.out.println("Border Color: Red");
	   }
}
public class DecoratorPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IShape circle = new Circle();

		IShape redCircle = new RedShapeDecorator(new Circle());

		IShape redRectangle = new RedShapeDecorator(new Rectangle());
		System.out.println("Circle with normal border");
		circle.draw();

		System.out.println("\nCircle of red border");
		redCircle.draw();

		System.out.println("\nRectangle of red border");
		redRectangle.draw();
	}

}
