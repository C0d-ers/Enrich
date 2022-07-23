package SecondayNumber;

import org.testng.annotations.DataProvider;

public class countryLists {
    @DataProvider(name = "Country Lists")
    public static Object[][] categoryDetails(){
        Object[][] data = new Object[46][2];
        data [0][0] = "Andorra";                data [0][1]  = " 01";
        data [1][0] = "Australia";              data [1][1]  = " 02";
        data [2][0] = "Austria";                data [2][1]  = " 03";
        data [3][0] = "Belgium";                data [3][1]  = " 04";
        data [4][0] = "Canada";                 data [4][1]  = " 05";
        data [5][0] = "China";                  data [5][1]  = " 06";
        data [6][0] = "Cyprus";                 data [6][1]  = " 07";
        data [7][0] = "Estonia";                data [7][1]  = " 08";
        data [8][0] = "Finland";                data [8][1]  = " 09";
        data [9][0] = "France";                 data [9][1]  = " 10";
        data [10][0] = "Germany";               data [10][1] = " 11";
        data [11][0] = "Greece";                data [11][1] = " 12";
        data [12][0] = "Hong Kong";             data [12][1] = " 13";
        data [13][0] = "India";                 data [13][1] = " 14";
        data [14][0] = "Indonesia";             data [14][1] = " 15";
        data [15][0] = "Ireland";               data [15][1] = " 16";

        data [16][0] = "Italy";                 data [16][1] = " 01";
        data [17][0] = "Japan";                 data [17][1] = " 02";
        data [18][0] = "Kosovo";                data [18][1] = " 03";
        data [19][0] = "Latvia";                data [19][1] = " 04";
        data [20][0] = "Lithuania";             data [20][1] = " 05";
        data [21][0] = "Luxembourg";            data [21][1] = " 06";
        data [22][0] = "Malta";                 data [22][1] = " 07";
        data [23][0] = "Monaco";                data [23][1] = " 08";
        data [24][0] = "Montenegro";            data [24][1] = " 09";
        data [25][0] = "Myammar";               data [25][1] = " 10";
        data [26][0] = "Nepal";                 data [26][1] = " 11";
        data [27][0] = "Netherlands";           data [27][1] = " 12";
        data [28][0] = "New Zealand";           data [28][1] = " 13";
        data [29][0] = "Philippines";           data [29][1] = " 14";
        data [31][0] = "San Marino";            data [31][1] = " 16";
        data [30][0] = "Portugal";              data [30][1] = " 15";

        data [32][0] = "Saudi Arabia";          data [32][1] = " 01";
        data [33][0] = "Singapore";             data [33][1] = " 02";
        data [34][0] = "Slovakia";              data [34][1] = " 03";
        data [35][0] = "Slovenia";              data [35][1] = " 04";
        data [36][0] = "South Korea";           data [36][1] = " 05";
        data [37][0] = "Spain";                 data [37][1] = " 06";
        data [38][0] = "Switzerland";           data [38][1] = " 07";
        data [39][0] = "Taiwan";                data [39][1] = " 08";
        data [40][0] = "Thailand";              data [40][1] = " 09";
        data [41][0] = "United Arab Emirates";  data [41][1] = " 10";
        data [42][0] = "United Kingdom";        data [42][1] = " 11";
        data [43][0] = "USA";                   data [43][1] = " 12";
        data [44][0] = "Vatican City";          data [44][1] = " 13";
        data [45][0] = "Vietnam";               data [45][1] = " 14";

        return data;
    }
}
