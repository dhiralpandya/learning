package com.omt.learn.algo.util.job;

public class JobSequence implements Comparable<JobSequence> {

	private String jobId;
	private int deadline = -1;
	private int profit = -1;

	public JobSequence(String jobId, int deadline, int profit) {
		this.jobId = jobId;
		this.deadline = deadline;
		this.profit = profit;
	}

	public String getJobId() {
		return jobId;
	}

	public int getDeadline() {
		return deadline;
	}

	public int getProfit() {
		return profit;
	}

	@Override
	public int compareTo(JobSequence o) {
		return this.profit - o.getProfit();
	}

}
