package com.tictactoe;
/*
 *     This file is part of TicTacToe.
 *
 *     TicTacToe is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     TicTacToe is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with TicTacToe.  If not, see <https://www.gnu.org/licenses/>.
 */

import com.tictactoe.ui.UI;
import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

/**
 * @author Oleg Z. (cornknight@gmail.com)
 */
public class App extends Application {

	@Override
	public void start(Stage stage) {
		Prefs prefs = new Prefs();
		stage.setScene(new UI().getScene());
		stage.setOnCloseRequest(e-> prefs.saveStage(stage));
		prefs.restoreStage(stage);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}

