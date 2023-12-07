/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.TreeSet;
import javax.swing.DefaultListModel;
import model.Book;
import view.Figure3View;

/**
 *
 * @author NguyenAn;
 */
public class Figure3Controler {
    private Figure3View figure3View;
    private TreeSet<Book> listBooks = new TreeSet<>();

    public Figure3Controler(Figure3View figure3View) {
        this.figure3View = figure3View;
    }
    
   
    public void getListBooksToFile(){
        String filePath = "D:\\Code\\Java\\OOP_L05\\BookManagementProgram\\src\\model\\Books.dat";
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))){
            TreeSet<Book> readTreeSet = (TreeSet<Book>) inputStream.readObject();
            listBooks.addAll(readTreeSet);
            System.out.println("read success");
            for (Book listBook : listBooks) {
                System.out.println(listBook);
            }
        } catch (Exception e) {
            System.out.println("read fail");
        }
    }
    //
    public DefaultListModel<String> createListBooksId(){
        this.getListBooksToFile();
        TreeSet<String> idTreeSet = new TreeSet<>();
        for (Book listBook : listBooks) {
            idTreeSet.add(listBook.getBookId());
        }
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String item : idTreeSet) {
            listModel.addElement(item);
        }
        return listModel;
    }
    
    public void displayInfo(Book book){
        figure3View.setLblAuthors(book.getAuthors());
        figure3View.setLblTitle(book.getTitle());
        figure3View.setLblDOP(book.getDateOfPublication());
        figure3View.setLblCategories(book.getCategories());
    }
    public void clickBookIdValue(String id){
        
        for (Book listBook : listBooks) {
            if(listBook.getBookId().equals(id)){
                this.displayInfo(listBook);
            }
        }
    }
    
    
    
}
