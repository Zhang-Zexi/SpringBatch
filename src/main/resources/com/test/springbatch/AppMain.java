package com.test.springbatch;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.context.ApplicationContext;

public class AppMain {
	public static void main(String[] args){
		ApplicationContext context;
		JobParametersBuilder jobPara = new ParametersBuilder();//设置文件路径参数
		context = new FileSystemXmlApplicationContext(new String[]{"classPath:applicationContext-batch-myfirstbatch.xml"});
		String jobName = "ioSampleJob";
		Job job = (Job)context.getBean(jobName);
		JobLauncher launcher = (JobLauncher)context.getBean("jobLauncher");
		JobExecution result = null;
		try{
			result = launcher.run(job,jobPara.toJobParameters());
		}catch(JobExecutionAlreadyRunningException e){
			e.printStackTrace();
		}catch(JobRestartException e){
			e.printStackTrace();
		}catch(JobInstanceAlreadyCompleteException e){
			e.printStackTrace();
		}cath(JobParametersInvalidException e){
			e.printStackTrace();
		}
		ExitStatus es = result.getExitStatus();
/*		任务正常完成
*/		if(es.getExitCode().equals(ExitStatus.COMPLETED.getExitCode()))
		{
			System.out.println("任务正常完成");
		}else{
			System.out.println("任务失败")
		}
		
	}
}
