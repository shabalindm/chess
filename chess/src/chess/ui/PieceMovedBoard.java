package chess.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Composite;

public abstract class PieceMovedBoard extends GameBoard implements MouseListener {
	private Image selectedPiece;
	private int selectedPieceV;
	private int selectedPieceH;

	public PieceMovedBoard(Composite parent, int style) {
		super(parent, style);
		addMouseListener(this);
	}
	
	@Override
	public void mouseDoubleClick(MouseEvent e) {
	}

	@Override
	public void mouseDown(MouseEvent e) {
		int squareW = getClientArea().width / nV;
		int squareH = getClientArea().height / nH;

		selectedPieceV = e.x / squareW;
		selectedPieceH = e.y / squareH;

		selectedPiece = pieces[selectedPieceV][selectedPieceH];
		if (selectedPiece == null) return;

		pieces[selectedPieceV][selectedPieceH] = null;

		ImageData imageDate = selectedPiece.getImageData().scaledTo(squareW, squareH);
		
		Cursor cursorPiece = new Cursor(null, imageDate, squareW / 2, squareH / 2);
		setCursor(cursorPiece);
		
		redraw();
	}

	@Override
	public void mouseUp(MouseEvent e) {
		int squareWidth = getClientArea().width / nV;
		int squareHeight = getClientArea().height / nH;

		int v = e.x / squareWidth;
		int h = e.y / squareHeight;

		pieces[v][h] = selectedPiece;

		setCursor( new Cursor(null, SWT.CURSOR_ARROW) );

		redraw();
	} // mouseUp
}