package id.ac.its.kelompokxyz.view;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import id.ac.its.kelompokxyz.app.Board;
import id.ac.its.kelompokxyz.app.MainPanel;
import id.ac.its.kelompokxyz.controller.Controller;
import id.ac.its.kelompokxyz.model.MyButton;

public class ViewButtonListener extends ViewListener {
	KeyEvent key;
	
	MyButton bPlay = new MyButton("PLAY"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			controller.setChoosingDifficulty();
			controller.respondToInput();
		};
	};
	
	MyButton bDif = new MyButton("RESET SCORE"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			// Function MAP / LEVEL
//			new CreateIO().reset();
//			updateScore();
		};
	};
	
	MyButton bCredit = new MyButton("CREDITS"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			controller.setCredit();
			controller.respondToInput();
		};
	};
	
	MyButton bExit = new MyButton("EXIT") {
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			System.exit(0);
		};
	};
	
	MyButton bEasy = new MyButton("EASY"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			controller.setDifficulty(0);
			controller.respondToInput();
		};
	};
	MyButton bMedium = new MyButton("MEDIUM"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			controller.setDifficulty(1);
			controller.respondToInput();
		};
	};
	MyButton bHard = new MyButton("HARD"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			controller.setDifficulty(2);
			controller.respondToInput();
		};
	};
	MyButton bBack = new MyButton("MAIN MENU") {
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			controller.setGameMenu();
			controller.respondToInput();
		};
	};
	
	MyButton menubtn = new MyButton("MAIN MENU"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			controller.setGameMenu();
			controller.respondToInput();
		};
	};

	public MyButton getbPlay() {
		return bPlay;
	}

	public MyButton getbDif() {
		return bDif;
	}

	public MyButton getbCredit() {
		return bCredit;
	}

	public MyButton getbExit() {
		return bExit;
	}
	public MyButton getbEasy() {
		return bEasy;
	}

	public MyButton getbMedium() {
		return bMedium;
	}

	public MyButton getbHard() {
		return bHard;
	}

	public MyButton getbBack() {
		return bBack;
	}

	public MyButton getMenubtn() {
		return menubtn;
	}

}