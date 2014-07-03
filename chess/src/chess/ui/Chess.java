package chess.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import chess.ChessImages;

/**
 * 
 * @author Romanov
 * Chess game
 */
public class Chess {
	public static void main(String[] args) {
		final Display display1 = new Display();
		ChessImages.load(display1);
		
		final Shell shell = new Shell(display1);
		
		shell.setSize(600, 600);
		shell.setText("Chess Notepad");
		shell.setImage(ChessImages.iconChessNotebook);
		
		FillLayout layout = new FillLayout();
		shell.setLayout(layout);
		
		TabFolder gamesFolder = new TabFolder(shell, SWT.TOP);
		
		Image chessImage = new Image(display1,
				ChessImages.imageKnightBlack.getImageData()
											.scaledTo(20, 20));
		
		TabItem chessItem = new TabItem(gamesFolder, SWT.NONE);
		chessItem.setText("Chess");
		chessItem.setImage(chessImage);
		chessItem.setControl(new ChessBoard(gamesFolder, SWT.NONE));
		
		
		Image goImage = new Image(display1,
				ChessImages.imagePawnWhite.getImageData()
											.scaledTo(20, 20));
		
		TabItem goItem = new TabItem(gamesFolder, SWT.NONE);
		goItem.setText("Go");
		goItem.setImage(goImage);
		goItem.setControl(new JapanBoard(gamesFolder, SWT.NONE));
		
	    shell.open();
		while (!shell.isDisposed()) {
			if (!display1.readAndDispatch())
				display1.sleep();
		}
		display1.dispose();
	} // main
} // class Chess