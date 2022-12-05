package utils;

public class HexagonalUtils {




    public float[][][] gridCenter(float[][][] coordinates){
        float xshift = (coordinates.length % 2 == 0)? (float)coordinates.length / 2:(float)(coordinates.length-1)/2 ;
        float yshift = (coordinates[0].length % 2 == 0)? (float)coordinates[0].length / 2:(float)(coordinates[0].length-1)/2 ;
        for (int i = 0; i < coordinates.length; ++i) {
            for(int j = 0; j < coordinates[i].length; ++j) {
                coordinates[i][j][0] = coordinates[i][j][0] - xshift;
                coordinates[i][j][1] = coordinates[i][j][1] - yshift;
            }
        }
        return coordinates;
    }

    public float[][][] gridHexagonalise(float[][][] coordinates){
        float ratio = (float) (Math.sqrt(3)/6);
        for (int i = 0; i < coordinates.length; ++i) {
            for(int j = 0; j < coordinates[i].length; ++j) {
                if (coordinates.length/2%2 == 1){
                    if (j%2==0){
                        coordinates[i][j][0] = coordinates[i][j][0]+(float)1/2;}
                }
                else{
                    if (j%2==1){
                        coordinates[i][j][0] = coordinates[i][j][0]+(float)1/2;}
                }
                coordinates[i][j][1] = coordinates[i][j][1]*ratio;
            }
        }
        return coordinates;
    }


    public float[][][] gridNormalize(float[][][] coordinates){
        float norm = (coordinates[coordinates.length-1][0][0] - coordinates[0][0][0])/2;
        for (int i = 0; i < coordinates.length; ++i) {
            for(int j = 0; j < coordinates[i].length; ++j) {
                coordinates[i][j][0] = coordinates[i][j][0] /norm;
                coordinates[i][j][1] = coordinates[i][j][1] /norm;
            }
        }
        return coordinates;
    }

}
