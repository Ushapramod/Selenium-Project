package com.SwagLabs;

import java.io.File;

import org.testng.annotations.Test;

import com.SwagLab_POM.CheckBox_POM;

public class checkbox extends Base {
	long startTime;
	long endTime;
	@Test(invocationCount = 10,threadPoolSize = 3)
	
	public void checkBox() throws InterruptedException {
		System.out.println("current thread id"+Thread.currentThread().getId());
		startTime=System.currentTimeMillis();
		File file = new File("C:\\Users\\USHA PRAMOD\\Desktop\\html projects for selenium\\chekbox.html"); // Update
		// with
		// actual
		// file path
		String filePath = "file:///" + file.getAbsolutePath();
		driver.get(filePath);
		Thread.sleep(3000);
		CheckBox_POM checkBoxes = new CheckBox_POM(driver);
		checkBoxes.checkBoxes();
		endTime=System.currentTimeMillis();
		System.out.println("Time taken is "+(endTime-startTime)/1000+" seconds");
	}
	
	@Test
	public void method1()
	{System.out.println("method 1");}
	
	@Test
	public void method2()
	{System.out.println("method 2");}
	
	@Test
	public void method3()
	{System.out.println("method 3");}
	@Test
	public void method4()
	{System.out.println("method 4");}
	@Test
	public void method5()
	{System.out.println("method 5");}
	@Test
	public void method6()
	{System.out.println("method 6");}
	@Test
	public void method7()
	{System.out.println("method 7");}
	@Test
	public void method8()
	{System.out.println("method 8");}
	@Test
	public void method9()
	{System.out.println("method 9");}
	@Test
	public void method10()
	{System.out.println("method 10");}
	public void method11()
	{System.out.println("method 11");}
}
