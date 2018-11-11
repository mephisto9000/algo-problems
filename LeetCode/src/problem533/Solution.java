package problem533;

class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        
        int h = picture.length;
        int w = picture[0].length;
        String[] rows = new String[h];
        int[] rowCount = new int[h];
        int[] colCount = new int[w];
        int ans = 0;
            
        for (int i = 0; i < h; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < w; j++) {
                if (picture[i][j] == 'B') {
                    rowCount[i] ++;
                    colCount[j] ++;
                }   
                
                sb.append(picture[i][j]);
            }
            rows[i] = sb.toString();
        }
        
        
        for (int i = 0; i < h; i++)
            for (int j = 0; j< w; j++) {
                boolean ok = true;
                if (picture[i][j]=='B' && colCount[j]==rowCount[i]) {
                    for (int i2 = 0; i2 < h; i2++) {
                    	
                    	System.out.println(rows[i2]+" "+ rows[i]);
                        if (picture[i2][j]=='B' && !rows[i2].equals(rows[i])) {
                            ok=false;
                            break;
                        }
                    }
                    
                    if (ok)
                        ans++;
                        
                }
            }
        
        return ans;
        
    }
}