package chess.ui;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public abstract class GameBoard extends Canvas implements PaintListener {
	protected int nV = 8;
	protected int nH = 8;

	protected Image[ ][ ] pieces;

	public abstract void paintSquare(GC gc, int v, int h);

	public GameBoard(Composite parent, int style) {
		super(parent, style);
		
		initBoard();
	}

	abstract void initBoard();

	@Override
	public void paintControl(PaintEvent e) {
		Rectangle clientArea = getClientArea();
		GC gc = e.gc;
		for (int v = 0; v < nV ; v++)
			for (int h = 0; h < nH ; h++) {
				paintSquare(gc, v, h);
				paintPiece(gc, v, h, pieces[v][h]);
			} // for
	
		e.gc.drawRectangle(0, 0, clientArea.width - 1, clientArea.height - 1);
	}

	protected void paintPiece(GC gc, int v, int h, Image image) {
		if (image == null) return;

		Rectangle imageRect = image.getBounds();
		int imageWidth  = imageRect.width;
		int imageHeight = imageRect.height;

		int squareWidth  = getClientArea().width  / nV;
		int squareHeight = getClientArea().height / nH;

		gc.drawImage(image, 
			0, 0, imageWidth, imageHeight, 
			v * squareWidth, h * squareHeight, squareWidth, squareHeight);
	}
}