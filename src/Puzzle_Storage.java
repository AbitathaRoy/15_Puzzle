public class Puzzle_Storage
{
    int[][] final_puzzle;

    Puzzle_Storage()
    {
        // initialise the final puzzle
        final_puzzle = new int[4][4];
        int entry = 1;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                final_puzzle[i][j] = entry++;
            }
        }
    }

    void display_puzzle(int[][] puzzle, int flag)
    {
        // flag 0 -> display puzzle; flag 1 -> display index

        // display a puzzle
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (puzzle[i][j] < 10)
                    System.out.print(" " + puzzle[i][j] + " ");
                else if (puzzle[i][j] >= 10 && puzzle[i][j] <= 15)
                    System.out.print(puzzle[i][j] + " ");
                else if (puzzle[i][j] == 16 && flag == 1)
                    System.out.println(puzzle[i][j] + " ");
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }
}
