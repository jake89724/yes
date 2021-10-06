/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

/**
 *
 * @author j.head
 */
public class Item <T>{
    
    private T object;
    String contents;
    private String name;
    private int storageNumber;
    public Item(int storageNumber, String contents, T object){
        this.object = object;
        System.out.println(object + " <-- object");
        this.storageNumber = storageNumber;
        this.contents = contents;
        System.out.println(contents);
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public T getType(){
        return (T) object;
    }
    
}
