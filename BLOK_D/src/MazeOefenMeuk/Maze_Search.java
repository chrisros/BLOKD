package MazeOefenMeuk;

public class Maze_Search {


   public static void main (String[] args) {
   //================================================================//
   //  Level data, creates new Grid object with the start and finish //
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

    
    Grid doolhof = new Grid(grid, x, y);
    doolhof.printMaze();
    
    Solver solver = new Solver(doolhof);      
      if (solver.solve(y, x))
         System.out.println ("Maze solved!");
      
      else
         System.out.println ("No solution.");

     
   }
}// class Maze