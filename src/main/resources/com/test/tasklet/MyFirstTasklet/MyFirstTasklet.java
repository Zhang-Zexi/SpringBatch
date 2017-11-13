package com.test.tasklet.MyFirstTasklet;

public class MyFirstTasklet implements Tasklet{
	public RepeatStatus execute(StepContribution arg0,ChunkContext arg1) throw Excepiton{
		
		for(int i=0,i<0;i++){
			System.out.println(i);
		}
		
		return RepeatStatus.FINISHED;
	}

}
