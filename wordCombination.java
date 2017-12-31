/*
You're given a vector of vectors of words, e.g.:
[['quick', 'lazy'], ['brown', 'black', 'grey'], ['fox', 'dog']].

Write a generalized function that prints all combinations of one word from the first vector, one word from the second vector, etc.
The solution may not use recursion.
NOTE: the number of vectors and number of elements within each vector may vary.

For the input above, it should print (in any order):
quick brown fox
quick brown dog
quick black fox
quick black dog
...
lazy grey dog
*/

class Solution {
  public static void main(String[] args) {

    //Definition of String arrays
    String[] array1 = new String[]{"quick", "lazy"};
    String[] array2 = new String[]{"brown", "black", "grey"};
    String[] array3 = new String[]{"fox", "dog"};

    String[][] arrays = {array1, array2, array3};
    
    ArrayList<String> strings = new ArrayList<String>();
    ArrayList<ArrayList<String>> finalResult = new ArrayList<ArrayList<String>>();

    int combinations = combine(arrays); //Define the number of all the possible combinations given the number of elements in the arrays

    //Each element in the array will be repeated according to a division of the total combinations.
    
    int division = combinations;
    // This for loop determines the number of times in which each element in the array will be repeated, in order to combine it with the
    //elements of the other arrays
    for (int i=0;i<arrays.length; i++){
    
    division = division/arrays[i].length;
    //Here I unwrap the 
    strings = unwrap(arrays[i],division,combinations);
    finalResult.add(strings);
    }

    //Print out the final result with all the combinations
    for (int i = 0; i<combinations;i++){

      for(int j = 0; j<finalResult.size();j++){

      System.out.print(finalResult.get(j).get(i)+ " ");
      }
      System.out.println(" ");
    }
  }
  
  //Function that unwraps all the possible combinations of the arrays of strings
  public static ArrayList<String> unwrap(String[] arrayInput, int repetitions, int combinations) {

    int repetitionTemp = repetitions;
    int length = arrayInput.length;
    int inicial = 0;
    ArrayList<String> result = new ArrayList<String>();

   for (int i = 0; i < combinations; i++) {

     if (repetitionTemp > 0) {
        //add to array list
       result.add(i, arrayInput[inicial]);
       repetitionTemp--;
    } else {
       repetitionTemp = repetitions-1;
       inicial++;
       //guard that inicial doesn't become bigger than the size. Start from begginin of array
        if(inicial >= arrayInput.length){
         inicial = 0;
        }
       result.add(i, arrayInput[inicial]);
    }
   }
    return result;
  }

  public static int combine(String[][] arrays){

    //Define combinations
    int combinations = 1;
    for (int i = 0; i < arrays.length; i++){
      int x = arrays[i].length;
      combinations = combinations * x;
    }
    return combinations;
  }

}
