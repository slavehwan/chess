package piece;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Exception.InvalidMovePositionException;
import piece.Piece.Type;

public class PawnTest {
	@Test
	public void create_pawn() throws Exception {
		Position position = new Position(1, 1);
		verifyPiece(Pawn.createWhite(position), Pawn.createBlack(position), Type.PAWN);
	}

	private void verifyPiece(Pawn whitePiece, Pawn blackPiece, Type type) {
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());

		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
	}

	@Test
	public void isStartingPosition() throws Exception {
		Pawn pawn = Pawn.createWhite(new Position("e2"));
		assertTrue(pawn.isStartingPosition());
		pawn = Pawn.createWhite(new Position("e3"));
		assertFalse(pawn.isStartingPosition());

		pawn = Pawn.createBlack(new Position("e7"));
		assertTrue(pawn.isStartingPosition());
		pawn = Pawn.createBlack(new Position("e6"));
		assertFalse(pawn.isStartingPosition());
	}

	@Test
	public void verifyMovePosition_starting() throws Exception {
		Pawn pawn = Pawn.createWhite(new Position("e2"));
		pawn.verifyMovePosition(Blank.create(new Position("e3")));
		pawn.verifyMovePosition(Blank.create(new Position("e4")));
		pawn.verifyMovePosition(Blank.create(new Position("d3")));
		pawn.verifyMovePosition(Blank.create(new Position("f3")));

		pawn = Pawn.createBlack(new Position("e7"));
		pawn.verifyMovePosition(Blank.create(new Position("e6")));
		pawn.verifyMovePosition(Blank.create(new Position("e5")));
		pawn.verifyMovePosition(Blank.create(new Position("d6")));
		pawn.verifyMovePosition(Blank.create(new Position("f6")));
	}

	@Test(expected = InvalidMovePositionException.class)
	public void verifyMovePosition_non_starting() throws Exception {
		Pawn pawn = Pawn.createWhite(new Position("e3"));
		pawn.verifyMovePosition(Blank.create(new Position("e5")));
	}

	@Test(expected = InvalidMovePositionException.class)
	public void verifyMovePosition_starting_overmove() throws Exception {
		Pawn pawn = Pawn.createWhite(new Position("e2"));
		pawn.verifyMovePosition(Blank.create(new Position("e5")));
	}

	@Test(expected = InvalidMovePositionException.class)
	public void verifyMovePosition_invalid_white() throws Exception {
		Pawn pawn = Pawn.createWhite(new Position("e5"));
		pawn.verifyMovePosition(Blank.create(new Position("e4")));
	}

	@Test(expected = InvalidMovePositionException.class)
	public void verifyMovePosition_invalid_black() throws Exception {
		Pawn pawn = Pawn.createBlack(new Position("e3"));
		pawn.verifyMovePosition(Blank.create(new Position("e4")));
	}

}
