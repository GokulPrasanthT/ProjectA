package com.chainsys.projectA.beans;

public class ScoreBoard {
	public int targetScore;

	public ScoreBoard() {
		System.out.println("ScoreBoard object is created ");
	}

	private ScoreBoard(int runs) {
		targetScore = runs;
		System.out.println("ScoreBard Object is Created " + runs);
	}
// The Factory Method is Static here.
	public static ScoreBoard createObject() {
		return new ScoreBoard();
	}
	public static ScoreBoard createObject(int runs) {
		return new ScoreBoard(runs);
	}

}
