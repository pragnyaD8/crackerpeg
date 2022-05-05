public class Boards
{
    public int pegCount;
    public int[] cells;

    public Boards(int emptyCell)
    {
        cells = new int[15];
        pegCount = 14;
        for (int i = 0; i < 15; i++)
            cells[i] = i == emptyCell ? 0 : 1;
    }

    public Boards(int pegCount, int[] cells)
    {
        this.pegCount = pegCount;
        this.cells    = cells.clone();
    }

    public Boards moves(Moves m)
    {
        if (cells[m.source] == 1 &&
                cells[m.through] == 1 &&
                cells[m.dest]   == 0)
        {
            Boards boardAfter = new Boards(pegCount-1, cells.clone());
            boardAfter.cells[m.source] = 0;
            boardAfter.cells[m.through] = 0;
            boardAfter.cells[m.dest]   = 1;

            return boardAfter;
        }
        return null;
    }
}
