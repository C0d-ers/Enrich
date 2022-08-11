package ExpenseAnalytics;

import org.testng.annotations.DataProvider;

public class categorylistDate {
    @DataProvider(name = "Category Name")
    public static Object[][] originalcategoryDetails(){
        Object[][] data = new Object[16][2];
        data [0][0] = "Education";             data [0][1] = data [0][0] + " 01";
        data [1][0] = "Entertainment";         data [1][1] = data [1][0] + " 02";
        data [2][0] = "Food & Beverage";       data [2][1] = data [2][0] + " 03";
        data [3][0] = "Health & Beauty";       data [3][1] = data [3][0] + " 04";
        data [4][0] = "Insurance";             data [4][1] = data [4][0] + " 05";
        data [5][0] = "Leisure & Sports";      data [5][1] = data [5][0] + " 06";
        data [6][0] = "Local councils";        data [6][1] = data [6][0] + " 07";
        data [7][0] = "Medical & Medicines";   data [7][1] = data [7][0] + " 08";
        data [8][0] = "Money Transfer";        data [8][1] = data [8][0] + " 09";
        data [9][0] = "Others";                data [9][1] = data [9][0] + " 10";
        data [10][0] = "Services";             data [10][1] = data [10][0] + " 11";
        data [11][0] = "Shopping";             data [11][1] = data [11][0] + " 12";
        data [12][0] = "Telecommunications";   data [12][1] = data [12][0] + " 13";
        data [13][0] = "Transportation";       data [13][1] = data [13][0] + " 14";
        data [14][0] = "Travel";               data [14][1] = data [14][0] + " 15";
        data [15][0] = "Utilities";            data [15][1] = data [15][0] + " 16";

        return data;
    }
    @DataProvider(name = "Custom Category Name")
    public static Object[][] customCategoryDetails(){

        Object[][] data = new Object[16][2];
        data [0][0] = "Education";             data [0][1] = "Kev kawm";
        data [1][0] = "Entertainment";         data [1][1] = "Kev lom zem";
        data [2][0] = "Food & Beverage";       data [2][1] = "Bebida alimenticia";
        data [3][0] = "Health & Beauty";       data [3][1] = "Salud y Belleza";
        data [4][0] = "Insurance";             data [4][1] = "Seguro";
        data [5][0] = "Leisure & Sports";      data [5][1] = "Ocio y Deportes";
        data [6][0] = "Local councils";        data [6][1] = "dewan lokal";
        data [7][0] = "Medical & Medicines";   data [7][1] = "Kedokteran & Kedokteran";
        data [8][0] = "Money Transfer";        data [8][1] = "Fa'aliliuga Tupe";
        data [9][0] = "Others";                data [9][1] = "O isi";
        data [10][0] = "Services";             data [10][1] = "Wengine";
        data [11][0] = "Shopping";             data [11][1] = "Ununuzi";
        data [12][0] = "Telecommunications";   data [12][1] = "Mawasiliano ya simu";
        data [13][0] = "Transportation";       data [13][1] = "Usafiri";
        data [14][0] = "Travel";               data [14][1] = "Viaxar";
        data [15][0] = "Utilities";            data [15][1] = "Utilidades";

        return data;
    }
    @DataProvider(name = "Change Transaction Category")
    public static Object[][] categoryDetails(){
        Object[][] data = new Object[5][2];
        data [0][0]  = "Education";             data [0][1]  =  "Dance class";
        data [1][0]  = "Entertainment";             data [1][1]  =  "Gaming";
        data [2][0]  = "Food & Beverage";       data [2][1]  =  "Bakery";
        data [3][0]  = "Health & Beauty";       data [3][1]  =  "Body massage";
        data [4][0]  = "Education";             data [4][1]  =  "Accident";
//        data [5][0]  = "Leisure & Sports";      data [5][1]  =  "Membership club";
//        data [6][0]  = "Local councils";        data [6][1]  =  "Assessment tax";
//        data [7][0]  = "Medical & Medicines";   data [7][1]  =  "Dental";
//        data [8][0]  = "Money Transfer";        data [8][1]  =  "";
//        data [9][0]  = "Others";                data [9][1]  =  "";
//        data [10][0] = "Services";              data [10][1] =  "";
//        data [11][0] = "Shopping";              data [11][1] =  "";
//        data [12][0] = "Others";                data [12][1] =  "";
//        data [13][0] = "Transportation";        data [13][1] =  "";
//        data [14][0] = "Others";                data [14][1] =  "";
//        data [15][0] = "Utilities";             data [15][1] =  "";

        return data;
    }
    @DataProvider(name = "Saving Box Details")
    public static Object[][] savingBoxDetails(){
        Object[][] data = new Object[5][4];
        data [0][0] = "Travel";              data [0][1] = "07";    data[0][2] = "28";     data[0][3] = "31";
        data [1][0] = "Emergency";           data [1][1] = "08";    data[1][2] = "1";     data[1][3] = "6";
        data [2][0] = "Family";              data [2][1] = "08";    data[2][2] = "6";     data[2][3] = "14";
        data [3][0] = "Shopping";            data [3][1] = "08";    data[3][2] = "15";     data[3][3] = "19";
        data [4][0] = "Others";              data [4][1] = "08";    data[4][2] = "22";     data[4][3] = "31";

        return data;
    }
    @DataProvider(name = "TripTrackerDetails")
    public static Object[][] tripTracker(){
        Object[][] data = new Object[4][2];
        data [0][0] = "18";           data [0][1] = "21";
        data [1][0] = "21";           data [1][1] = "23";
        data [2][0] = "24";           data [2][1] = "29";
        data [3][0] = "29";           data [3][1] = "31";
        //data [4][0] = "";           data [4][1] = "05";

        return data;
    }
}
