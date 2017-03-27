package chapter10.problems;

import chapter10.MergeSort;

/**
 * Created by mishrk3 on 3/27/2017.
 */

/**
 * Given an array A[0...n-1], where each elements of array represent a vote in the election. If each vote is given as an
 * integer representing candidate ID of the chosen candidate. Give and algorithm to determine the winner.
 */
public class ElectionWinner {

	private static class Candidate {
		int candidateId;
		int totalVotes;

		public Candidate(int candidateId, int totalVotes) {
			this.candidateId = candidateId;
			this.totalVotes = totalVotes;
		}
	}

	public Candidate findWinner(int[] electionVotes) {
		MergeSort ms = new MergeSort();
		ms.sort(electionVotes);
		int maxVotes = 0;
		int currentVote = 0;
		int currentCandidateId = electionVotes[0];
		int maxCandidateId = electionVotes[0];
		for (int i = 0; i < electionVotes.length; i++) {
			if (currentCandidateId == electionVotes[i]) {
				currentVote++;
			} else {
				currentCandidateId = electionVotes[i];
				currentVote = 1;
			}
			if (currentVote > maxVotes) {
				maxVotes = currentVote;
				maxCandidateId = currentCandidateId;
			}
		}
		return new Candidate(maxCandidateId, maxVotes);
	}

	public static void main(String[] args) {

		ElectionWinner ew = new ElectionWinner();

		int[] electionVotes = {
				24, 56, 24, 42, 64, 32, 56, 24, 42, 64, 56, 42, 78, 56
		};

		Candidate leader = ew.findWinner(electionVotes);
		System.out.println("The winner is: " + leader.candidateId + " and total votes are: " + leader.totalVotes);
	}
}
