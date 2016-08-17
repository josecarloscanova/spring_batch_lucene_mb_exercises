package org.nanotek.musicbrainz.job;

import java.util.Set;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobExecutionNotRunningException;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.launch.NoSuchJobExecutionException;
import org.springframework.batch.core.launch.support.SimpleJobOperator;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArtistCreditBootLoader {

	private static ClassPathXmlApplicationContext ctx;

	/**
	 * @param args
	 * @throws JobParametersInvalidException 
	 * @throws JobInstanceAlreadyCompleteException 
	 * @throws JobRestartException 
	 * @throws JobExecutionAlreadyRunningException 
	 * @throws NoSuchJobException 
	 * @throws JobExecutionNotRunningException 
	 * @throws NoSuchJobExecutionException 
	 */
	public static void main(String[] args)  {
		ctx = new ClassPathXmlApplicationContext(new String[] {
		"staging-test-context.xml"});
		Job artistKeyJob = (Job) ctx.getBean("artistCreditJob");
		SimpleJobOperator jobOperator =   (SimpleJobOperator) ctx.getBean("jobOperator");
		JobExplorer jobExplorer = (JobExplorer) ctx.getBean("jobExplorer");
		try { 
			jobExplorer.getJobNames();
			Set<Long> executions = jobOperator.getRunningExecutions("artistCreditJob");
			java.util.Iterator<Long> it = executions.iterator();
			while (it.hasNext()){
				JobExecution execution = jobExplorer.getJobExecution(it.next());
				execution.setStatus(BatchStatus.FAILED);
				execution.stop();
//				execution.
//				jobOperator.stop(it.next());  
			}
			jobOperator.start("artistCreditJob", "");
//			SimpleJobLauncher jobLauncher = (SimpleJobLauncher) ctx.getBean("jobLauncher");
//			jobLauncher.run(artistKeyJob, new JobParameters());
		}catch (Exception ex) 
		{ 
			ex.printStackTrace();
		}
	}

}
