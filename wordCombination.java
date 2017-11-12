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

    int combinations = combine(arrays);
    System.out.println("Combinations = " + combinations);

    //Determine the number by which I'm dividing
    int division = combinations;
    for (int i=0;i<arrays.length; i++){
    division = division/arrays[i].length;
    //System.out.println("Division = " + division);
    strings = unwrap(arrays[i],division,combinations);
    finalResult.add(strings);
    }

    //Print out
    for (int i = 0; i<combinations;i++){

      for(int j = 0; j<finalResult.size();j++){

      System.out.print(finalResult.get(j).get(i)+ " ");
      }
      System.out.println(" ");
    }

    /*
    for (String string : strings) {
      System.out.println(string);

    }
    */
  }

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

       //guard that inicial doesn't become bigger than the size. Start from begginin og array
        if(inicial >= arrayInput.length){
         inicial = 0;
        }

       result.add(i, arrayInput[inicial]);
    }

    //System.out.println(arrayInput[inicial]);
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
