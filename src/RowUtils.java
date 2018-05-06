import data.Cell;
import data.Grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import Intererfaces.*;

public class RowUtils implements RowIsoUtil , RowSolvingUtil {
	
	public static void main(String[] args) {
		Grid grid1 = new Grid(9);
		RowUtils x = new RowUtils();
		int[] rowValues={6,2,-1,4,7,5,1,8,9};
		grid1.setRowValues(1, rowValues);
		
		
		System.out.println(x.isFullHouseRow(grid1, grid1.getCell(1, 1)));
		System.out.println(x.hasFullHouseRow(grid1));
	}

	@Override
	public void applyBlockInternRowPermutation(Grid grid, Cell anchor, int[] image) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isBlockInternRowPermutation(Grid grid1, Grid grid2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] getBlockInternRowPermutationImage(Grid grid1, Grid grid2, Cell anchor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void applyRowValuePermutation(Grid grid, Cell anchor, int[] image) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] getRowValuePermutationImage(Grid grid1, Grid grid2, Cell anchor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isRowValuePermutation(Grid grid1, Grid grid2, Cell anchor) {
		// TODO Auto-generated method stub
		return false;
	}
	

	/*
	 * ===========================
	 * AB HIER RowSolvingUtil.java
	 * ===========================
	 */
	@Override
	public boolean isValidRow(Grid grid, Cell anchor) {
		// soll überprüfen ob die Zeile richtig gefüllt ist
		
		//die zeile
		int zeile= anchor.getrIndex();
		//die werte der jeweiligen zeile
		int[] rowValues = grid.getRowValues(zeile);
		
		int aktZahl;
		for(int i = 1; i<=9; i++)
		{
			int aktAnzahl=0;
			aktZahl=i;
			for(int j =0;j<rowValues.length;j++)
			{
				if(rowValues[j]==aktZahl)
				{
					aktAnzahl++;
					if(aktAnzahl>1) return false;
				}
			}
			
		}
		
		return true;
	}

	@Override
	public Cell[] getRowWhiteSpaces(Grid grid, Cell anchor) {
		
		int zeile = anchor.getrIndex();
		int[] rowValues = grid.getRowValues(zeile);
		List<Cell> leereCellen = new ArrayList<Cell>();
		
		for(int i =0; i<rowValues.length;i++)
		{
			if(rowValues[i]==-1)
			{
				Cell akt = new Cell(zeile,i+1);
				leereCellen.add(akt);
				
			}
		}
		
		Cell[] leereCellArray = new Cell[leereCellen.size()];
		leereCellArray= leereCellen.toArray(leereCellArray);
		
		return leereCellArray;
	}

	@Override
	public boolean hasFullHouseRow(Grid grid) {
		// TODO Auto-generated method stub
		for(int i =1; i<=9; i++)
		{
			if(!isFullHouseRow(grid, grid.getCell(i, 1))) return false;
			
		}
		
		
		return true;
	}

	@Override
	public boolean isFullHouseRow(Grid grid, Cell anchor) {
		
		//die zeile
		int zeile= anchor.getrIndex();
		//die werte der jeweiligen zeile
		int[] rowValues = grid.getRowValues(zeile);
		
		int aktZahl;
		for(int i = -1; i<=9; i++)
		{
			int aktAnzahl=0;
			aktZahl=i;
			for(int j =0;j<rowValues.length;j++)
			{
				if(rowValues[j]==aktZahl)
				{
					aktAnzahl++;
					if(aktAnzahl>1) return false;
				}
			}
			
		}
		
		return true;
	}

	@Override
	public boolean isRowWithNakedSingleCell(Grid grid, Cell anchor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cell getRowNakedSingleCell(Grid grid, Cell anchor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isRowWithHiddenSingleCell(Grid grid, Cell anchor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cell getRowHiddenSingleCell(Grid grid, Cell anchor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isRowWithNakedPairCells(Grid grid, Cell anchor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cell[] getRowNakedPairCells(Grid grid, Cell anchor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isRowWithHiddenPairCells(Grid grid, Cell anchor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cell[] getRowHiddenPairCells(Grid grid, Cell anchor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Grid> solveRowBased(Grid grid) {
		// TODO Auto-generated method stub
		return null;
	}
}