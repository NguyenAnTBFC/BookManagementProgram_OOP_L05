/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.Iterator;
import java.util.TreeSet;
import model.Book;
import view.Figure2View;

/**
 *
 * @author NguyenAn;
 */
public class Figure2Controler {

    private Figure2View figure2View;
    private TreeSet<Book> listBooks = new TreeSet<>();

    public Figure2Controler(Figure2View figure2View) {
        this.figure2View = figure2View;
    }
//
    public void overrideOldBook(Book book) {
        Iterator<Book> iterator = listBooks.iterator();
        while (iterator.hasNext()) {
            Book b = iterator.next();
            if(b.getBookId().equals(book.getBookId())){
                iterator.remove();
                break;
            }
        }
        listBooks.add(book);
    }
    public void clearJTextFiel(){
        figure2View.setTxtBookId("");
        figure2View.setTxtAuthors("");
        figure2View.setTxtTitle("");
        figure2View.setTxtDOP("");
        figure2View.setTxtCategories("");
    }
    public void clickBtnEnter() throws ParseException {
        Book book = new Book();
        book.setBookId(figure2View.getTxtBookId().getText());
        book.setAuthors(figure2View.getTxtAuthors().getText());
        book.setTitle(figure2View.getTxtTitle().getText());
        book.setDateOfPublication(figure2View.getTxtDOP().getText());
        book.setCategories(figure2View.getTxtCategories().getText());
        this.overrideOldBook(book);
        
        System.out.println(book);
        System.out.println("---------------");
        for (Book listBook : listBooks) {
            System.out.println(listBook);
        }
        System.out.println("---------------");
        this.clearJTextFiel();
        
    }

    public void saveListBooksToFile() {
        String filePath = "D:\\Code\\Java\\OOP_L05\\BookManagementProgram\\src\\model\\Books.dat";
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(listBooks);
//            System.out.println("write success");
        } catch (Exception e) {
//            System.out.println("write fail");
        }
    }

    public void getListBooksToFile() {
        String filePath = "D:\\Code\\Java\\OOP_L05\\BookManagementProgram\\src\\model\\Books.dat";
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            TreeSet<Book> readTreeSet = (TreeSet<Book>) inputStream.readObject();
            listBooks.addAll(readTreeSet);
//            System.out.println("read success");
        } catch (Exception e) {
//            System.out.println("read fail");
        }
    }

    public void clickBtnSave() {
        this.getListBooksToFile();
        this.saveListBooksToFile();
    }
}
