package Others;

import org.testng.annotations.DataProvider;

public class data {
    @DataProvider(name = "My Contacts")
    public static Object [] [] Contacts1(){
        Object[][] data = new Object[10][2];
        data [0][0] = "Frodo Baggins";      data [0][1] = "605010150040";
        data [1][0] = "Captain Colton";     data [1][1] = "605010150038";
        data [2][0] = "Obi-Wan Kenobi";     data [2][1] = "605010150025";
        data [3][0] = "Depa Billaba";       data [3][1] = "605010150027";
        data [4][0] = "Bail Organa";        data [4][1] = "605010150028";
        data [5][0] = "Joyce Byers";        data [5][1] = "605010150053";
        data [6][0] = "Mike Wheeler";       data [6][1] = "605010150087";
        data [7][0] = "Dustin Henderson";   data [7][1] = "605010150034";
        data [8][0] = "Nancy Wheeler";      data [8][1] = "605010150020";
        data [9][0] = "Will Byers";         data [9][1] = "605010150039";
        return data;
    }
    @DataProvider(name = "Left Contacts")
    public static Object [] [] Contacts(){
        Object[][] data = new Object[5][2];
        data [3][0] = "Mike Wheeler";       data [3][1] = "605010150087";
        data [2][0] = "Dustin Henderson";   data [2][1] = "605010150034";
        data [1][0] = "Nancy Wheeler";      data [1][1] = "605010150020";
        //data [0][0] = "Will Byers";         data [0][1] = "605010150039";
        data [0][0] = "Joyce Byers";        data [0][1] = "605010150053";
        return data;
    }
}
