import data.Cell;
import data.Grid;

import java.util.ArrayList;
import java.util.List;


import Intererfaces.*;

public class RowUtils implements RowIsoUtil , RowSolvingUtil {
	
	public static void main(String[] args) {
		Grid grid1 = new Grid(9);
		RowUtils x = new RowUtils();
		int[] rowValues={6,2,3,4,7,5,-1,8,9};
		grid1.setRowValues(1, rowValues);
		Cell y[]=x.getRowWhiteSpaces(grid1, grid1.getCell(1, 1));
		for(int i =0;i<y.length;i++) System.out.println(y[i].getcIndex());
		System.out.println(x.isFullHouseRow(grid1, grid1.getCell(1, 1)));
		System.out.println(x.hasFullHouseRow(grid1));
		System.out.println(x.getRowNakedSingleCell(grid1,  grid1.getCell(1, 1)).getcIndex());
		
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
		
	
		
		return false;
	}

	@Override
	public Cell getRowNakedSingleCell(Grid grid, Cell anchor) {
		// TODO Auto-generated method stub
		Cell aCellList[] = null;
		if(isRowWithNakedSingleCell(grid, anchor))
		{
			aCellList=getRowWhiteSpaces(grid,anchor);
			Cell temp =aCellList[0];
			return temp;
		}
		else return null;

	}

	@Override
	public boolean isRowWithHiddenSingleCell(Grid grid, Cell anchor) {
		int blockArray[]= {1,2,3,4,5,6,7,8,9};
		int spalteArray[]= {1,2,3,4,5,6,7,8,9};
		int zeileArray[]= {1,2,3,4,5,6,7,8,9};
		int [] rowValues=grid.getRowValues(anchor.getrIndex());
		int [] colValuses=grid.getColValues(anchor.getcIndex());
		
		List<Integer> mylist = new ArrayList<Integer>();
		List<Integer> mylist2 = new ArrayList<Integer>();
		List<Integer> mylist3 = new ArrayList<Integer>();
		
		List<Integer> mylist4 = new ArrayList<Integer>();
		List<Integer> mylist5 = new ArrayList<Integer>();
		List<Integer> mylist6 = new ArrayList<Integer>();
		
		List<Integer> mylist7 = new ArrayList<Integer>();
		List<Integer> mylist8 = new ArrayList<Integer>();
		List<Integer> mylist9 = new ArrayList<Integer>();
		for (int zeile=1; zeile<=3;zeile++)
		{
			for(int spalte=1; spalte<=3;spalte++)
			{
				mylist.add(grid.getValue(zeile, spalte));
			}
			
			for(int spalte=4; spalte<=6;spalte++)
			{
				mylist2.add(grid.getValue(zeile, spalte));
			}
			
			for(int spalte=7; spalte<=9;spalte++)
			{
				mylist3.add(grid.getValue(zeile, spalte));
			}
		}
		
		for (int zeile=4; zeile<=6;zeile++)
		{
			for(int spalte=1; spalte<=3;spalte++)
			{
				mylist4.add(grid.getValue(zeile, spalte));
			}
			
			for(int spalte=4; spalte<=6;spalte++)
			{
				mylist5.add(grid.getValue(zeile, spalte));
			}
			
			for(int spalte=7; spalte<=9;spalte++)
			{
				mylist6.add(grid.getValue(zeile, spalte));
			}
		}
		
		for (int zeile=7; zeile<=9;zeile++)
		{
			for(int spalte=1; spalte<=3;spalte++)
			{
				mylist7.add(grid.getValue(zeile, spalte));
			}
			
			for(int spalte=4; spalte<=6;spalte++)
			{
				mylist8.add(grid.getValue(zeile, spalte));
			}
			
			for(int spalte=7; spalte<=9;spalte++)
			{
				mylist9.add(grid.getValue(zeile, spalte));
			}
		}
		int blockValue[];
		int blockValue2[];
		int blockValue3[];
		int blockValue4[];
		int blockValue5[];
		int blockValue6[];
		int blockValue7[];
		int blockValue8[];
		int blockValue9[];
		for(int i =0; i<=9; i++)
		{
			blockArray[i]=mylist.get(i);
		}
		
		
		
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