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
public class ListaEnlazadaDoble {
    private Nodo head;//Controla el primer Nodo de la lista

    public ListaEnlazadaDoble() {
        this.head=null;
    }

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }
    
    public Nodo lastNode(){
        Nodo temp = this.head;
        
        while(temp!=null){
            //temp = (temp.getNext() == null) ? null : temp.getNext();
            if (temp.getNext() == null) {
                break;
            }else{
                temp=temp.getNext();
            }
        }
        
        return temp;
    }
    
    public void putNodeInFirstPlace(Nodo newNode){
        if(this.head==null){
            this.setHead(newNode);//Enlace
        }else{
            newNode.setNext(this.head);
            newNode.setBefore(null);
            this.head.setBefore(newNode);
            this.head = newNode;
        }
    }
    
    public void putNodeInTheMiddle(Nodo nodeToWork, Nodo newNode, boolean next){
        Nodo temp = this.head;
        Nodo aux;
        Nodo before;
        
        while(temp!=null){
            if(!next){
                if(temp==nodeToWork.getBefore()){
                    before=temp;
                    aux = nodeToWork;
                    
                    newNode.setBefore(before);
                    newNode.setNext(aux);
                    
                    before.setNext(newNode);
                    nodeToWork.setBefore(newNode);
                    
                    break;
                }
            }else{
                if(temp == nodeToWork){
                    before=temp;
                    aux=temp.getNext();
                    
                    newNode.setBefore(before);
                    newNode.setNext(aux);
                    
                    temp.setNext(newNode);
                    aux.setBefore(newNode);
                    
                    break;
                }
            }
            temp = temp.getNext();
        }
    }
    
    /*
    Metodo para recorrer la lista y contar cuántos nodos hay almacenados
    */
    
    public int getNodesLenght(){
        Nodo temp = this.head;
        int count = 0;
        
        while(temp!=null){
            count++;
            temp = temp.getNext();
        }
        
        return count;
    }
    /*
    Metodo para agregar un nuevo Nodo en la lista
    Principio, intermedio y final
    
    Se va a hacer por final
    */
    public void addNodeToEnd(Nodo newNode){
        if(this.head==null){
            this.setHead(newNode);//Enlace
        }else{
            Nodo temp = lastNode();
            newNode.setBefore(temp);
            newNode.setNext(null);
            
            lastNode().setNext(newNode);
        }
    }
    
    /*
    Metodo de busqueda de un Nodo dentro de la lista,
    pasando como parametro el codigo del estudiante
    */
    
    public Nodo searchNode(int code){
        Nodo temp = this.head;
        
        while(temp!=null){
            if (temp.getCode()==code) {
                break;
            } else {
                temp = temp.getNext();
            }
        }
        
        return temp;
    }
    
    //Eliminar el Nodo de la lista, pasando como parametro
    //el Nodo a eliminar
    
    public void deleteNode(Nodo nodeToDelete){
        Nodo prev ;
        if(nodeToDelete==this.head){
            this.head=this.head.getNext();
        }else{
            prev = this.head;
            while (prev.getNext()!= nodeToDelete) {                
                prev=prev.getNext();
            }
            prev.setNext(nodeToDelete.getNext());
        }
        
        nodeToDelete.setNext(null);
        
    }
    
    /*
    Implementar metodo que calcula el promedio de las notas
    */
    public float generalNote(){
        int cant = 0;
        float add = 0;
        Nodo temp = this.head;
        
        while(temp!=null){
            cant++;
            add += temp.finalMark();
            temp=temp.getNext();
        }
        
        if(cant > 0){
            return add/cant;
        }else{
            return 0;
        }
        
    }
    
    public float theHighestMark(){
        float finalMark;
        float maxMark=0;
        Nodo temp = this.head;
        
        while(temp!=null){
            finalMark=temp.finalMark();
            
            if(finalMark>maxMark){
                maxMark = finalMark;
            }
            
            temp = temp.getNext();
        }
        
        return maxMark;
    }
    
    public void clean(){
        while(this.head!=null){
            deleteNode(this.head);
        }
    }
    
    //Se coge el metodo burbuja y se acomoda a lo requerido
    public void bubbleMethod(){
        Nodo temp;
        int i=0;
        Nodo aux;
            
        while(i<this.getNodesLenght()){
            temp = this.head;
            
            while(temp!=null){
                
                if(temp.getNext()!=null){
                    if(temp.getCode()>temp.getNext().getCode()){
                        aux = temp;
                        temp = temp.getNext();
                        temp.setNext(aux);
                    }
                }
            
                temp=temp.getNext();
            }

            i++;
        }
        
        System.out.println("Termino la ejecucion");
        
    }
}