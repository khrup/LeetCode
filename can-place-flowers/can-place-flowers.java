class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        //1. for문을 돌려서 1이 있으면 넘어간다
        //2. 0일때 양 인덱스에 1이 있는지 확인 없으면 n--;
        for(int i = 0 ; i < flowerbed.length && n > 0; i++){

            if(flowerbed.length > 1) {
                if (i - 1 >= 0 && i + 1 < flowerbed.length) {
                    if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                        n--;
                        flowerbed[i] = 1;
                    }
                } else if (i == 0) {
                    if (flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                        n--;
                        flowerbed[i] = 1;
                    }

                } else if (i == flowerbed.length - 1) {
                    if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                        n--;
                        flowerbed[i] = 1;
                    }
                }
            }else{
                if(flowerbed[i] == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
        }

        return n == 0;
    }
}