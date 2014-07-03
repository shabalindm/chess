package chess.ui;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import chess.ChessImages;

public class ChessBoard extends PieceMovedBoard {
	public ChessBoard(Composite shell, int style) {
		super(shell, style);

		addPaintListener(this);
	}

	@Override
	public void paintSquare(GC gc, int v, int h) {
		int squareWidth = getClientArea().width / nV;
		int squareHeight = getClientArea().height / nH;

		boolean isWhiteSquare = ((v + h) % 2 == 0);
		Color squareColor = isWhiteSquare ? new Color(null, 255, 255, 255)
				: new Color(null, 0, 192, 0);

		gc.setBackground(squareColor);
		gc.fillRectangle(v * squareWidth, h * squareHeight, squareWidth,
				squareHeight);

		gc.setForeground(new Color(null, 0, 0, 0));
		gc.drawRectangle(v * squareWidth, h * squareHeight, squareWidth,
				squareHeight);
	}

	@Override
	void initBoard() {
		nV = 8;
		nH = 8;
		pieces = new Image[nV][nH];

		for (int k = 0; k < nV; k++) {
			pieces[k][1] = ChessImages.imagePawnBlack;
			pieces[k][6] = ChessImages.imagePawnWhite;
		}
		
		pieces[0][0] = ChessImages.imageRookBlack;
		pieces[7][0] = ChessImages.imageRookBlack;
		pieces[0][7] = ChessImages.imageRookWhite;
		pieces[7][7] = ChessImages.imageRookWhite;

		pieces[1][0] = ChessImages.imageKnightBlack;
		pieces[6][0] = ChessImages.imageKnightBlack;
		pieces[1][7] = ChessImages.imageKnightWhite;
		pieces[6][7] = ChessImages.imageKnightWhite;
		
		pieces[2][0] = ChessImages.imageBishopBlack;
		pieces[5][0] = ChessImages.imageBishopBlack;
		pieces[2][7] = ChessImages.imageBishopWhite;
		pieces[5][7] = ChessImages.imageBishopWhite;
		
		pieces[3][0] = ChessImages.imageQueenBlack;
		pieces[3][7] = ChessImages.imageQueenWhite;
		
		pieces[4][0] = ChessImages.imageKingBlack;
		pieces[4][7] = ChessImages.imageKingWhite;
	}
}
