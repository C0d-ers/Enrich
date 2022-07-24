package Others;

import org.testng.annotations.DataProvider;

public class data {
    @DataProvider(name = "Contacts One")
    public static Object [] [] Contacts() {
        Object[][] data = new Object[10][2];
        data[0][0] = "Original 17";
        data[0][1] = "605010150017";
        return data;
    }
    @DataProvider(name = "My Contacts")
    public static Object [] [] Contacts1(){
        Object[][] data = new Object[5][2];
        data [0][0] = "Frodo Baggins"; data [0][1] = "605010150021";
        data [1][0] = "Captain Colton"; data [1][1] = "605010150022";
        data [2][0] = "Obi-Wan Kenobi"; data [2][1] = "605010150043";
        data [3][0] = "Depa Billaba"; data [3][1] = "605010150050";
        data [4][0] = "Bail Organa"; data [4][1] = "606010160330";
//        data [5][0] = "Frodo Baggins"; data [5][1] = "605010150021";
//        data [6][0] = "Captain Colton"; data [6][1] = "605010150022";
//        data [7][0] = "Obi-Wan Kenobi"; data [7][1] = "605010150043";
//        data [8][0] = "Depa Billaba"; data [8][1] = "605010150048";
//        data [9][0] = "Bail Organa"; data [9][1] = "606010160330";

//        data [0][0] = "Original 17"; data [0][1] = "605010150017";
//        data [1][0] = "Original 18"; data [1][1] = "605010150018";
//        data [2][0] = "Original 19"; data [2][1] = "605010150019";
//        data [3][0] = "Original 20"; data [3][1] = "605010150020";
//        data [4][0] = "Original 21"; data [4][1] = "605010150021";
//        data [5][0] = "Original 22"; data [5][1] = "605010150022";
//        data [6][0] = "Original 23"; data [6][1] = "605010150023";
//        data [7][0] = "Original 24"; data [7][1] = "605010150024";
//        data [8][0] = "Original 25"; data [8][1] = "605010150025";
//        data [9][0] = "Original 26"; data [9][1] = "605010150026";

//        data [10][0] = "Original 17"; data [10][1] = "605010150040";
//        data [11][0] = "Original 18"; data [11][1] = "605010150041";
//        data [12][0] = "Original 19"; data [12][1] = "605010150042";
//        data [13][0] = "Original 20"; data [13][1] = "605010150043";
//        data [14][0] = "Original 21"; data [14][1] = "605010150044";
//        data [15][0] = "Original 22"; data [15][1] = "605010150045";
//        data [16][0] = "Original 23"; data [16][1] = "605010150046";
//        data [17][0] = "Original 24"; data [17][1] = "605010150047";
//        data [18][0] = "Original 25"; data [18][1] = "605010150048";
//        data [19][0] = "Original 26"; data [19][1] = "605010150051";

        return data;

        //604010150100
    }

    @DataProvider(name = "Contacts two")
    public static Object [] [] HariContacts(){
        Object[][] data = new Object[21][2];
        data [0][0] = "User 1"; data [0][1] = "60015777501";
        data [1][0] = "User 2"; data [1][1] = "601015777352";
        data [3][0] = "User 4"; data [3][1] = "601015777400";
        data [4][0] = "User 5"; data [4][1] = "60015777516";
        data [5][0] = "User 6"; data [5][1] = "601015777406";
        data [6][0] = "User 7"; data [6][1] = "601015777177";
        data [7][0] = "User 8"; data [7][1] = "601015777351";
        data [8][0] = "User 9"; data [8][1] = "60197775678";
        data [9][0] = "User 10"; data [9][1] = "60015777112";

        data [10][0] = "User 11"; data [10][1] = "600152436777";
        data [11][0] = "User 12"; data [11][1] = "601555777113";
        data [12][0] = "User 13"; data [12][1] = "601015777311";
        data [13][0] = "User 14"; data [13][1] = "601015777338";
        data [14][0] = "User 15"; data [14][1] = "601015777355";
        data [15][0] = "User 16"; data [15][1] = "601015777369";
        data [16][0] = "User 17"; data [16][1] = "601015777183";
        data [17][0] = "User 18"; data [17][1] = "600154177777";
        data [18][0] = "User 19"; data [18][1] = "601555777101";

        data [20][0] = "User 21"; data [20][1] = "601015777337";
        data [3][0] = "User 22"; data [3][1] = "601015777331";
        data [19][0] = "User 23"; data [19][1] = "601015777309";

        return data;

        //604010150100
    }

    @DataProvider(name = "HariContactsTransaction")
    public static Object [] [] ContactsForTransaction(){
        Object[][] data = new Object[10][2];
        data [0][0] = "H User 1"; data [0][1] = "60015777501";
        data [1][0] = "H User 2"; data [1][1] = "601015777352";
        data [2][0] = "H User 3"; data [2][1] = "601015777309";
        data [3][0] = "H User 4"; data [3][1] = "601015777400";
        data [4][0] = "H User 5"; data [4][1] = "60015777516";
        data [5][0] = "H User 6"; data [5][1] = "601015777311";
        data [6][0] = "H User 7"; data [6][1] = "601015777313";
        data [7][0] = "H User 8"; data [7][1] = "601015777337";
        data [8][0] = "H User 9"; data [8][1] = "601015777331";
        data [9][0] = "H User 10"; data [9][1] = "601015777309";

        return data;

        //604010150100
    }
    @DataProvider(name = "20KContacts")
    public static Object [] [] Twenty_K_Contacts(){
        Object[][] data = new Object[6][2];
        data [0][0] = "20 User 1"; data [0][1] = "604010150195";
        data [1][0] = "20 User 2"; data [1][1] = "606010160020";
        data [2][0] = "20 User 3"; data [2][1] = "604010150094";
        data [3][0] = "20 User 4"; data [3][1] = "604010150241";
        data [4][0] = "20 User 5"; data [4][1] = "604010150210";
        data [5][0] = "20 User 6"; data [5][1] = "60401015229";

        return data;
        //604010150100
    }
}
