package com.practise.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class ReflectionMain {

	public  void testReflection(Object object){
		Class<?> runtimeClass = Person.class.getClass();
		Method[] methods = runtimeClass.getMethods();
		try {
			runtimeClass.getDeclaredConstructor(Person.class).setAccessible(true);
			//runtimeClass.newInstance();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for( Method method :  methods){
			if (isGetter(method)){
				try {
					Object obj = method.invoke(object, new Object[]{});
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

        Class student = Person.class.getClass();
        Method[] methods1 = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<String>();
        for( Method m : methods){
            methodList.add(m.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }
	
	public static boolean isGetter(Method method){
		if(!method.getName().startsWith("get"))      return false;
		if(method.getParameterTypes().length != 0)   return false;  
		if(void.class.equals(method.getReturnType())) return false;
		return true;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("samrat", 10);
		new ReflectionMain().testReflection(p);

	}

}
