/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applistaenlazada_doble;

/**
 *
 * @author 1005640772
 */
public class Nodo {
    private int code;
    private String name;
    private float mark1, mark2, mark3;
    private Nodo next;
    private Nodo before;

    public Nodo() {
        this.code=0;
        this.name=null;
        this.mark1=0;
        this.mark2=0;
        this.mark3=0;
        this.next=null;
        this.before=null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMark1() {
        return mark1;
    }

    public void setMark1(float mark1) {
        this.mark1 = mark1;
    }

    public float getMark2() {
        return mark2;
    }

    public void setMark2(float mark2) {
        this.mark2 = mark2;
    }

    public float getMark3() {
        return mark3;
    }

    public void setMark3(float mark3) {
        this.mark3 = mark3;
    }
    
    public Nodo getBefore() {
        return before;
    }

    public void setBefore(Nodo before) {
        this.before = before;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
    
    public float finalMark(){
        return (this.mark1+this.mark2+this.mark3)/3;
    }
    
    
}