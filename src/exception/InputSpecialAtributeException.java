/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

public class InputSpecialAtributeException extends Exception{
    public String message(String jenis)
    {
        return "Atribut Tidak Sesuai untuk jenis " + jenis;
    }
}
