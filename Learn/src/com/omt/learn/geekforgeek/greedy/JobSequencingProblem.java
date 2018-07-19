package com.omt.learn.geekforgeek.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.omt.learn.algo.util.job.JobSequence;

public class JobSequencingProblem {

	public static void main(String[] args) {

		printJobSequence(getInputOne());
		printJobSequence(getInputTwo());
		printJobSequence(getInputThree());

	}

	public static void printJobSequence(List<JobSequence> jobSequences) {
		Collections.sort(jobSequences, Collections.reverseOrder());

		StringBuilder result = new StringBuilder();
		Map<Integer, JobSequence> positions = new TreeMap<>();

		for (JobSequence jobSequence : jobSequences) {
			int position = jobSequence.getDeadline();

			while (position > 0) {
				position--;
				if (!positions.containsKey(position)) {
					positions.put(position, jobSequence);
					break;
				}
			}

		}

		for (Integer position : positions.keySet()) {
			result.append(positions.get(position).getJobId() + ",");
		}

		System.out.println(result.toString());

	}

	public static List<JobSequence> getInputOne() {
		List<JobSequence> jobSequences = new ArrayList<>();

		jobSequences.add(new JobSequence("a", 4, 20));
		jobSequences.add(new JobSequence("b", 1, 10));
		jobSequences.add(new JobSequence("c", 1, 40));
		jobSequences.add(new JobSequence("d", 1, 30));

		return jobSequences;
	}

	public static List<JobSequence> getInputTwo() {
		List<JobSequence> jobSequences = new ArrayList<>();

		jobSequences.add(new JobSequence("g", 7, 30));
		jobSequences.add(new JobSequence("a", 4, 100));
		jobSequences.add(new JobSequence("e", 3, 70));
		jobSequences.add(new JobSequence("f", 3, 50));
		jobSequences.add(new JobSequence("c", 3, 80));
		jobSequences.add(new JobSequence("d", 3, 75));
		jobSequences.add(new JobSequence("b", 4, 90));

		return jobSequences;
	}

	public static List<JobSequence> getInputThree() {
		List<JobSequence> jobSequences = new ArrayList<>();

		jobSequences.add(new JobSequence("a", 2, 100));
		jobSequences.add(new JobSequence("e", 3, 15));
		jobSequences.add(new JobSequence("c", 2, 27));
		jobSequences.add(new JobSequence("d", 1, 25));
		jobSequences.add(new JobSequence("b", 1, 19));

		return jobSequences;
	}
}
