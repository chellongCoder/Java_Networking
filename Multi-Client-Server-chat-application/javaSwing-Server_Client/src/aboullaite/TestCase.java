/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aboullaite;

/**
 *
 * @author chellong
 */
public class TestCase {
    public static void main(String[] args) {
        //TextInput input = new NumericInput();
        //input.add('1');
        //input.add('a');
        //input.add('0');
        //System.out.println(input.getValue());
        String[] array = new String[] {"Larry", "Curly", "Moe"};  // Array of size 3, filled with stooges.
        for(int i=0; i<array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
