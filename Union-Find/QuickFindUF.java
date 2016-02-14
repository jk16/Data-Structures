/*
Quick-Find

0
|
|
|
5_______6   

1_______2
        |
        |
        |
        7

3_______4
|       |
|       |
|       |
8       9

Data Structure:
    *Integer array id[] of size N
    *Interpretation: q and q are connectd iff they have the same id
    *Interpretation: q and q are connectd iff they have the same id

id[] = [0,1,1,8,8,0,0,1,8,8]
* 0,5,6 connected
* 1,2,7 connected
* 3,4,8,9 connected

Methods:
Find --> check if p and q are connected
    * id[6] =0, id[1] = 1 --> id[6] == id[1] --> false

Union --> Merge components containing p and q by changing entries whose id equals
                id[p] to: id[q].
    * Union(6,1): p=6 and q=1
        * since p=6 we need to change the connected components of 6 ie {0,5,6}
            * [0,1,1,8,8,0,0,1,8,8] --> [1,1,1,8,8,1,1,1,8,8]

*/
