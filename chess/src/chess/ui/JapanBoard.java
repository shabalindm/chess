package chess.ui;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

public class JapanBoard extends GameBoard {
	public JapanBoard(Composite shell, int style) {
		super(shell, style);
		
		addPaintListener(this);
	} 

	@Override
	public void paintSquare(GC gc, int v, int h) {
		int squareWidth  = getClientArea().width / nV;
		int squareHeight = getClientArea().height / nH;

		Color squareColor = new Color(null, 192, 192, 0);

		gc.setBackground(squareColor);
		gc.fillRectangle(v * squareWidth, h * squareHeight,
				squareWidth, squareHeight);

		int W_2 = squareWidth/2;
		int H_2 = squareHeight/2;
		
		int x = v * squareWidth  + W_2;
		int y = h * squareHeight + H_2;

		if (v !=    0) gc.drawLine(x, y, x - W_2, y);
		if (v != nV-1) gc.drawLine(x, y, x + W_2, y);

		if (h !=    0) gc.drawLine(x, y, x, y - H_2);
		if (h != nH-1) gc.drawLine(x, y, x, y + H_2);
	}

	@Override
	void initBoard() {
		nH = 15;
		nV = 15;
		
		pieces = new Image[nV][nH];
	}
}
