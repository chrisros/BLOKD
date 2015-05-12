package MazeOefenMeuk;

public class Maze_Search {


   public static void main (String[] args) {
   //================================================================//
   //  Level data, creates new Maze object with the start and finish //
   //================================================================//
    int x = 1;
    int y = 1;
    int[][] grid = {{0,0,0,0,0,0},
                    {0,1,1,1,1,0},
                    {0,0,1,0,1,0},       
                    {0,1,1,0,1,0},
                    {0,1,0,0,1,0},
                    {0,1,1,1,1,0}, 
                    {0,0,0,0,0,0}};

    Maze doolhof = new Maze(grid, x, y);
    doolhof.printMaze();
    //================================================================//
    
    Solver solver = new Solver(doolhof);      
      if (solver.start())
         System.out.println ("Maze solved!");
      
      else
         System.out.println ("No solution.");

     
   }
}// class Maze