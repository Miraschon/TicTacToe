package com.tictactoe;
/*
 *     This file is part of fxTodo.
 *
 *     fxTodo is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     fxTodo is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with fxTodo.  If not, see <https://www.gnu.org/licenses/>.
 */

import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.prefs.Preferences;

/**
 * @author Oleg Z. (cornknight@gmail.com)
 */
public class Prefs {

	private final Preferences prefs;

	public Prefs() {
		prefs = Preferences.userRoot().node("fxTodo");
	}

	public void saveStage(Stage stage) {
		prefs.putDouble("X",stage.getX());
		prefs.putDouble("Y",stage.getY());
		prefs.putDouble("W", stage.getWidth());
		prefs.putDouble("H", stage.getHeight());
	}

	public void restoreStage(Stage stage) {
		stage.setX(prefs.getDouble("X",0));
		stage.setY(prefs.getDouble("Y",0));
		stage.setWidth(prefs.getDouble("W",640));
		stage.setHeight(prefs.getDouble("H",480));
	}

	public Font getDefaultFont() {
		return new Font(prefs.get("DefaultFontName", "Arial"), prefs.getDouble("DefaultFontSize", 18));
	}
}
