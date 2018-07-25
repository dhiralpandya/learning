package com.omt.learn.geekforgeek.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.omt.learn.algo.util.job.JobSequence;

public class JobSequencingProblemFindAndUnion {

	public static void main(String[] args) {

		printJobSequence(getInputOne());
		printJobSequence(getInputTwo());
		printJobSequence(getInputThree());

	}

	public static void printJobSequence(List<JobSequence> jobSequences) {

		// Sorting to get Max Deadline
		Collections.sort(jobSequences, new Comparator<JobSequence>() {
			@Override
			public int compare(JobSequence o1, JobSequence o2) {
				return -(o1.getDeadline() - o2.getDeadline());
			}

			@Override
			public boolean equals(Object obj) {
				return super.equals(obj);
			}
		});

		// Get Max deadline
		int maxDeadLine = jobSequences.get(0).getDeadline();

		// Sort again with profit
		Collections.sort(jobSequences, Collections.reverseOrder());

		int sizeOfSubset = maxDeadLine + 1;
		// Create subset with size of maxDeadLine and assign default value.
		int[] subset = new int[sizeOfSubset];
		for (int count = 0; count < sizeOfSubset; count++) {
			subset[count] = count;
		}

		Map<Integer, JobSequence> positionJobSequenceMap = new TreeMap<>();
		for (JobSequence jobSequence : jobSequences) {
			int availablePosition = find(jobSequence.getDeadline(), subset);
			if (availablePosition > 0) {
				int nextAvailablePosition = find(availablePosition - 1, subset);

				positionJobSequenceMap.put(availablePosition, jobSequence);
				union(availablePosition, nextAvailablePosition, subset);
			}
		}

		StringBuilder result = new StringBuilder();
		for (Integer position : positionJobSequenceMap.keySet()) {
			result.append(positionJobSequenceMap.get(position).getJobId() + ",");
		}

		System.out.println(result.toString());

	}

	public static int find(int position, int[] subset) {
		if (subset[position] == position) {
			return position;
		}

		return find(subset[position], subset);
	}

	public static void union(int position, int nextAvailable, int[] subset) {
		subset[position] = nextAvailable;
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
