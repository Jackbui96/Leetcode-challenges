import java.util.LinkedList;
import java.util.Queue;

public class IslandPerimeterSolution {

    public static void main(String[] args) {
        int[][] arr = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        System.out.println(islandPerimeter(arr));
    }

    public static int islandPerimeter(int[][] grid) {
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] checkedCoordinate = new boolean[grid.length][grid[0].length];
        boolean found = false;
        int perimeter = 0;

        // Traverse from top left to bottom right for our first land
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    Coordinate land = new Coordinate(row, col);
                    queue.add(land);
                    checkedCoordinate[row][col] = true;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }


        while (!queue.isEmpty()) {
            Coordinate currentLand = queue.remove();
            int numberOfNeighbors = 0;

            // Check Left Node
            if (currentLand.col != 0) {
                if (grid[currentLand.row][currentLand.col - 1] == 1) {
                    numberOfNeighbors++;
                    if (!checkedCoordinate[currentLand.row][currentLand.col - 1]) {
                        checkedCoordinate[currentLand.row][currentLand.col - 1] = true;
                        Coordinate left = new Coordinate(currentLand.row, currentLand.col - 1);
                        queue.add(left);
                    }
                }
            }

            // Check Above Node
            if (currentLand.row != 0) {
                if (grid[currentLand.row - 1][currentLand.col] == 1) {
                    numberOfNeighbors++;
                    if (!checkedCoordinate[currentLand.row - 1][currentLand.col]) {
                        checkedCoordinate[currentLand.row - 1][currentLand.col] = true;
                        Coordinate above = new Coordinate(currentLand.row - 1, currentLand.col);
                        queue.add(above);
                    }
                }
            }


            // Check Right Node
            if (currentLand.col != grid[currentLand.row].length - 1) {
                if (grid[currentLand.row][currentLand.col + 1] == 1) {
                    numberOfNeighbors++;
                    if (!checkedCoordinate[currentLand.row][currentLand.col + 1]) {
                        checkedCoordinate[currentLand.row][currentLand.col + 1] = true;
                        Coordinate right = new Coordinate(currentLand.row, currentLand.col + 1);
                        queue.add(right);
                    }
                }
            }


            // Check Below Node
            if (currentLand.row != grid.length - 1) {
                if (grid[currentLand.row + 1][currentLand.col] == 1) {
                    numberOfNeighbors++;
                    if (!checkedCoordinate[currentLand.row + 1][currentLand.col]) {
                        checkedCoordinate[currentLand.row + 1][currentLand.col] = true;
                        Coordinate below = new Coordinate(currentLand.row + 1, currentLand.col);
                        queue.add(below);
                    }
                }
            }

            perimeter = perimeter + (4 - numberOfNeighbors);
        }

        return perimeter;
    }
}

class Coordinate {
    int row;
    int col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
