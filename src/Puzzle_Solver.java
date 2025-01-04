import java.util.*;
public class Puzzle_Solver extends Puzzle_Storage
{
    protected int[][] puzzle;

    Puzzle_Solver(int[]... arg)
    {
        puzzle = new int[4][4];

        if (arg.length > 0)    // copy from the temporary array
        {
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    this.puzzle[i][j] = arg[i][j];
                }
            }
        }
    }

    Puzzle_Solver() {
        puzzle = new int[4][4];  // Default initialization
    }

    void random_puzzle_generator()
    {
        Puzzle_Solver ob = new Puzzle_Solver();

        // list of entries
        ArrayList<Integer> entries = new ArrayList<Integer>();
        for (int i = 1; i <= 16; i++)
        {
            entries.add(i);
        }

        // shuffle the entries
        Collections.shuffle(entries);

        // insert entries into the puzzle
        for (int i = 0; i <= 15; i++)
        {
            int row = (i)/4;
            int col = (i)%4;

            puzzle[row][col] = entries.get(i);
        }
    }

    Puzzle_Solver input_puzzle()
    {
        // fill it with buffer input for display purposes
        int[][] puzzle_temp = {
                {16, 16, 16, 16},
                {16, 16, 16, 16},
                {16, 16, 16, 16},
                {16, 16, 16, 16}
        };

        Puzzle_Solver ob = new Puzzle_Solver(puzzle_temp);

        // interactive input system
        System.out.println("The following index system is to be followed");
        display_puzzle(final_puzzle, 1);

        Scanner sc = new Scanner(System.in);
        for (int entry = 1; entry <= 15; entry++)
        {
            System.out.println("Enter the position for entry " + entry);
            int index = sc.nextInt();

            if (index < 1 || index > 16)
            {
                System.out.println("Invalid position, try again.");
                entry--;
                continue;
            }

            int row = (index-1)/4;
            int col = (index-1)%4;

            if (ob.puzzle[row][col] != 16)
            {
                System.out.println("Position already filled, try again.");
                entry--;
                continue;
            }

            ob.puzzle[row][col] = entry;
            display_puzzle(ob.puzzle, 0);
        }

        sc.close();
        return ob;
    }

}
